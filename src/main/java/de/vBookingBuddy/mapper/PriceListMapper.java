package de.vBookingBuddy.mapper;

import de.vBookingBuddy.model.PriceListResponse;
import jakarta.inject.Singleton;

@Singleton
public interface PriceListMapper {
    public PriceListResponse toResponse(de.vBookingBuddy.model.PriceList priceList);
}
