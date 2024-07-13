package dtos;

import enums.GenreEnum;

import java.io.Serializable;
import java.util.Set;

/**
 * DTO for {@link entities.Film}
 */
public record FilmInputDto(String title, String aboutFilm, String releasedDate, String cityRelease, String budgetFilm,
                           Set<GenreEnum> genres) implements Serializable {
}

// чому budgetFilm у нас стрінг???