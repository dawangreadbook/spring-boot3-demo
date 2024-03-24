package rest.api.exception.restapiexception;

import io.github.wimdeblauwe.errorhandlingspringbootstarter.ApiErrorResponse;
import io.github.wimdeblauwe.errorhandlingspringbootstarter.ApiExceptionHandler;
import io.github.wimdeblauwe.errorhandlingspringbootstarter.ResponseErrorCode;
import io.github.wimdeblauwe.errorhandlingspringbootstarter.ResponseErrorProperty;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

@Component
public class CustomExceptionApiExceptionHandler implements ApiExceptionHandler {

    @Override
    public boolean canHandle(Throwable exception) {
        return exception instanceof MethodArgumentNotValidException;// maybe some other exception
    }

    @Override
    public ApiErrorResponse handle(Throwable exception) {
        MethodArgumentNotValidException customException = (MethodArgumentNotValidException) exception;

        ApiErrorResponse response = new ApiErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR,
                "999",
                "bad request parameter");
//        Throwable cause = customException.getCause();
//        Map<String, Object> nestedCause = new HashMap<>();
//        nestedCause.put("detail_code", "99999");
//        response.addErrorProperty("cause", nestedCause);
        response.addErrorProperty("detail_code", "99999");

        return response;
    }
}
