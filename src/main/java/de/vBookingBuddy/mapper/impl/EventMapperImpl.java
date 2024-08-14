package de.vBookingBuddy.mapper.impl;

import de.vBookingBuddy.entity.EventEntity;
import de.vBookingBuddy.model.EventContainer;
import jakarta.inject.Singleton;

import java.util.List;
import java.util.stream.Collectors;

@Singleton
public class EventMapperImpl implements de.vBookingBuddy.mapper.EventMapper {
    @Override
    public EventContainer toResponse(List<EventEntity> eventEntities) {
        return new EventContainer(
                eventEntities
                        .stream()
                        .map(eventEntity -> new EventContainer.Event(
                                        eventEntity.getId(),
                                        eventEntity.isAllDay(),
                                        eventEntity.getStart(),
                                        eventEntity.getEnd(),
                                        eventEntity.getTitle(),
                                        eventEntity.getBackgroundColor()
                                )

                        ).collect(Collectors.toList())
        );
    }
}
