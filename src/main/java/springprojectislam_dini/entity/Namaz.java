package springprojectislam_dini.entity;

import jakarta.persistence.*;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Table(name = "namazs")
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor


public class Namaz {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "namazs_gen")
    @SequenceGenerator(name = "namazs_gen", sequenceName = "namazs_seq",allocationSize = 1)
    private Long id;
    @NotNull
    @Column(length = 10000)
    private String namaztext1;
    @NotNull
    @Column(length = 10000)
    private String namazText2;
    @NotNull
    @Column(length = 10000)
    private String namazText3;
    @NotNull
    @Column(length = 10000)
    @NotNull
    private String image;
    @NotNull
    @Column(length = 100000)
    private String audio;

    public Namaz(String namaztext1, String namazText2, String namazText3, String image, String audio) {
        this.namaztext1 = namaztext1;
        this.namazText2 = namazText2;
        this.namazText3 = namazText3;
        this.image = image;
        this.audio = audio;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Namaz namaz = (Namaz) o;
        return Objects.equals(id, namaz.id) && Objects.equals(namaztext1, namaz.namaztext1) && Objects.equals(namazText2, namaz.namazText2) && Objects.equals(namazText3, namaz.namazText3) && Objects.equals(image, namaz.image) && Objects.equals(audio, namaz.audio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, namaztext1, namazText2, namazText3, image, audio);
    }
}
