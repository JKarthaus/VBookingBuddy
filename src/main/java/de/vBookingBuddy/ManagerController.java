package de.vBookingBuddy;

import de.vBookingBuddy.mapper.EventMapper;
import de.vBookingBuddy.model.UserModelResponse;
import de.vBookingBuddy.service.impl.FirestoreServiceImpl;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.authentication.Authentication;
import io.micronaut.security.rules.SecurityRule;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Controller("api/manager/v1")
@RequiredArgsConstructor
@Slf4j
public class ManagerController {

    private final FirestoreServiceImpl firestoreService;
    private final EventMapper eventMapper;

    // ---------------------------------------------------------------------------------------
    @Get(uri = "/userModel", produces = "text/json")
    @Secured(SecurityRule.IS_AUTHENTICATED)
    @Tag(name = "manager")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "500", description = "server error occurred"),
    })
    public HttpResponse<UserModelResponse> getUserModel(Authentication authentication) {
        try {
            return HttpResponse.ok(
                    new UserModelResponse(authentication.getAttributes().get("email").toString())
            );
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return HttpResponse.status(
                    HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage()
            );
        }
    }

}
