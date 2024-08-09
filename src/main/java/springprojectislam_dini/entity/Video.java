package springprojectislam_dini.entity;

import jakarta.persistence.*;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Table(name = "videos")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Video {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "videos_gen")
    @SequenceGenerator(name = "videos_gen", sequenceName = "videos_seq", allocationSize = 1)

    private Long id;
    @NotNull
    private String name;
    @NotNull
    @Column(length = 10000)
    private String videoUrl;

    @ManyToOne
    private User users;

    public Video(String name, String videoUrl, User users) {
        this.name = name;
        this.videoUrl = videoUrl;
        this.users = users;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Video video = (Video) o;
        return Objects.equals(id, video.id) && Objects.equals(name, video.name) && Objects.equals(videoUrl, video.videoUrl) && Objects.equals(users, video.users);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, videoUrl, users);
    }
}

