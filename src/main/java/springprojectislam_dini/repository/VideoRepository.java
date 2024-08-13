package springprojectislam_dini.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springprojectislam_dini.entity.Video;


@Repository
public interface VideoRepository  extends JpaRepository<Video, Long> {

}
