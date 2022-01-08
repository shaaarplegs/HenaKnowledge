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
class StudentTest {
    //(int personID,String firstName, String lastName, Date dateOfBirth, String email, String specialization, String code, String username, String password, String role, int points)
    //arange
    private Student Micko = new Student("Micko","dan",Date.valueOf(LocalDate.of(2000,12,24)),"mDan@gmail.com" ,
            "software engineering", "LKDFC", "Miko","c", constant.STUDENT_ROLE, 0);
    @Test
    void getSpecialization() {
        //act
        var actual = Micko.getSpecialization();
        var expected= "software engineering";

        //assert
        assertEquals(expected,actual);
    }

    @Test
    void setSpecialization() {
        //act
        var newSpecialization = "databases";
        Micko.setSpecialization(newSpecialization);
        var actual = Micko.getSpecialization();
        var expected = newSpecialization;

        //assert
        assertEquals(expected,actual);
    }

    @Test
    void getCode() {
        //act
        var actual = Micko.getCode();
        var expected= "LKDFC";

        //assert
        assertEquals(expected,actual);
    }

    @Test
    void setCode() {
        //act
        var newCode = "MJLAJ";
        Micko.setCode(newCode);
        var actual = Micko.getCode();
        var expected = newCode;

        //assert
        assertEquals(expected,actual);
    }

    @Test
    void getUsername() {
        //act
        var actual = Micko.getUsername();
        var expected= "Miko";

        //assert
        assertEquals(expected,actual);
    }

    @Test
    void setUsername() {
        //act
        var newUsername = "MJLAJ";
        Micko.setUsername(newUsername);
        var actual = Micko.getUsername();
        var expected = newUsername;

        //assert
        assertEquals(expected,actual);
    }

    @Test
    void getPassword() {
        //act
        var actual = Micko.getPassword();
        var expected= "c";

        //assert
        assertEquals(expected,actual);
    }

    @Test
    void setPassword() {
        //act
        var newPas = "newPass";
        Micko.setPassword(newPas);
        var actual = Micko.getPassword();
        var expected = newPas;

        //assert
        assertEquals(expected,actual);
    }

    @Test
    void getRole() {
        //act
        var actual = Micko.getRole();
        var expected= "Student";

        //assert
        assertEquals(expected,actual);
    }

    @Test
    void getPoints() {
        //act
        var actual = Micko.getPoints();
        var expected= 0;

        //assert
        assertEquals(expected,actual);
    }

    @Test
    void setPoints() {
        //act
        var newPointsScore = 200;
        Micko.setPoints(newPointsScore);
        var actual = Micko.getPoints();
        var expected = newPointsScore;

        //assert
        assertEquals(expected,actual);
    }

    @Test
    void testEquals() {
        //act
        Student Micko2 = new Student("Micko","dan",Date.valueOf(LocalDate.of(2000,12,24)),"mDan@gmail.com" ,
                "software engineering", "LKDFC", "Miko","c",constant.STUDENT_ROLE, 0);
        //assert
        assertEquals(Micko,Micko2);
    }

    @Test
    void testHashCode() {
        //act
        Student Micko2 = new Student("Micko","dan",Date.valueOf(LocalDate.of(2000,12,24)),"mDan@gmail.com" ,
                "software engineering", "LKDFC", "Miko","c",constant.STUDENT_ROLE, 0);
        //assert
        assertTrue(Micko.hashCode() == Micko2.hashCode());
    }

    @Test
    void testToString() {
        //act
        var actual = Micko.toString();
        var expected =  "Student{" +
                "specialization='" + Micko.getSpecialization() + '\'' +
                ", code='" + Micko.getCode() + '\'' +
                ", username='" + Micko.getUsername() + '\'' +
                ", password='" + Micko.getPassword() + '\'' +
                ", role='" + Micko.getRole() + '\'' +
                ", points=" + Micko.getPoints() +
                '}';

        //assert
        assertEquals(expected,actual);

    }
}