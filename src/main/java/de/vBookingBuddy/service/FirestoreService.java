package de.vBookingBuddy.service;

import de.vBookingBuddy.entity.EventEntity;
import jakarta.inject.Singleton;

import java.util.List;
import java.util.concurrent.ExecutionException;

@Singleton
public interface FirestoreService {

    public List<EventEntity> getPublicCalendarData() throws ExecutionException, InterruptedException;

}
