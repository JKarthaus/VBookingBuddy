package de.vBookingBuddy.data;

import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import com.google.firebase.database.FirebaseDatabase;
import jakarta.annotation.PostConstruct;
import jakarta.inject.Singleton;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Singleton
@Slf4j
public class FirestoreService {

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

    public void getPublicCalendarData() throws ExecutionException, InterruptedException {
        // asynchronously retrieve all documents
        ApiFuture<QuerySnapshot> future = firestore.collection("events").get();
        // future.get() blocks on response
        List<QueryDocumentSnapshot> documents = future.get().getDocuments();
        for (QueryDocumentSnapshot document : documents) {
            System.out.println(document);
        }

    }

}
