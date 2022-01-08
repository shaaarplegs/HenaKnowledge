package moee.henaknowledge.module;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;
@ActiveProfiles("test")
@SpringBootTest
class ExperienceOpinionTest {

    //arange
    private ExperienceOpinion eo = new ExperienceOpinion(5,1,0,10,7);



    @Test
    void setOpinionID() {
        //act
        var newID = 9;
        eo.setOpinionID(newID);
        var actual = eo.getOpinionID();
        var expected = newID;

        //assert
        assertEquals(expected,actual);
    }

    @Test
    void setLikes() {
        //act
        var newLike = 123;
        eo.setLikes(newLike);
        var actual = eo.getLikes();
        var expected = newLike;

        //assert
        assertEquals(expected,actual);
    }

    @Test
    void setDislikes() {
        //act
        var newDisLike = 75;
        eo.setDislikes(newDisLike);
        var actual = eo.getDislikes();
        var expected = newDisLike;

        //assert
        assertEquals(expected,actual);
    }

    @Test
    void setExperienceID() {
        //act
        var newExperienceID = 95;
        eo.setExperienceID(newExperienceID);
        var actual = eo.getExperienceID();
        var expected = newExperienceID;

        //assert
        assertEquals(expected,actual);
    }

    @Test
    void setPersonID() {
        //act
        var newPersonID = 88;
        eo.setPersonID(newPersonID);
        var actual = eo.getPersonID();
        var expected = newPersonID;

        //assert
        assertEquals(expected,actual);
    }

    @Test
    void getOpinionID() {
        //act
        var actual = eo.getOpinionID();
        var expected = 5;

        //assert
        assertEquals(expected,actual);
    }

    @Test
    void getLikes() {
        //act
        var actual = eo.getLikes();
        var expected = 1;

        //assert
        assertEquals(expected,actual);
    }

    @Test
    void getDislikes() {
        //act
        var actual = eo.getDislikes();
        var expected = 0;

        //assert
        assertEquals(expected,actual);
    }

    @Test
    void getExperienceID() {
        //act
        var actual = eo.getExperienceID();
        var expected = 10;

        //assert
        assertEquals(expected,actual);
    }

    @Test
    void getPersonID() {
        //act
        var actual = eo.getPersonID();
        var expected = 7;

        //assert
        assertEquals(expected,actual);
    }
}