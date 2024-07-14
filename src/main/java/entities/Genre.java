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
@Table(name = "genres")
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

    //1 - виправити квері. Зробити вибірку фільмів по жанру(жанрам)
    //2 - створити таблицю enum actors (Name, Surname)
    //3 - створити many to many актори до фільмів
    //4 - створити відповідні правки в коді, щоб при створенні фільму задавати декількох акторів
    //5 - зробити кверю, яка повертає фільми по акторам
    //6 - закомітити зміни, запушити, зробити пулл реквест
}
