package de.vBookingBuddy.service.impl;

import de.vBookingBuddy.model.PriceList;
import de.vBookingBuddy.service.PriceService;
import io.micronaut.core.io.ResourceLoader;
import io.micronaut.serde.ObjectMapper;
import jakarta.inject.Singleton;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.PostConstruct;
import java.io.IOException;

@Singleton
@RequiredArgsConstructor
@Slf4j
public class PriceServiceImpl implements PriceService {

    final ObjectMapper objectMapper;
    final ResourceLoader loader;
    private PriceList priceList = new PriceList();

    @PostConstruct
    public void init() {
        try {
            priceList = objectMapper.readValue(
                    loader.getResourceAsStream("classpath:static/priceList.json").get(),
                    PriceList.class
            );
            log.info("Price list loaded from resources File");
        } catch (IOException e) {
            log.error("ERROR loading price list");
            throw new RuntimeException(e);
        }
    }

    @Override
    public PriceList getPriceList() {
        return priceList;
    }
}
