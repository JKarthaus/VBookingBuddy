package de.vBookingBuddy.model;

import io.micronaut.serde.annotation.Serdeable;
import lombok.Data;

import java.time.Instant;

@Data
@Serdeable
public class ReservationRequest {
    Instant date;
    String name;
    String email;
    String phone;
    Boolean partyBox;
    Boolean lightCube;
    Integer cubeCount;
    Boolean grill;
    Boolean gveMember;
    Boolean agedGuests;
}
