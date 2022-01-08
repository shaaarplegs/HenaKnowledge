package moee.henaknowledge.module;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;
@ActiveProfiles("test")
@SpringBootTest
class ContactTest {

    //arange
    private Contact c = new Contact(5,"what is springboot?","it is a mircoservice used to quickly develop software solutions!"
    ,0,1,0,55,340);


    @Test
    void setID() {
        //act
        var newID = 5;
        c.setID(newID);
        var actual = c.getID();
        var expected = newID;

        //assert
        assertEquals(expected,actual);
    }

    @Test
    void setStudentQuestion() {
        //act
        var newQuestion = "what is flurt?";
        c.setStudentQuestion(newQuestion);
        var actual = c.getStudentQuestion();
        var expected = newQuestion;

        //assert
        assertEquals(expected,actual);
    }

    @Test
    void setTeacherResponse() {
        //act
        var newAnswer = "frontend framework.";
        c.setTeacherResponse(newAnswer);
        var actual = c.getTeacherResponse();
        var expected = newAnswer;

        //assert
        assertEquals(expected,actual);
    }

    @Test
    void setPending() {
        //act
        var newPendingState = 0;
        c.setPending(newPendingState);
        var actual = c.getPending();
        var expected = newPendingState;

        //assert
        assertEquals(expected,actual);
    }

    @Test
    void setWasUseful() {
        //act
        var newWasUsefulState = 1;
        c.setWasUseful(newWasUsefulState);
        var actual = c.getWasUseful();
        var expected = newWasUsefulState;

        //assert
        assertEquals(expected,actual);
    }

    @Test
    void setWasNotUseful() {
        //act
        var newWasNotUsefulState = 0;
        c.setWasNotUseful(newWasNotUsefulState);
        var actual = c.getWasNotUseful();
        var expected = newWasNotUsefulState;

        //assert
        assertEquals(expected,actual);
    }

    @Test
    void setStudentID() {
        //act
        var newstudentID = 0;
        c.setStudentID(newstudentID);
        var actual = c.getStudentID();
        var expected = newstudentID;

        //assert
        assertEquals(expected,actual);
    }

    @Test
    void setTeacherID() {
        //act
        var newtewacherID = 0;
        c.setTeacherID(newtewacherID);
        var actual = c.getTeacherID();
        var expected = newtewacherID;

        //assert
        assertEquals(expected,actual);
    }




    @Test
    void getID() {
        //act
        var actual = c.getID();
        var expected = 5;

        //assert
        assertEquals(expected,actual);
    }

    @Test
    void getStudentQuestion() {
        //act
        var actual = c.getStudentQuestion();
        var expected = "what is springboot?";

        //assert
        assertEquals(expected,actual);
    }

    @Test
    void getTeacherResponse() {
        //act
        var actual = c.getTeacherResponse();
        var expected = "it is a mircoservice used to quickly develop software solutions!";

        //assert
        assertEquals(expected,actual);
    }

    @Test
    void getPending() {
        //act
        var actual = c.getPending();
        var expected = 0;

        //assert
        assertEquals(expected,actual);
    }

    @Test
    void getWasUseful() {
        //act
        var actual = c.getWasUseful();
        var expected = 1;

        //assert
        assertEquals(expected,actual);
    }

    @Test
    void getWasNotUseful() {
        //act
        var actual = c.getWasNotUseful();
        var expected = 0;

        //assert
        assertEquals(expected,actual);
    }

    @Test
    void getStudentID() {
        //act
        var actual = c.getStudentID();
        var expected = 55;

        //assert
        assertEquals(expected,actual);
    }

    @Test
    void getTeacherID() {
        //act
        var actual = c.getTeacherID();
        var expected = 340;

        //assert
        assertEquals(expected,actual);
    }
}