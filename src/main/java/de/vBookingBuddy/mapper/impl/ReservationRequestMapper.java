package de.vBookingBuddy.mapper.impl;

import de.vBookingBuddy.model.ReservationRequest;
import jakarta.inject.Singleton;

import java.util.HashMap;
import java.util.Map;

@Singleton
public class ReservationRequestMapper implements de.vBookingBuddy.mapper.ReservationRequestMapper {

    @Override
    public Map<String, Object> toEntity(ReservationRequest reservationRequest) {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("date", reservationRequest.getDate());
        result.put("name", reservationRequest.getName());
        result.put("eMail", reservationRequest.getEmail());
        result.put("phone", reservationRequest.getPhone());
        result.put("isGrill", reservationRequest.getGrill());
        result.put("isAgedGuests", reservationRequest.getAgedGuests());
        result.put("isLightCube", reservationRequest.getLightCube());
        result.put("cubeCount", reservationRequest.getCubeCount());
        result.put("isPartyBox", reservationRequest.getPartyBox());
        return result;
    }

}
