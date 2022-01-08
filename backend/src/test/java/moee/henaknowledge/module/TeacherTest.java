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
class TeacherTest {
    //(int personID,String firstName, String lastName, Date dateOfBirth, String email, String specialization, String code, String username, String password, String role, int points)
    //arange
    private Teacher Dan = new Teacher("Dan","John", Date.valueOf(LocalDate.of(2000,12,24)),"jDan@gmail.com" ,
            "db and management", "LKDFC", "Miko","c", constant.TEACHER_ROLE, 0);
    @Test
    void getSpecialization() {
        //act
        var actual = Dan.getSpecialization();
        var expected= "db and management";

        //assert
        assertEquals(expected,actual);
    }

    @Test
    void setSpecialization() {
        //act
        var newSpecialization = "databases";
        Dan.setSpecialization(newSpecialization);
        var actual = Dan.getSpecialization();
        var expected = newSpecialization;

        //assert
        assertEquals(expected,actual);
    }

    @Test
    void getCode() {
        //act
        var actual = Dan.getCode();
        var expected= "LKDFC";

        //assert
        assertEquals(expected,actual);
    }

    @Test
    void setCode() {
        //act
        var newCode = "MJLAJ";
        Dan.setCode(newCode);
        var actual = Dan.getCode();
        var expected = newCode;

        //assert
        assertEquals(expected,actual);
    }

    @Test
    void getUsername() {
        //act
        var actual = Dan.getUsername();
        var expected= "Miko";

        //assert
        assertEquals(expected,actual);
    }

    @Test
    void setUsername() {
        //act
        var newCode = "MJLAJ";
        Dan.setCode(newCode);
        var actual = Dan.getCode();
        var expected = newCode;

        //assert
        assertEquals(expected,actual);
    }

    @Test
    void getPassword() {
        //act
        var actual = Dan.getPassword();
        var expected= "c";

        //assert
        assertEquals(expected,actual);
    }

    @Test
    void setPassword() {
        //act
        var newPas = "newPass";
        Dan.setPassword(newPas);
        var actual = Dan.getPassword();
        var expected = newPas;

        //assert
        assertEquals(expected,actual);
    }

    @Test
    void getRole() {
        //act
        var actual = Dan.getRole();
        var expected= "Teacher";

        //assert
        assertEquals(expected,actual);
    }

    @Test
    void getPoints() {
        //act
        var actual = Dan.getPoints();
        var expected= 0;

        //assert
        assertEquals(expected,actual);
    }

    @Test
    void setPoints() {
        //act
        var newPointsScore = 200;
        Dan.setPoints(newPointsScore);
        var actual = Dan.getPoints();
        var expected = newPointsScore;

        //assert
        assertEquals(expected,actual);
    }

    @Test
    void testEquals() {
        //act
        Teacher Dan2 = new Teacher("Dan","John", Date.valueOf(LocalDate.of(2000,12,24)),"jDan@gmail.com" ,
                "db and management", "LKDFC", "Miko","c",constant.TEACHER_ROLE, 0);
        //assert
        assertEquals(Dan,Dan2);
    }

    @Test
    void testHashCode() {
        //act
        Teacher Dan2 = new Teacher("Dan","John", Date.valueOf(LocalDate.of(2000,12,24)),"jDan@gmail.com" ,
                "db and management", "LKDFC", "Miko","c",constant.TEACHER_ROLE, 0);
        //assert
        assertTrue(Dan.hashCode() == Dan2.hashCode());
    }

    @Test
    void testToString() {
        //act
        var actual = Dan.toString();

        var expected = "Teacher{" +
        "specialization='" + Dan.getSpecialization() + '\'' +
        ", code='" + Dan.getCode() + '\'' +
        ", username='" + Dan.getUsername() + '\'' +
        ", password='" + Dan.getPassword() + '\'' +
        ", role='" + Dan.getRole() + '\'' +
        ", points=" + Dan.getPoints() +
        '}';

        //assert
        assertEquals(expected,actual);
    }
}