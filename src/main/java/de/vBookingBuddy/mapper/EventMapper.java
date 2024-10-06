package de.vBookingBuddy.mapper;

import de.vBookingBuddy.entity.EventEntity;
import de.vBookingBuddy.model.FullCalendarEvent;
import jakarta.inject.Singleton;

import java.util.List;
import java.util.Optional;

@Singleton
public interface EventMapper {
    public List<FullCalendarEvent> toResponse(List<EventEntity> eventEntities);

    public Optional<FullCalendarEvent> toResponse(Optional<EventEntity> eventEntity);
}
