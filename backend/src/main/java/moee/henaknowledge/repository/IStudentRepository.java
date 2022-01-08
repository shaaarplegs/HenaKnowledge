package moee.henaknowledge.repository;

import moee.henaknowledge.module.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.sql.Date;
import java.util.Optional;

public interface IStudentRepository extends JpaRepository<Student, Long> {
    Student getStudentByPersonID (int ID);
    @Modifying
    @Transactional
    @Query("update Person p set p.firstName=?2,p.lastName=?3, p.dateOfBirth=?4,p.email=?5 WHERE p.personID=?1")
    void setStudentInfoById(int personID, String firstname, String lastname, Date DateOfBirth, String Email);
    Optional<Student> findByUsername(String username);
    @Query("SELECT s FROM Student s Where s.username=?1")
    Student getStudentByUsername(String username);

    @Modifying
    @Transactional
    @Query("update Student s set s.points=?2 WHERE s.personID=?1")
    void updatePoints(int personID, int points);
}
