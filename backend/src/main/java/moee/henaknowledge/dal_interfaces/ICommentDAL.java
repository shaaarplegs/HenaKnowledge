package moee.henaknowledge.dal_interfaces;

import moee.henaknowledge.module.Comment;

import java.util.List;
import java.util.Optional;

public interface ICommentDAL {
    Optional<Comment> getCommentByCommentID(int ID);
    List<Comment> getAllComments();
    List<Comment> getAllCommentsByExperienceID(int ExperienceID);
    void AddComment(Comment c);
    void DeleteCommentByID(int commentID);
    void setCommentById(int commentID, String updatedComment);
}
