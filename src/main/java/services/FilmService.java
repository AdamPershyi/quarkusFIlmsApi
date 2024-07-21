package services;
import dtos.FilmDto;
import dtos.FilmInputDto;
import entities.Film;
import enums.ActorEnum;
import enums.GenreEnum;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import mappers.FilmMapper;
import repositories.FilmRepository;
import java.util.*;


@ApplicationScoped
public class FilmService {

    @Inject
    FilmMapper filmMapper;
    @Inject
    FilmRepository filmRepository;

    @Transactional
    public FilmDto createFilm(FilmInputDto filmInputDto) {
        Film entity = filmMapper.toEntity(filmInputDto);
        filmRepository.persist(entity);
        return filmMapper.toDto(entity);

    }

    @Transactional
    public FilmDto updatedFilm(FilmInputDto filmInputDto, UUID filmId) {
        Film film = findFilmById(filmId);
        filmMapper.updatedEntity(film, filmInputDto);
        Film updateFilm = filmRepository.update(film);
        return filmMapper.toDto(updateFilm);
    }

    public List<FilmDto> getFilms() {
        List<Film> films = filmRepository.listAll();
        return filmMapper.toListDtos(films);
    }

    public FilmDto getFilmById(UUID id) {
        Film byId = filmRepository.findById(id);
        return filmMapper.toDto(byId);

    }

    public List<FilmDto> getFilmsByGenre(FilmInputDto filmInputDto) {
        List<Film> filmResult = new ArrayList<>();
        for (GenreEnum genre : filmInputDto.genres()) {
            List<Film> byGenre = filmRepository.findByGenre(genre);
            filmResult.addAll(byGenre);
        }
        return filmMapper.toListDtos(new ArrayList<>(new HashSet<>(filmResult)));
    }

    public List<FilmDto> getFilmsByActor(FilmInputDto filmInputDto){
        List<Film> filmResult = new ArrayList<>();
        for (ActorEnum actor : filmInputDto.actors()) {
            List<Film> byActor = filmRepository.findByActor(actor);
            filmResult.addAll(byActor);
        }
        return filmMapper.toListDtos(new ArrayList<>(new HashSet<>(filmResult)));
    }

    private Film findFilmById(UUID id) {
        return filmRepository.findById(id);
    }
}
