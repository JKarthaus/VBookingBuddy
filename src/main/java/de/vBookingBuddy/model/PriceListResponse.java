package de.vBookingBuddy.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.micronaut.serde.annotation.Serdeable;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Serdeable
@JsonInclude(JsonInclude.Include.ALWAYS)
public class PriceListResponse {
    double basePrice;
    double partyBox;
    double lightCube;
    double grill;
    double discountMemberGVE;
    double discountAllCubes;
    double deposit;
}
