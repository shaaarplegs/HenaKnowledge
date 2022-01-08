package moee.henaknowledge.repository;

import moee.henaknowledge.module.ExperienceOpinion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.Optional;

public interface IExperienceOpinionRepository extends JpaRepository<ExperienceOpinion, Integer> {

    @Modifying
    @Transactional
    @Query("update ExperienceOpinion e set e.likes=?2, e.dislikes=?3 WHERE e.opinionID=?1")
    void updateOpinion(int opinionID, int likes, int dislikes);

    @Transactional
    @Query("select e FROM ExperienceOpinion e WHERE e.personID=?1 AND e.experienceID=?2")
    Optional<ExperienceOpinion> findExperienceOpinionByPersonIDAndExperienceID(int PersonID, int experienceID);

    @Transactional
    @Query("select e FROM ExperienceOpinion e WHERE e.personID=?1")
    Optional<ExperienceOpinion>  findExperienceOpinionByPersonID(int PersonID);
}
