package mappers;

import dtos.FilmDto;
import dtos.FilmInputDto;
import entities.Film;
import org.mapstruct.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;


import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.JAKARTA)
public interface FilmMapper {
  @Mapping(source = "budgetFilm", target = "budget")
    Film toEntity(FilmInputDto filmInputDto);
  @Mapping(source = "budget", target = "budgetFilm")
    FilmDto toDto(Film film);

    @Mapping(source = "budgetFilm", target = "budget")
    void updateEntity(@MappingTarget Film film, FilmInputDto filmInputDto);

    List<FilmDto> toListDtos(List<Film> films);
}