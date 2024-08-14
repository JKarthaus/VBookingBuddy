package de.vBookingBuddy.mapper;

import de.vBookingBuddy.entity.EventEntity;
import de.vBookingBuddy.model.EventContainer;
import jakarta.inject.Singleton;

import java.util.List;

@Singleton
public interface EventMapper {
    public EventContainer toResponse(List<EventEntity> eventEntities);
}
