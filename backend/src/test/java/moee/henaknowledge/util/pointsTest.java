package moee.henaknowledge.util;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("test")
@SpringBootTest
class pointsTest {

    @Test
    public void TestPointsPerExperience() {
        var actual = points.pointsPerExperience;
        var expected = 4;
        assertEquals(expected, actual);
    }

    @Test
    public void TestPointsPerLike() {
        var actual = points.pointsPerLike;
        var expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    public void TestPointsPerDislike() {
        var actual = points.pointsPerDislike;
        var expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    public void TestPointsPerQuestion() {
        var actual = points.pointsPerQuestion;
        var expected = 2;
        assertEquals(expected, actual);
    }

    @Test
    public void TestPointsPerAnswer() {
        var actual = points.pointsPerAnswer;
        var expected = 4;
        assertEquals(expected, actual);
    }
}