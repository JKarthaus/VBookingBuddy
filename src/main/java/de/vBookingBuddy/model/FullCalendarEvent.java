package de.vBookingBuddy.model;

import io.micronaut.serde.annotation.Serdeable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Serdeable
public class FullCalendarEvent {
    String id;
    boolean allDay;
    Date start;
    Date end;
    String title;
    String backgroundColor;
}


