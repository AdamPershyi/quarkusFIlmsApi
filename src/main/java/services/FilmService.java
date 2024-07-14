package services;

import dtos.FilmDto;
import dtos.FilmInputDto;
import entities.Film;
import entities.Genre;
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
    public FilmDto updateFilm(FilmInputDto filmInputDto, UUID filmId) {
        Film film = findFilmById(filmId);
        filmMapper.updateEntity(film, filmInputDto);
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
//        Genre build = Genre.builder()
//                .name(GenreEnum.Crime)
//                .build();
//
//        Genre build1 = Genre.builder()
//                .name(GenreEnum.Comedy)
//                .build();
//
//        Set<Genre> build2 = Set.of(build, build1);
//        List<Film> byGenres = filmRepository.findByGenres(build2);

        List<Film> filmResult = new ArrayList<>();
        for (GenreEnum genre : filmInputDto.genres()) {
            List<Film> byGenre = filmRepository.findByGenre(genre);
            filmResult.addAll(byGenre);
        }
        return filmMapper.toListDtos(new ArrayList<>(new HashSet<>(filmResult)));

    }

    private Film findFilmById(UUID id) {
        return filmRepository.findById(id);
    }
}
