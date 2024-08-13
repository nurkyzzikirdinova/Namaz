package springprojectislam_dini.entity;

import jakarta.persistence.*;
import lombok.*;
import springprojectislam_dini.enums.Profession;


import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "users")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "users_gen")
    @SequenceGenerator(name = "users_gen", sequenceName = "users_seq",allocationSize = 1)
    private Long id;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @NotNull
    private LocalDate dateOfBirch;
    @NotNull
    private String country;
    @NotNull
    @Column(length = 100000)
    private String biography;
    @NotNull
    @Column(length = 10000)
    private String image;

    @Enumerated(EnumType.STRING)
    private Profession profession;

    @OneToMany(mappedBy = "users")
    private List<Video>videos=new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = {CascadeType.REMOVE})
    private List<Book>books = new ArrayList<>();

    @ManyToMany(mappedBy = "users")
    private List<Xadis>xadisList = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = {CascadeType.REMOVE})
    private List<Lesson>lessons=new ArrayList<>();

    public User(String firstName, String lastName, LocalDate dateOfBirch, String country, String image, Profession profession) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirch = dateOfBirch;
        this.country = country;
        this.image = image;
        this.profession = profession;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(firstName, user.firstName) && Objects.equals(lastName, user.lastName) && Objects.equals(dateOfBirch, user.dateOfBirch) && Objects.equals(country, user.country) && Objects.equals(image, user.image) && profession == user.profession;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, dateOfBirch, country, image, profession);
    }
}
