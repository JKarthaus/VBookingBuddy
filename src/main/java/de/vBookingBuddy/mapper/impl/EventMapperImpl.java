package de.vBookingBuddy.mapper.impl;

import de.vBookingBuddy.entity.EventEntity;
import de.vBookingBuddy.model.FullCalendarEvent;
import jakarta.inject.Singleton;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Singleton
public class EventMapperImpl implements de.vBookingBuddy.mapper.EventMapper {
    @Override
    public List<FullCalendarEvent> toResponse(List<EventEntity> eventEntities) {
        return eventEntities
                .stream()
                .map(eventEntity -> new FullCalendarEvent(
                                eventEntity.getId(),
                                eventEntity.isAllDay(),
                                eventEntity.getStart(),
                                eventEntity.getEnd(),
                                eventEntity.getTitle(),
                                eventEntity.getBackgroundColor()
                        )

                ).collect(Collectors.toList());
    }

    @Override
    public Optional<FullCalendarEvent> toResponse(Optional<EventEntity> eventEntity) {
        if (eventEntity.isEmpty()) {
            return Optional.empty();
        } else {
            return Optional.of(new FullCalendarEvent(
                            eventEntity.get().getId(),
                            eventEntity.get().isAllDay(),
                            eventEntity.get().getStart(),
                            eventEntity.get().getEnd(),
                            eventEntity.get().getTitle(),
                            eventEntity.get().getBackgroundColor()
                    )
            );
        }
    }
}
