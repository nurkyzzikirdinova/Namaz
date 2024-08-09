package springprojectislam_dini.entity;

import jakarta.persistence.*;
import lombok.*;

import javax.validation.constraints.NotNull;


@Entity
@Table(name = "books")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "books_gen")
    @SequenceGenerator(name = "books_gen", sequenceName = "books_seq",allocationSize = 1)
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private int price;
    @NotNull
    @Column(length = 10000)

    private String image;

    @ManyToOne
    private User user;

    public Book(String name, int price, String image) {
        this.name = name;
        this.price = price;
        this.image = image;
    }


}

