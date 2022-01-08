package moee.henaknowledge.repository;

import moee.henaknowledge.module.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.sql.Date;
import java.util.Optional;

public interface IAdminRepository extends JpaRepository<Admin,Long> {
    Admin getAdminByPersonID (int ID);
    @Modifying
    @Transactional
    @Query("update Person p set p.firstName=?2,p.lastName=?3, p.dateOfBirth=?4,p.email=?5 WHERE p.personID=?1")
    void setAdminInfoById(int personID, String firstname, String lastname, Date DateOfBirth, String Email);
    Optional<Admin> findByUsername(String username);
    @Query("SELECT s FROM Admin s Where s.username=?1")
    Admin getAdminByUsername(String username);
}
