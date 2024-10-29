package de.vBookingBuddy.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.micronaut.serde.annotation.Serdeable;
import lombok.Data;

@Data
@Serdeable
@JsonInclude(JsonInclude.Include.ALWAYS)
public class PriceList {
    double basePrice;
    double partyBox;
    double lightCube;
    double grill;
    double discountMemberGVE;
    double discountAllCubes;
    double deposit;
}
