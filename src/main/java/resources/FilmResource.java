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
    public FilmDto createFilm(FilmInputDto filmInputDto) {
        return filmService.createFilm(filmInputDto);
    }

    @Mutation("updatedFilm")
    public FilmDto updatedFilm(FilmInputDto filmInputDto, UUID filmId) {
        return filmService.updatedFilm(filmInputDto, filmId);
    }

    @Query("getFilms")
    public List<FilmDto> getFilms() {
        return filmService.getFilms();
    }

    @Query("getFilm")
    public FilmDto getFilmById(UUID id) {
        return filmService.getFilmById(id);
    }

    @Query("getFilmsByGenre")
    public List<FilmDto> getFilmsByGenre(FilmInputDto filmInputDto) {
        return filmService.getFilmsByGenre(filmInputDto);
    }

    @Query("getFilmsByActor")
    public List<FilmDto> getFilmsByActor(FilmInputDto filmInputDto){
        return filmService.getFilmsByActor(filmInputDto);
    }

}
