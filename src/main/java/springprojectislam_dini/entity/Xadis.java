package springprojectislam_dini.entity;

import jakarta.persistence.*;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "xadiss")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Hadis {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "xadiss_gen")
    @SequenceGenerator(name = "xadiss_gen", sequenceName = "xadiss_seq",allocationSize = 1)
    private Long id;
    @NotNull
    @Column(length = 10000)
    private String xadisText;

    @ManyToMany
    private List<User>users = new ArrayList<>();

    public Hadis(String xadisText) {
        this.xadisText = xadisText;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hadis xadis = (Hadis) o;
        return Objects.equals(id, xadis.id) && Objects.equals(xadisText, xadis.xadisText) && Objects.equals(users, xadis.users);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, xadisText, users);
    }
}
