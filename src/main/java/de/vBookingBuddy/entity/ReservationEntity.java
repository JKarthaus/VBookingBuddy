package de.vBookingBuddy.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.threeten.bp.Instant;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReservationEntity {
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
    List<String> history;
    Boolean accepted;
}
