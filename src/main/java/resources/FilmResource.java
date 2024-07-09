package resources;
import dtos.FilmDto;
import dtos.FilmInputDto;
import jakarta.inject.Inject;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Mutation;
import org.eclipse.microprofile.graphql.Query;
import services.FilmService;

import java.util.List;
import java.util.UUID;

@GraphQLApi
public class FilmResource {

    @Inject
    FilmService filmService;


@Mutation("createFilm")
public FilmDto createFilm(FilmInputDto filmInputDto){
    return filmService.createFilm(filmInputDto);
}

@Mutation("updateFilm")
public FilmDto updateFilm(FilmInputDto filmDto, UUID filmId){
    return filmService.updateFilm(filmDto,filmId);
}


@Query("getFilms")
public List<FilmDto> getFilms(){
    return filmService.getFilms();
}


@Query("getFilm")
public FilmDto getFilmById(UUID id){
    return filmService.getFilmById(id);
}
@Query("getFIlmByGenre")
public List<FilmDto> getFilmsByGenre(List<FilmInputDto> filmInputDtos){
    return filmService.getFilmsByGenre(filmInputDtos);
}



}
