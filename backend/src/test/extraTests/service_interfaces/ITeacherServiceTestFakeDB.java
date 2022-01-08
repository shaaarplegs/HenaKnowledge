package moee.henaknowledge.service_interfaces;


import moee.henaknowledge.module.Admin;
import moee.henaknowledge.module.Student;
import moee.henaknowledge.module.Teacher;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.ActiveProfiles;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

//switch to test properties so that unit tests use h2 instead of the production db
@ActiveProfiles("test")

@SpringBootTest
class ITeacherServiceTestFakeDB {

    @Autowired
    ITeacherService service;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @BeforeEach
    void init() {
        System.out.println("startup a new test");

        Teacher t1 = new Teacher("Hozyfa","zaho", Date.valueOf(LocalDate.of(2000,12,24)),"Hozyfa@gmail.com" ,
                "db and management", "LKDFC", "HZZ","HZZ1","Teacher", 0);
        Teacher t2 = new Teacher("Michael","tranop", Date.valueOf(LocalDate.of(2000,12,24)),"mmmlio@gmail.com" ,
                "Frontend developer", "SZA", "Michaelzxc","zxc123","Teacher", 0);

        //ACT
        service.AddTeacher(t1);
        service.AddTeacher(t2);
    }


    @Test
    void getTeacherByUsername() {
        var expected = "HZZ";

        var actual = service.getTeacherByPersonID(1).getUsername();

        //ASSERT
        assertEquals(expected, actual);
    }

    @Test
    void getTeacherByPersonID() {

        //ACT
        var actual = service.getTeacherByPersonID(1);
        var expected = new Teacher("Hozyfa","zaho", Date.valueOf(LocalDate.of(2000,12,24)),"Hozyfa@gmail.com" ,
                "db and management", "LKDFC", "HZZ",actual.getPassword(),"Teacher", 0);;

        //ASSERT
        assertEquals(expected, actual);
    }



    @Test
    void addTeacher() {
//ACT
        Teacher khaledTeacher = new Teacher("Khaled","zaho", Date.valueOf(LocalDate.of(2000,12,24)),"Hozyfa@gmail.com" ,
                "db and management", "LKDFC", "KHA","KHA1","Teacher", 0);

        service.AddTeacher(khaledTeacher);
        var actual = service.getTeacherByUsername("KHA");
        var expected = khaledTeacher;
        //ASSERT
        assertEquals(expected, actual);
    }

    @Test
    void getAllTeachers() {

        //ACT
        List<Teacher> expected = new ArrayList<>();

        var actual = service.getAllTeachers();

        Teacher t1 = new Teacher("Hozyfa","zaho", Date.valueOf(LocalDate.of(2000,12,24)),"Hozyfa@gmail.com" ,
                "db and management", "LKDFC", "HZZ",actual.get(0).getPassword(),"Teacher", 0);
        Teacher t2 = new Teacher("Michael","tranop", Date.valueOf(LocalDate.of(2000,12,24)),"mmmlio@gmail.com" ,
                "Frontend developer", "SZA", "Michaelzxc",actual.get(1).getPassword(),"Teacher", 0);

        expected.add(t1);
        expected.add(t2);


        //ASSERT
        assertEquals(expected, actual);
    }


    @Test
    void setTeacherInfoById() {
        //ACT
        service.setTeacherInfoById(1, "moe", "harbi",  Date.valueOf(LocalDate.of(2000,12,24)),"mohammedalharbi@gmail.com");
        var actual = service.getTeacherByPersonID(1);
        Teacher expected = new Teacher("moe","harbi", Date.valueOf(LocalDate.of(2000,12,24)),"mohammedalharbi@gmail.com" ,
                "db and management", "LKDFC", "HZZ",actual.getPassword(),"Teacher", 0);


        //ASSERT
        assertEquals(expected, actual);
    }

    @Test
    void DeleteStudent(){
        //ARRANGE
        Teacher t3 = new Teacher("Marteen","lilam", Date.valueOf(LocalDate.of(2000,12,24)),"MLilm@gmail.com" ,
                "software engineering", "JKEWOPWEF2", "jojo","KIpp","Teacher", 0);

        //ACT
        service.AddTeacher(t3);
        service.DeleteTeacher(3);
        var actual = service.getTeacherByPersonID(3);

        //ASSERT
        assertEquals(null, actual);
    }
}