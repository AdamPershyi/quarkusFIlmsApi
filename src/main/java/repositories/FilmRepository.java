package repositories;
import entities.Film;
import enums.ActorEnum;
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
        return find("from Film f join f.genres g where g.name = ?1", genre).list();
    }

    public List<Film> findByActor(ActorEnum actor){
        return find("from Film f join f.actors a where a.name = ?1",actor).list();
    }

}
