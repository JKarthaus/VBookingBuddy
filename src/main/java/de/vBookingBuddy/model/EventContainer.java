package de.vBookingBuddy.model;

import io.micronaut.serde.annotation.Serdeable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Serdeable
public class EventContainer {
    List<Event> events;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Serdeable
    public static class Event {
        String id;
        boolean allDay;
        Date start;
        Date end;
        String title;
        String backgroundColor;
    }

}
