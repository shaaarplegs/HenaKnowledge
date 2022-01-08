package moee.henaknowledge.module;

import moee.henaknowledge.util.constant;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.sql.Date;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("test")
@SpringBootTest
class CommentTest {

    //arange
    private Comment c = new Comment(1,55,"very good article, keep up the good work",34);


    @Test
    void setCommentID() {
        //act
        var newID = 5;
        c.setCommentID(newID);
        var actual = c.getCommentID();
        var expected = newID;

        //assert
        assertEquals(expected,actual);
    }

    @Test
    void setPersonID() {
        //act
        var newPersonID = 5;
        c.setPersonID(newPersonID);
        var actual = c.getPersonID();
        var expected = newPersonID;

        //assert
        assertEquals(expected,actual);
    }

    @Test
    void setCommentBody() {
        //act
        var newBody = "wow your article is rocketing!";
        c.setCommentBody(newBody);
        var actual = c.getCommentBody();
        var expected = newBody;

        //assert
        assertEquals(expected,actual);
    }


    @Test
    void getCommentID() {
        //act
        var actual = c.getCommentID();
        var expected = 1;

        //assert
        assertEquals(expected,actual);
    }

    @Test
    void getPersonID() {
        //act
        var actual = c.getPersonID();
        var expected = 55;

        //assert
        assertEquals(expected,actual);
    }

    @Test
    void getCommentBody() {

        //act
        var actual = c.getCommentBody();
        var expected = "very good article, keep up the good work";

        //assert
        assertEquals(expected,actual);
    }

    @Test
    void getExperienceID() {
        //act
        var actual = c.getExperienceID();
        var expected = 34;

        //assert
        assertEquals(expected,actual);
    }
}