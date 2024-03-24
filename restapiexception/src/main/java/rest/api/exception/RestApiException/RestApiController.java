package rest.api.exception.restapiexception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class RestApiController {

    private static final Logger LOGGER = LoggerFactory.getLogger(RestApiController.class);

    @PostMapping("/userId/")
    public String userId(@RequestBody UserId id) {
        LOGGER.info("userId() - START" + id.getId());

        if (id.getId() > 10 ) {
            LOGGER.info("userId() - error ");
            throw new UserNotFoundException(id);
        }

        LOGGER.info("userId() - END");
        return "";
    }

    @PostMapping("/reqException/")
    public String doSomething(@Valid @RequestBody ExampleRequestBody requestBody ) {

        // ...
        return "";
    }













}
