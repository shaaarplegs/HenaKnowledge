package moee.henaknowledge.module;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;
@ActiveProfiles("test")
@SpringBootTest
class ExperienceTest {

    //arange
    private Experience exp = new Experience(15,"trip to the desert",
            "I went to the desert. thank you", 0,0,7);

    @Test
    void setExperienceID() {
        //act
        var newExpID = 0;
        exp.setExperienceID(newExpID);
        var actual = exp.getExperienceID();
        var expected = newExpID;

        //assert
        assertEquals(expected,actual);
    }

    @Test
    void setTitle() {
        //act
        var newTitle = "bad experience to the desert.";
        exp.setTitle(newTitle);
        var actual = exp.getTitle();
        var expected = newTitle;

        //assert
        assertEquals(expected,actual);
    }

    @Test
    void setDescription() {
        //act
        var newDescription = "one night day I went to the desert and I saw some snakes, it was freezing at night but blazing hot afternoon!";
        exp.setDescription(newDescription);
        var actual = exp.getDescription();
        var expected = newDescription;

        //assert
        assertEquals(expected,actual);
    }

    @Test
    void setLikes() {
        //act
        var newLikes = 4;
        exp.setLikes(newLikes);
        var actual = exp.getLikes();
        var expected = newLikes;

        //assert
        assertEquals(expected,actual);
    }

    @Test
    void setDislikes() {
        //act
        var newDislikes = 7;
        exp.setDislikes(newDislikes);
        var actual = exp.getDislikes();
        var expected = newDislikes;

        //assert
        assertEquals(expected,actual);
    }

    @Test
    void setPersonID() {
        //act
        var newPersonID = 80;
        exp.setPersonID(newPersonID);
        var actual = exp.getPersonID();
        var expected = newPersonID;

        //assert
        assertEquals(expected,actual);
    }

    @Test
    void getExperienceID() {
        //act
        var actual = exp.getExperienceID();
        var expected = 15;

        //assert
        assertEquals(expected,actual);
    }

    @Test
    void getTitle() {
        //act
        var actual = exp.getTitle();
        var expected = "trip to the desert";

        //assert
        assertEquals(expected,actual);
    }

    @Test
    void getDescription() {
        //act
        var actual = exp.getDescription();
        var expected = "I went to the desert. thank you";

        //assert
        assertEquals(expected,actual);
    }

    @Test
    void getLikes() {
        //act
        var actual = exp.getLikes();
        var expected = 0;

        //assert
        assertEquals(expected,actual);
    }

    @Test
    void getDislikes() {
        //act
        var actual = exp.getDislikes();
        var expected = 0;

        //assert
        assertEquals(expected,actual);
    }

    @Test
    void getPersonID() {
        //act
        var actual = exp.getPersonID();
        var expected = 7;

        //assert
        assertEquals(expected,actual);
    }
}