package de.vBookingBuddy.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventEntity {
    String id;
    boolean allDay;
    Date start;
    Date end;
    String title;
    String backgroundColor;
}
