//package moee.henaknowledge.service_interfaces;
//
//import moee.henaknowledge.module.Admin;
//import moee.henaknowledge.module.Student;
//
//
//import org.junit.jupiter.api.*;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.dao.DataIntegrityViolationException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.test.context.ActiveProfiles;
//
//import java.sql.Date;
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@ActiveProfiles("test")
//@SpringBootTest
//class IStudentServiceTestFakeDB {
//
//    @Autowired
//    IStudentService service;
//
//    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//
//    @BeforeEach
//    void init() {
//        System.out.println("startup a new test");
//
//        Student hardcodedStudentH2 = new Student(1, "Micko","dan", Date.valueOf(LocalDate.of(2000,12,24)),"mDan@gmail.com" ,
//                "software engineering", "LKDFC", "Miko","Miko123","Student", 0);
//        Student hardcodedStudent_H2 = new Student(2, "Mohammed","Harbi", Date.valueOf(LocalDate.of(2000,12,24)),"mDan@gmail.com" ,
//                "software engineering", "FDGST1A", "Moe","Moe123","Student", 0);
//
//        //ACT
//        service.AddStudent(hardcodedStudentH2);
//        service.AddStudent(hardcodedStudent_H2);
//    }
//
//    @AfterEach
//    void finilize() {
//        service.DeleteStudent(1);
//        service.DeleteStudent(2);
//    }
//
//    @Test
//    void getStudentByUsername() {
//        var expected = "Miko";
//
//        var actual = service.getStudentByPersonID(1).getUsername();
//
//        //ASSERT
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    void getStudentByPersonID() {
//
//        //ACT
//        var actual = service.getStudentByPersonID(2);
//        var expected = new Student("Mohammed","Harbi", Date.valueOf(LocalDate.of(2000,12,24)),"mDan@gmail.com" ,
//                "software engineering", "FDGST1A", "Moe",actual.getPassword(),"Student", 0);;
//
//        //ASSERT
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    void addStudent() {
//
//        //ACT
//        Student JohnBell = new Student(3,"John","bell", Date.valueOf(LocalDate.of(2000,12,24)),"JohnBell@gmail.com" ,
//                "software engineering", "JKEWOPWEF2", "jojo","jo123123","Student", 0);
//        service.AddStudent(JohnBell);
//        var actual = service.getStudentByUsername("jojo");
//        var expected = JohnBell;
//        //ASSERT
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    void getAllStudents() {
//        //ACT
//        List<Student> expected = new ArrayList<>();
//
//        var actual = service.getAllStudents();
//
//        Student s1 = new Student("Micko","dan", Date.valueOf(LocalDate.of(2000,12,24)),"mDan@gmail.com" ,
//                "software engineering", "LKDFC", "Miko",actual.get(0).getPassword(),"Student", 0);
//        Student s2 = new Student("Mohammed","Harbi", Date.valueOf(LocalDate.of(2000,12,24)),"mDan@gmail.com" ,
//                "software engineering", "FDGST1A", "Moe",actual.get(1).getPassword(),"Student", 0);
//        Student s3 = new Student(3,"John","bell", Date.valueOf(LocalDate.of(2000,12,24)),"JohnBell@gmail.com" ,
//                "software engineering", "JKEWOPWEF2", "jojo",actual.get(2).getPassword(),"Student", 0);
//
//        expected.add(s1);
//        expected.add(s2);
//        expected.add(s3);
//
//        //ASSERT
//        assertEquals(expected, actual);
//    }
//
//
//    @Test
//    void setStudentInfoById() {
//
//        //ACT
//        service.setStudentInfoById(1, "moe", "harbi",  Date.valueOf(LocalDate.of(2000,12,24)),"mohammedalharbi@gmail.com");
//        var actual = service.getStudentByPersonID(1);
//        Student expected = new Student(1,"moe","harbi",   Date.valueOf(LocalDate.of(2000,12,24)),"mohammedalharbi@gmail.com" ,
//                "software engineering", "LKDFC", "Miko",actual.getPassword(),"Student", 0);
//
//        //ASSERT
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    void DeleteStudent(){
//        //ARRANGE
//        Student s3 = new Student("Marteen","lilam", Date.valueOf(LocalDate.of(2000,12,24)),"MLilm@gmail.com" ,
//                "software engineering", "JKEWOPWEF2", "jojo","KIpp","Student", 0);
//
//        //ACT
//        service.AddStudent(s3);
//        service.DeleteStudent(3);
//        var actual = service.getStudentByPersonID(3);
//
//        //ASSERT
//        assertEquals(null, actual);
//    }
//}