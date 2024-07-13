package services;

import dtos.FilmDto;
import dtos.FilmInputDto;
import entities.Film;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import mappers.FilmMapper;
import repositories.FilmRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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

    public FilmDto getFilmById(UUID id){
        Film byId = filmRepository.findById(id);
        return  filmMapper.toDto(byId);

    }

//    public List<FilmDto> getFilmsByGenre(List<FilmInputDto> filmInputDtos){
//        List<FilmInputDto> filmWithOutGenre = filmInputDtos.stream()
//                .filter(filmInputDto -> filmInputDto.genres() == null)
//                .toList();
//        if (!filmWithOutGenre.isEmpty()){
//            throw new RuntimeException("Film haven't genres");
//        }
//
//        List<Film> matchFilms = new ArrayList<>();
//for (FilmInputDto filmInputDto:filmInputDtos){
//    List<Film> byGenre = filmRepository.findByGenre(filmInputDto.genres());
//    matchFilms.addAll(byGenre);
//}
//return filmMapper.toListDtos(matchFilms);
//
//
//    }

    private Film findFilmById(UUID id) {
        return filmRepository.findById(id);
    }
}
