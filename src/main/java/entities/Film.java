package entities;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.UuidGenerator;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "films")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Film {
    @Id
    @UuidGenerator
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "title", length = Integer.MAX_VALUE)
    private String title;

    @Column(name = "about_film", length = Integer.MAX_VALUE)
    private String aboutFilm;

    @Column(name = "released_date", length = Integer.MAX_VALUE)
    private String releasedDate;

    @Column(name = "released_city", length = Integer.MAX_VALUE)
    private String releasedCity;

    @Column(name = "budget", length = Integer.MAX_VALUE)
    private BigDecimal budget;

    @Column(name = "created_at", nullable = false)
    @CreationTimestamp
    private OffsetDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    @UpdateTimestamp
    private OffsetDateTime updatedAt;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinTable(
            name = "film_genres",
            joinColumns = @JoinColumn(name = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_name")
    )
    private Set<Genre> genres = new LinkedHashSet<>();

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinTable(
            name = "film_actors",
            joinColumns = @JoinColumn(name = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "actor_name")
    )
    private Set<Actor> actors = new LinkedHashSet<>();
}
