package mappers;

import dtos.FilmDto;
import dtos.FilmInputDto;
import entities.Film;
import entities.Genre;
import enums.GenreEnum;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.JAKARTA)
public interface FilmMapper {
    @Mapping(source = "budgetFilm", target = "budget")
    @Mapping(target = "genres", source = "genres", qualifiedByName = "genresToGenreEntity")
    Film toEntity(FilmInputDto filmInputDto);

    @Mapping(source = "budget", target = "budgetFilm")
    @Mapping(target = "genres", source = "genres", qualifiedByName = "genresToGenreDto")
    FilmDto toDto(Film film);

    @Mapping(source = "budgetFilm", target = "budget")
    void updateEntity(@MappingTarget Film film, FilmInputDto filmInputDto);

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
}

