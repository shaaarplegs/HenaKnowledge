package moee.henaknowledge.service;

import moee.henaknowledge.dal_interfaces.IAdminDAL;
import moee.henaknowledge.dal_interfaces.ICommentDAL;
import moee.henaknowledge.module.Admin;
import moee.henaknowledge.module.Comment;
import moee.henaknowledge.repository.AdminDalJPA;
import moee.henaknowledge.repository.CommentDalJPA;
import moee.henaknowledge.repository.IAdminRepository;
import moee.henaknowledge.repository.ICommentRepository;
import moee.henaknowledge.util.constant;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
@ActiveProfiles("test")
@SpringBootTest
class CommentServiceTest {


    //ARRANGE

    ICommentRepository commentRepository;
    CommentDalJPA commentDalJPA;
    ICommentDAL commentDAL;
    CommentService service;

    //arange
    private Comment c1 = new Comment(1,55,"very good article, keep up the good work",34);

    //arange
    private Comment c2 = new Comment(2,54,"perfect",34);

    Optional<Comment> oc1 = Optional.of(c1);
    Optional<Comment> oc2 = Optional.of(c2);

    @BeforeEach
    public void init () {
        //mocking the repos
        commentRepository = mock(ICommentRepository.class);
        commentDalJPA = new CommentDalJPA(commentRepository);
        //mocking the DAL into the service instance
        commentDAL = mock(ICommentDAL.class);
        service = new CommentService(commentDalJPA);

        //ACT
        when(commentDalJPA.getCommentByCommentID(2)).thenReturn(oc1);
        when(commentDalJPA.getCommentByCommentID(1)).thenReturn(oc2);
        when(commentDalJPA.getAllComments()).thenReturn(Arrays.asList(oc1.get(),oc2.get()));
        when(commentDalJPA.getAllCommentsByExperienceID(34)).thenReturn(Arrays.asList(oc1.get(),oc2.get()));
    }


    @Test
    void getCommentByCommentID() {
        assertEquals(oc2, service.getCommentByCommentID(2));
    }

    @Test
    void getAllComments() {
        assertEquals((Arrays.asList(c1,c2)), service.getAllComments());
    }

    @Test
    void getAllCommentsByExperienceID() {
        assertEquals((Arrays.asList(c1,c2)), service.getAllCommentsByExperienceID(34));
    }

    @Test
    void addComment() {
        Comment c3 = new Comment(3,57,"good experience",34);
        service.AddComment(c3);

        verify(commentRepository, times(1)).save(c3);
    }


    @Test
    void setCommentById() {
        service.setCommentById(1,"wow so many active people here!");
        verify(commentRepository,times(1)).updateCommentByCommentID(1,"wow so many active people here!");
    }
}