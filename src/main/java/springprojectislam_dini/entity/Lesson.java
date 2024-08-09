package springprojectislam_dini.entity;

import jakarta.persistence.*;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "lessons")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Lesson{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "lesson_gen")
    @SequenceGenerator(name = "lesson_gen", sequenceName = "lesson_seq",allocationSize = 1)
    private Long id;
    @Column(length = 5000)
    @NotNull
    private String lessonName;
    @NotNull
    private LocalDate startLessonDate;
    @ManyToOne
    private User user;


    public Lesson(String lessonName, LocalDate startLessonDate) {
        this.lessonName = lessonName;
        this.startLessonDate = startLessonDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lesson lesson = (Lesson) o;
        return Objects.equals(id, lesson.id) && Objects.equals(lessonName, lesson.lessonName) && Objects.equals(startLessonDate, lesson.startLessonDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, lessonName, startLessonDate);
    }
}
