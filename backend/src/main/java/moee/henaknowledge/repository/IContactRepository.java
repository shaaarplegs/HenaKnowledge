package moee.henaknowledge.repository;

import moee.henaknowledge.module.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface IContactRepository extends JpaRepository<Contact, Integer> {

    @Modifying
    @Transactional
    @Query("update Contact c set c.studentQuestion=?2,c.teacherResponse=?3, c.pending=?4,c.wasUseful=?5 ,c.wasNotUseful=?6  ,c.studentID=?7  ,c.teacherID=?8 WHERE c.ID=?1")
    void UpdateContact(int ID, String studentQuestion, String teacherResponse,
                       int pending, int wasUseful, int wasNotUseful,
                       int studentID, int teacherID);
}
