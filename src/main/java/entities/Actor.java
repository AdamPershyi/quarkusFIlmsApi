package entities;
import enums.ActorEnum;
import jakarta.persistence.*;
import lombok.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "actors")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Actor {
    @Id
    @Column(name = "name", nullable = false, length = Integer.MAX_VALUE)
    @Enumerated(EnumType.STRING)
    private ActorEnum name;

    @ManyToMany(mappedBy = "actors")
    private Set<Film> films = new LinkedHashSet<>();

}