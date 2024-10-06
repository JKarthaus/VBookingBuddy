package de.vBookingBuddy.service.impl;

import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.Timestamp;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import com.google.firebase.database.FirebaseDatabase;
import de.vBookingBuddy.entity.EventEntity;
import de.vBookingBuddy.service.FirestoreService;
import jakarta.annotation.PostConstruct;
import jakarta.inject.Singleton;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.time.Instant;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Singleton
@Slf4j
public class FirestoreServiceImpl implements FirestoreService {

    private FirebaseApp firebaseApp;
    private FirebaseDatabase database;
    Firestore firestore;

    @PostConstruct
    private void init() throws IOException {
        FirebaseOptions options = FirebaseOptions.builder()
                .setCredentials(GoogleCredentials.getApplicationDefault())
                .setProjectId("gve-reservationbuddy")
                .setDatabaseUrl("https://601521970614.firebaseio.com")
                .build();
        firebaseApp = FirebaseApp.initializeApp(options);
        database = FirebaseDatabase.getInstance(firebaseApp);
        firestore = FirestoreClient.getFirestore();
    }

    @Override
    public List<EventEntity> getPublicCalendarData(Instant start, Instant end) throws ExecutionException, InterruptedException {
        List<EventEntity> eventEntities = new ArrayList<>();
        // asynchronously retrieve all documents
        ApiFuture<QuerySnapshot> future = firestore.collection("events")
                .whereGreaterThan("dateStart", Timestamp.of(Date.from(start)))
                .whereLessThan("dateEnd", Timestamp.of(Date.from(end)))
                .get();
        // future.get() blocks on response
        List<QueryDocumentSnapshot> documents = future.get().getDocuments();
        for (QueryDocumentSnapshot document : documents) {
            String color = "yellow";
            if (document.get("state").equals("booked")) {
                color = "green";
            }
            eventEntities.add(
                    new EventEntity(
                            document.getId(),
                            true,
                            document.get("dateStart", Timestamp.class).toDate(),
                            document.get("dateEnd", Timestamp.class).toDate(),
                            document.getString("description"),
                            color
                    )
            );
        }
        return eventEntities;
    }

    @Override
    public List<EventEntity> getEventsAtDate(Instant eventDate) throws ExecutionException, InterruptedException {
        return getPublicCalendarData(
                eventDate
                        .atZone(ZoneOffset.of("Europe/Berlin"))
                        .withHour(0)
                        .withMinute(0)
                        .toInstant(),
                eventDate
                        .atZone(ZoneOffset.of("Europe/Berlin"))
                        .withHour(24)
                        .withMinute(0)
                        .toInstant()
        );
    }

}
