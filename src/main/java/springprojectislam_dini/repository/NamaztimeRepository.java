package springprojectislam_dini.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springprojectislam_dini.entity.NamazTime;

@Repository
public interface NamaztimeRepository extends JpaRepository<NamazTime, Long> {

}
