package mappers;
import dtos.FilmDto;
import dtos.FilmInputDto;
import entities.Actor;
import entities.Film;
import entities.Genre;
import enums.ActorEnum;
import enums.GenreEnum;
import org.mapstruct.*;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.JAKARTA)
public interface FilmMapper {
    @Mapping(source = "budgetFilm", target = "budget")
    @Mapping(target = "genres", source = "genres", qualifiedByName = "genresToGenreEntity")
    @Mapping(target = "actors", source = "actors", qualifiedByName = "actorsToActorsEntity")
    Film toEntity(FilmInputDto filmInputDto);

    @Mapping(source = "budget", target = "budgetFilm")
    @Mapping(target = "genres", source = "genres", qualifiedByName = "genresToGenreDto")
    @Mapping(target = "actors", source = "actors", qualifiedByName = "actorsToActorsDto")
    FilmDto toDto(Film film);

    @Mapping(source = "budgetFilm", target = "budget")
    @Mapping(target = "genres", source = "genres", qualifiedByName = "genresToGenreEntity")
    @Mapping(target = "actors", source = "actors", qualifiedByName = "actorsToActorsEntity")
    void updatedEntity(@MappingTarget Film film, FilmInputDto filmInputDto);

    List<FilmDto> toListDtos(List<Film> films);

    @Named("genresToGenreDto")
    default Set<GenreEnum> genresToGenreDto(Set<Genre> genres) {
        return genres.stream()
                .map(Genre::getName)
                .collect(Collectors.toSet());
    }

    @Named("genresToGenreEntity")
    default Set<Genre> genresToGenreEntity(Set<GenreEnum> genres) {
        return genres.stream()
                .map(enumFromDto -> Genre.builder().name(enumFromDto).build())
                .collect(Collectors.toSet());
    }

    @Named("actorsToActorsDto")
    default Set<ActorEnum> actorsToActorsDto(Set<Actor> actors) {
        return actors.stream()
                .map(Actor::getName)
                .collect(Collectors.toSet());
    }

    @Named("actorsToActorsEntity")
    default Set<Actor> actorsToActorsEntity(Set<ActorEnum> actors) {
        return actors.stream()
                .map(actorEnum -> Actor.builder().name(actorEnum).build())
                .collect(Collectors.toSet());
    }
}

