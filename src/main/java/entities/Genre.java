package entities;
import enums.GenreEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "genre")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Genre {
    @Id
    @Column(name = "name", nullable = false)
    @Enumerated(EnumType.STRING)
    private GenreEnum name;

    @ManyToMany(mappedBy = "genres")
    private Set<Film> films = new LinkedHashSet<>();

}
