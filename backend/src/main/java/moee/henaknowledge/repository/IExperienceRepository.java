package moee.henaknowledge.repository;


import moee.henaknowledge.module.Experience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.Optional;


public interface IExperienceRepository extends JpaRepository<Experience, Integer> {

    Optional<Experience> findByExperienceID(int ID);

    @Modifying
    @Transactional
    @Query("update Experience e set e.title=?2,e.description=?3 WHERE e.experienceID=?1")
    void updatedExperienceByExperienceID(int experienceID, String title, String description);

    @Modifying
    @Transactional
    @Query("update Experience e set e.likes=?2 WHERE e.experienceID=?1")
    void likeTheExperience(int experienceID, int likes);

    @Modifying
    @Transactional
    @Query("update Experience e set e.dislikes=?2 WHERE e.experienceID=?1")
    void dislikesTheExperience(int experienceID, int dislikes);
}
