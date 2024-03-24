package rest.api.exception.restapiexception;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class ExampleRequestBody {
    @Size(min = 10)
    private String name;
    @NotBlank
    private String favoriteMovie;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFavoriteMovie() {
        return favoriteMovie;
    }

    public void setFavoriteMovie(String favoriteMovie) {
        this.favoriteMovie = favoriteMovie;
    }
}
