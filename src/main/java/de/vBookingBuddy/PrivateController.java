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

@Controller("private/api/v1")
@RequiredArgsConstructor
@Slf4j
public class PrivateController {

    private final FirestoreServiceImpl firestoreService;
    private final EventMapper eventMapper;

}
