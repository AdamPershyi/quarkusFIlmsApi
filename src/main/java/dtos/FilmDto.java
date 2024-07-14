package dtos;

import entities.Actor;
import entities.Genre;
import enums.GenreEnum;

import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.Set;
import java.util.UUID;

/**
 * DTO for {@link entities.Film}
 */
public record FilmDto(UUID id, String title, String aboutFilm, String releasedDate, String cityRelease,
                      String budgetFilm,
                      Set<GenreEnum> genres, OffsetDateTime createdAt,
                      OffsetDateTime updatedAt) implements Serializable {
}