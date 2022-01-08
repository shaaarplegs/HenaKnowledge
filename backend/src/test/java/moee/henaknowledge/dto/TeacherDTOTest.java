package moee.henaknowledge.dto;

import moee.henaknowledge.module.Teacher;
import moee.henaknowledge.util.constant;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.sql.Date;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;


@ActiveProfiles("test")
@SpringBootTest
class TeacherDTOTest {

    //arange
     TeacherDTO tomTeacher = new TeacherDTO("Tom","Julo", Date.valueOf(LocalDate.of(2000,12,24)),"jDan@gmail.com" ,
            "db and management", "LKDFC", "Tom123","imtompass", constant.TEACHER_ROLE, 0);
    @Test
    void getSpecialization() {
        //act
        var actual = tomTeacher.getSpecialization();
        var expected= "db and management";

        //assert
        assertEquals(expected,actual);
    }

    @Test
    void setSpecialization() {
        //act
        var newSpecialization = "databases";
        tomTeacher.setSpecialization(newSpecialization);
        var actual = tomTeacher.getSpecialization();
        var expected = newSpecialization;

        //assert
        assertEquals(expected,actual);
    }

    @Test
    void getCode() {
        //act
        var actual = tomTeacher.getCode();
        var expected= "LKDFC";

        //assert
        assertEquals(expected,actual);
    }

    @Test
    void setCode() {
        //act
        var newCode = "MJLAJ";
        tomTeacher.setCode(newCode);
        var actual = tomTeacher.getCode();
        var expected = newCode;

        //assert
        assertEquals(expected,actual);
    }

    @Test
    void getUsername() {
        //act
        var actual = tomTeacher.getUsername();
        var expected= "Tom123";

        //assert
        assertEquals(expected,actual);
    }

    @Test
    void setUsername() {
        //act
        var newCode = "MJLAJ";
        tomTeacher.setCode(newCode);
        var actual = tomTeacher.getCode();
        var expected = newCode;

        //assert
        assertEquals(expected,actual);
    }

    @Test
    void getPassword() {
        //act
        var actual = tomTeacher.getPassword();
        var expected= "imtompass";

        //assert
        assertEquals(expected,actual);
    }

    @Test
    void setPassword() {
        //act
        var newPas = "newPass";
        tomTeacher.setPassword(newPas);
        var actual = tomTeacher.getPassword();
        var expected = newPas;

        //assert
        assertEquals(expected,actual);
    }

    @Test
    void getRole() {
        //act
        var actual = tomTeacher.getRole();
        var expected= "Teacher";

        //assert
        assertEquals(expected,actual);
    }

    @Test
    void getPoints() {
        //act
        var actual = tomTeacher.getPoints();
        var expected= 0;

        //assert
        assertEquals(expected,actual);
    }

    @Test
    void setPoints() {
        //act
        var newPointsScore = 200;
        tomTeacher.setPoints(newPointsScore);
        var actual = tomTeacher.getPoints();
        var expected = newPointsScore;

        //assert
        assertEquals(expected,actual);
    }

    @Test
    void testEquals() {
        //act
        TeacherDTO Dan2 = new TeacherDTO("Tom","Julo", Date.valueOf(LocalDate.of(2000,12,24)),"jDan@gmail.com" ,
                "db and management", "LKDFC", "Tom123","imtompass",constant.TEACHER_ROLE, 0);
        //assert
        assertEquals(tomTeacher,Dan2);
    }

    @Test
    void testHashCode() {
        //act
        TeacherDTO Dan2 = new TeacherDTO("Tom","Julo", Date.valueOf(LocalDate.of(2000,12,24)),"jDan@gmail.com" ,
                "db and management", "LKDFC", "Tom123","imtompass",constant.TEACHER_ROLE, 0);
        //assert
        assertTrue(tomTeacher.hashCode() == Dan2.hashCode());
    }
}