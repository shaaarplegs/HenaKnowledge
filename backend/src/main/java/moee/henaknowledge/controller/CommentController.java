package moee.henaknowledge.controller;


import moee.henaknowledge.dto.CommentDTO;
import moee.henaknowledge.module.Comment;
import moee.henaknowledge.service_interfaces.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/Comment")
@CrossOrigin("*")
public class CommentController {

    @Autowired
    private ICommentService service;

    @GetMapping()
    public List<Comment> getAllComments() {
        return service.getAllComments();
    }

    @DeleteMapping()
    public void DeleteComment(@RequestParam int commentID) {
        service.DeleteCommentByID(commentID);
    }

    @PutMapping()
    public ResponseEntity<Comment> updateComment(@RequestParam("commentID") int commentID,
                                                 @RequestParam("updatedComment") String updatedComment) {
        var a = service.getCommentByCommentID(commentID);
        if (a.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        else
        {
            service.setCommentById(commentID,updatedComment);
            return ResponseEntity.ok().body(a.get());
        }
    }

    @PostMapping("/Add")
    public ResponseEntity<Comment> createComment(@RequestBody CommentDTO cDTO) {
        if (cDTO == null)
        {
            return ResponseEntity.notFound().build();
        } else {

            Comment modifiedComment = new Comment(cDTO.getCommentID(), cDTO.getPersonID()
                    ,cDTO.getCommentBody(),cDTO.getExperienceID());
            service.AddComment(modifiedComment);
            return ResponseEntity.ok().body(modifiedComment);
        }
    }


    @GetMapping("/getComment")
    public ResponseEntity<Comment> getComment(@RequestParam("CommentID") int CommentID) {
        var s = service.getCommentByCommentID(CommentID);
        if (s.isPresent()) {
            return ResponseEntity.ok().body(s.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/getAllCommentsOfExperienceID")
    public List<Comment> GetAllCommentsByExperienceID(@RequestParam("ExperienceID") int ExperienceID) {
        var s = service.getAllCommentsByExperienceID(ExperienceID);
        if(s.isEmpty()){
            return null;
        }
        else
        {
            return s;
        }
    }
}
