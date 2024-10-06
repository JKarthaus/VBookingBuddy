package de.vBookingBuddy;

import de.vBookingBuddy.mapper.EventMapper;
import de.vBookingBuddy.model.FullCalendarEvent;
import de.vBookingBuddy.service.impl.FirestoreServiceImpl;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.QueryValue;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.time.Instant;
import java.util.List;

@Controller("public/api/v1")
@RequiredArgsConstructor
@Slf4j
public class PublicController {

    private final FirestoreServiceImpl firestoreService;
    private final EventMapper eventMapper;

    // ---------------------------------------------------------------------------------------
    @Get(uri = "/eventData", produces = "text/json")
    @Secured(SecurityRule.IS_ANONYMOUS)
    @Tag(name = "public")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "500", description = "server error occurred"),
    })
    public HttpResponse<List<FullCalendarEvent>> getCalendarData(
            @QueryValue Instant start,
            @QueryValue Instant end
    ) {
        try {
            return HttpResponse.ok(
                    eventMapper.toResponse(
                            firestoreService.getPublicCalendarData(start, end)
                    )
            );
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return HttpResponse.status(
                    HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage()
            );
        }
    }

    // ---------------------------------------------------------------------------------------
    @Get(uri = "/eventRequest", produces = "text/json")
    @Secured(SecurityRule.IS_AUTHENTICATED)
    @Tag(name = "public")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "500", description = "server error occurred"),
    })
    public HttpResponse<List<FullCalendarEvent>> getCalendarData(
            @QueryValue Instant requestDate
    ) {
        try {
            return HttpResponse.ok(
                    eventMapper.toResponse(
                            firestoreService.getEventsAtDate(requestDate)
                    )
            );
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return HttpResponse.status(
                    HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage()
            );
        }
    }

}
