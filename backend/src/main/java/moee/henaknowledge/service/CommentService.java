package moee.henaknowledge.service;

import moee.henaknowledge.dal_interfaces.ICommentDAL;
import moee.henaknowledge.module.Comment;
import moee.henaknowledge.service_interfaces.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService implements ICommentService {

    ICommentDAL dal;

    @Autowired
    public CommentService(ICommentDAL dal) {
        this.dal = dal;
    }

    @Override
    public Optional<Comment> getCommentByCommentID(int ID) {
        var allComments = getAllComments();
        for (Comment c:
                allComments) {
            if(c.getCommentID() == ID){
                return Optional.of(c);
            }
        }
        return Optional.empty();
    }

    @Override
    public List<Comment> getAllComments() {
        return dal.getAllComments();
    }

    @Override
    public List<Comment> getAllCommentsByExperienceID(int ExperienceID) {
        return dal.getAllCommentsByExperienceID(ExperienceID);
    }


    @Override
    public void AddComment(Comment c) {
        dal.AddComment(c);
    }


    @Override
    public void DeleteCommentByID(int commentID) {
        dal.DeleteCommentByID(commentID);
    }

    @Override
    public void setCommentById(int commentID, String updatedComment) {
        dal.setCommentById(commentID, updatedComment);
    }

}
