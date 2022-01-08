package moee.henaknowledge.repository;



import moee.henaknowledge.module.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.sql.Date;
import java.util.Optional;

public interface ITeacherRepository extends JpaRepository<Teacher, Long> {
    Teacher getTeacherByPersonID (int ID);
    @Modifying
    @Transactional
    @Query("update Person p set p.firstName=?2,p.lastName=?3, p.dateOfBirth=?4,p.email=?5 WHERE p.personID=?1")
    void setTeacherInfoById(int personID, String firstname, String lastname, Date DateOfBirth, String Email);
    Optional<Teacher> findByUsername(String username);
    @Query("SELECT s FROM Teacher s Where s.username=?1")
    Teacher getTeacherByUsername(String username);

    @Modifying
    @Transactional
    @Query("update Teacher t set t.points=?2 WHERE t.personID=?1")
    void updatePoints(int personID, int points);
}
