package repositories;

import entities.Film;
import enums.GenreEnum;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
import java.util.UUID;


@ApplicationScoped
public class FilmRepository implements PanacheRepositoryBase<Film, UUID> {
    public Film update(Film film) {
        Film merge = getEntityManager().merge(film);
        persist(merge);
        return merge;
    }

    public List<Film> findByGenre(GenreEnum genre) {
return find("where genre = ?1",genre).list();

    }
}
