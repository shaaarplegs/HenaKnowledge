package moee.henaknowledge.repository;

import moee.henaknowledge.module.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;


public interface ICommentRepository extends JpaRepository<Comment, Integer> {

    @Modifying
    @Transactional
    @Query("update Comment c set c.commentBody=?2 WHERE c.commentID=?1")
    void updateCommentByCommentID(int commentID, String commentBody);

    @Transactional
    @Query("select c FROM Comment c WHERE c.experienceID=?1")
    List<Comment> getAllCommentsByExperienceID(int experienceID);
}
