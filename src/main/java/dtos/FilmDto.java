package dtos;
import enums.ActorEnum;
import enums.GenreEnum;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.Set;
import java.util.UUID;

/**
 * DTO for {@link entities.Film}
 */
public record FilmDto(UUID id, String title, String aboutFilm, String releasedDate, String cityRelease,
                      BigDecimal budgetFilm,
                      Set<GenreEnum> genres, Set<ActorEnum> actors, OffsetDateTime createdAt,
                      OffsetDateTime updatedAt) implements Serializable {
}