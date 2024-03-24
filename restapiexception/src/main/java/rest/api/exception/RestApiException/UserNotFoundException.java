package rest.api.exception.restapiexception;

import io.github.wimdeblauwe.errorhandlingspringbootstarter.ResponseErrorCode;
import io.github.wimdeblauwe.errorhandlingspringbootstarter.ResponseErrorProperty;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
@ResponseErrorCode("USER_NOT_FOUND!!!!!")
public class UserNotFoundException extends RuntimeException {
    private final int infoRequestId;

    public UserNotFoundException(UserId userId) {
        super("Could not find user with id " + userId.getId());
        this.infoRequestId = userId.getId();
    }

    @ResponseErrorProperty("id")
    public int getInfoRequestId() {
        return infoRequestId;
    }

}