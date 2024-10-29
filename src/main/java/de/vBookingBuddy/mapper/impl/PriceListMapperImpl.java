package de.vBookingBuddy.mapper.impl;

import de.vBookingBuddy.mapper.PriceListMapper;
import de.vBookingBuddy.model.PriceListResponse;
import jakarta.inject.Singleton;

@Singleton
public class PriceListMapperImpl implements PriceListMapper {
    @Override
    public PriceListResponse toResponse(de.vBookingBuddy.model.PriceList priceList) {
        return new PriceListResponse(
                priceList.getBasePrice(),
                priceList.getPartyBox(),
                priceList.getLightCube(),
                priceList.getGrill(),
                priceList.getDiscountMemberGVE(),
                priceList.getDiscountAllCubes(),
                priceList.getDeposit()
        );
    }
}
