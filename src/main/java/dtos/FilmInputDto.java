package dtos;

import enums.GenreEnum;

import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.UUID;

/**
 * DTO for {@link entities.Film}
 */
public record FilmInputDto(String title, String aboutFilm, String releasedDate, String cityRelease, String budgetFilm,
                           GenreEnum genre) implements Serializable {
}