package moee.henaknowledge.repository;

import moee.henaknowledge.dal_interfaces.ICommentDAL;
import moee.henaknowledge.module.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CommentDalJPA implements ICommentDAL {

    @Autowired
    ICommentRepository repos;

    public CommentDalJPA(ICommentRepository repos) {
        this.repos = repos;
    }

    @Override
    public Optional<Comment> getCommentByCommentID(int ID) {
        return repos.findById(ID);
    }

    @Override
    public List<Comment> getAllComments() {
        return repos.findAll();
    }

    @Override
    public List<Comment> getAllCommentsByExperienceID(int ExperienceID) {
        return repos.getAllCommentsByExperienceID(ExperienceID);
    }

    @Override
    public void AddComment(Comment c) {
        repos.save(c);
    }

    @Override
    public void DeleteCommentByID(int commentID) {
        repos.deleteById(commentID);
    }

    @Override
    public void setCommentById(int commentID, String updatedComment) {
        repos.updateCommentByCommentID(commentID, updatedComment);
    }
}
