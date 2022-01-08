package moee.henaknowledge.service;

import moee.henaknowledge.Exceptions.UserDoesNotExistException;
import moee.henaknowledge.dal_interfaces.IAdminDAL;
import moee.henaknowledge.dal_interfaces.IStudentDAL;
import moee.henaknowledge.dto.StudentDTO;
import moee.henaknowledge.module.Admin;
import moee.henaknowledge.module.Student;
import moee.henaknowledge.repository.AdminDalJPA;
import moee.henaknowledge.repository.IAdminRepository;
import moee.henaknowledge.repository.IStudentRepository;
import moee.henaknowledge.repository.StudentDalJPA;
import moee.henaknowledge.service_interfaces.IAdminService;
import moee.henaknowledge.service_interfaces.IStudentService;
import moee.henaknowledge.util.constant;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
@ActiveProfiles("test")
@SpringBootTest
class StudentServiceTest {

    //ARRANGE

    IStudentRepository studentRepository;
    StudentDalJPA studentDalJPA;
    IStudentDAL studentDAL;
    StudentService service;
    Student michaelStudent;
    Student moe;

    @BeforeEach
    public void init () {
        //mocking the repos
        studentRepository = mock(IStudentRepository.class);
        studentDalJPA = new StudentDalJPA(studentRepository);
        //mocking the DAL into the service instance
        studentDAL = mock(IStudentDAL.class);
        service = new StudentService(studentDalJPA);
        michaelStudent = new Student(1,"Michael","Osun", Date.valueOf(LocalDate.of(2000,12,24)),"mDan@gmail.com" ,
                "software engineering", "LKDFC", "Miko","mmm", constant.STUDENT_ROLE, 0);
        moe = new Student(2,"mohammed","dan",Date.valueOf(LocalDate.of(2000,12,24)),"moe@gmail.com" ,
                "software engineering", "DCFS", "moe","c", constant.STUDENT_ROLE, 0);
        //ACT
        when(studentDalJPA.getStudentByUsername("Miko")).thenReturn(michaelStudent);
        when(studentDalJPA.getStudentByUsername("moe")).thenReturn(moe);
        when(studentDalJPA.getAllStudents()).thenReturn(Arrays.asList(michaelStudent,moe));
        when(studentDalJPA.getStudentByPersonID(2)).thenReturn(moe);
    }

    @Test
    void getStudentByUsername() {
        assertEquals(michaelStudent, service.getStudentByUsername("Miko"));
    }

    @Test
    void getStudentByUsernameDoesNotExists() {
        assertThrows(UserDoesNotExistException.class, () -> {
            when(service.getStudentByUsername(anyString())).thenThrow(UserDoesNotExistException.class);
            service.getStudentByUsername("Miko");
        });
    }


    @Test
    void getStudentByPersonID() {
        assertEquals(moe, service.getStudentByPersonID(2));
    }

    @Test
    void getStudentByPersonIDDoesNotExists() {
        assertThrows(UserDoesNotExistException.class, () -> {
            when(service.getStudentByPersonID(anyInt())).thenThrow(UserDoesNotExistException.class);
            service.getStudentByPersonID(60);
        });
    }

    @Test
    void getAllStudents() {
        assertEquals(Arrays.asList(michaelStudent,moe), service.getAllStudents());
    }

    @Test
    void addStudent() {
        Student Micko2 = new Student("Micko","dan",Date.valueOf(LocalDate.of(2000,12,24)),"mDan@gmail.com" ,
                "software engineering", "LKDFC", "Miko","c",constant.STUDENT_ROLE, 0);
        service.AddStudent(Micko2);

        verify(studentRepository, times(1)).save(Micko2);
    }

    @Test
    void deleteStudent() {
        service.DeleteStudent(2);
        verify(studentRepository, times(1)).delete(moe);
    }

    @Test
    void setStudentInfoById() {
        service.setStudentInfoById(6,"kamal","hamdi",
                Date.valueOf(LocalDate.of(2000,12,24)),"jamalhamid90@gmail.com");
        verify(studentRepository, times(1)).setStudentInfoById(6,"kamal","hamdi",
                Date.valueOf(LocalDate.of(2000,12,24)),"jamalhamid90@gmail.com");
    }

    @Test
    void updatePoints() {
        service.updatePoints(5,0);
        verify(studentRepository, times(1)).updatePoints(5,0);
    }
}