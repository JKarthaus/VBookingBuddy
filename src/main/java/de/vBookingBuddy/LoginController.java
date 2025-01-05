package de.vBookingBuddy;

import de.vBookingBuddy.mapper.EventMapper;
import de.vBookingBuddy.service.impl.FirestoreServiceImpl;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;
import io.micronaut.views.View;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Controller("login")
@RequiredArgsConstructor
@Slf4j
public class LoginController {

    private final FirestoreServiceImpl firestoreService;
    private final EventMapper eventMapper;

    @Secured(SecurityRule.IS_ANONYMOUS)
    @View("login")
    @Get
    public Map<String, Object> index() {
        return new HashMap<>();
    }


}
