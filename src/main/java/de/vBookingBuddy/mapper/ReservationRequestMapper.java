package de.vBookingBuddy.mapper;

import de.vBookingBuddy.model.ReservationRequest;
import jakarta.inject.Singleton;

import java.util.Map;

@Singleton
public interface ReservationRequestMapper {
    Map<String, Object> toEntity(ReservationRequest reservationRequest);
}
