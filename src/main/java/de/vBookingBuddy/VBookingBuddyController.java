package de.vBookingBuddy;

import de.vBookingBuddy.data.FirestoreService;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutionException;

@Controller("/VBookingBuddy")
@RequiredArgsConstructor
@Slf4j
public class VBookingBuddyController {

    private final FirestoreService firestoreService;

    @Get(uri = "/", produces = "text/plain")
    public String getCalendarData() {
        try {
            firestoreService.getPublicCalendarData();
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        log.info(";.)");
        return "Example Response";
    }
}
