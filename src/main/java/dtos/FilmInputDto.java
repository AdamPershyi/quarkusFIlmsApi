package dtos;
import enums.ActorEnum;
import enums.GenreEnum;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

/**
 * DTO for {@link entities.Film}
 */
public record FilmInputDto(String title, String aboutFilm, String releasedDate, String cityRelease,
                           BigDecimal budgetFilm,
                           Set<GenreEnum> genres, Set<ActorEnum> actors) implements Serializable {
}