package entities;

import enums.GenreEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.OffsetDateTime;
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
    @GeneratedValue(strategy = GenerationType.UUID)
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
    private String budget;

    @Column(name = "genre", length = Integer.MAX_VALUE)
    @Enumerated(EnumType.STRING)
    private GenreEnum genre;


    @Column(name = "created_at", nullable = false)
    @CreationTimestamp
    private OffsetDateTime createdAt;


    @Column(name = "updated_at", nullable = false)
    @UpdateTimestamp
    private OffsetDateTime updatedAt;

}