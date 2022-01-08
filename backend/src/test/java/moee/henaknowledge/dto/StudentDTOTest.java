package moee.henaknowledge.dto;

import moee.henaknowledge.module.Student;
import moee.henaknowledge.util.constant;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.sql.Date;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("test")
@SpringBootTest
class StudentDTOTest {
    //arange
    private StudentDTO michaelStudent = new StudentDTO("Michael","Osun", Date.valueOf(LocalDate.of(2000,12,24)),"mDan@gmail.com" ,
            "software engineering", "LKDFC", "Miko","mmm", constant.STUDENT_ROLE, 0);
    @Test
    void getSpecialization() {
        //act
        var actual = michaelStudent.getSpecialization();
        var expected= "software engineering";

        //assert
        assertEquals(expected,actual);
    }

    @Test
    void setSpecialization() {
        //act
        var newSpecialization = "databases";
        michaelStudent.setSpecialization(newSpecialization);
        var actual = michaelStudent.getSpecialization();
        var expected = newSpecialization;

        //assert
        assertEquals(expected,actual);
    }

    @Test
    void getCode() {
        //act
        var actual = michaelStudent.getCode();
        var expected= "LKDFC";

        //assert
        assertEquals(expected,actual);
    }

    @Test
    void setCode() {
        //act
        var newCode = "MJLAJ";
        michaelStudent.setCode(newCode);
        var actual = michaelStudent.getCode();
        var expected = newCode;

        //assert
        assertEquals(expected,actual);
    }

    @Test
    void getUsername() {
        //act
        var actual = michaelStudent.getUsername();
        var expected= "Miko";

        //assert
        assertEquals(expected,actual);
    }

    @Test
    void setUsername() {
        //act
        var newUsername = "MJLAJ";
        michaelStudent.setUsername(newUsername);
        var actual = michaelStudent.getUsername();
        var expected = newUsername;

        //assert
        assertEquals(expected,actual);
    }

    @Test
    void getPassword() {
        //act
        var actual = michaelStudent.getPassword();
        var expected= "mmm";

        //assert
        assertEquals(expected,actual);
    }

    @Test
    void setPassword() {
        //act
        var newPas = "newPass";
        michaelStudent.setPassword(newPas);
        var actual = michaelStudent.getPassword();
        var expected = newPas;

        //assert
        assertEquals(expected,actual);
    }

    @Test
    void getRole() {
        //act
        var actual = michaelStudent.getRole();
        var expected= "Student";

        //assert
        assertEquals(expected,actual);
    }

    @Test
    void getPoints() {
        //act
        var actual = michaelStudent.getPoints();
        var expected= 0;

        //assert
        assertEquals(expected,actual);
    }

    @Test
    void setPoints() {
        //act
        var newPointsScore = 200;
        michaelStudent.setPoints(newPointsScore);
        var actual = michaelStudent.getPoints();
        var expected = newPointsScore;

        //assert
        assertEquals(expected,actual);
    }

    @Test
    void testEquals() {
        //act
        StudentDTO Micko2 = new StudentDTO("Michael","Osun", Date.valueOf(LocalDate.of(2000,12,24)),"mDan@gmail.com" ,
                "software engineering", "LKDFC", "Miko","mmm",constant.STUDENT_ROLE, 0);
        //assert
        assertEquals(michaelStudent,Micko2);
    }

    @Test
    void testHashCode() {
        //act
        StudentDTO Micko2 = new StudentDTO("Michael","Osun", Date.valueOf(LocalDate.of(2000,12,24)),"mDan@gmail.com" ,
                "software engineering", "LKDFC", "Miko","mmm",constant.STUDENT_ROLE, 0);
        //assert
        assertTrue(michaelStudent.hashCode() == Micko2.hashCode());
    }
}