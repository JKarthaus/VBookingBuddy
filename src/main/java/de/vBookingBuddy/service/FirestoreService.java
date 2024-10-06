package de.vBookingBuddy.service;

import de.vBookingBuddy.entity.EventEntity;
import jakarta.inject.Singleton;

import java.time.Instant;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Singleton
public interface FirestoreService {

    List<EventEntity> getPublicCalendarData(Instant start, Instant end) throws ExecutionException, InterruptedException;

    List<EventEntity> getEventsAtDate(Instant eventDate) throws ExecutionException, InterruptedException;
}
