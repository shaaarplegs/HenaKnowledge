package moee.henaknowledge.service;

import moee.henaknowledge.Exceptions.UserDoesNotExistException;
import moee.henaknowledge.dal_interfaces.ITeacherDAL;
import moee.henaknowledge.dto.TeacherDTO;
import moee.henaknowledge.module.Teacher;
import moee.henaknowledge.repository.ITeacherRepository;
import moee.henaknowledge.repository.TeacherDalJPA;
import moee.henaknowledge.util.constant;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;
@ActiveProfiles("test")
@SpringBootTest
class TeacherServiceTest {

    ITeacherRepository teacherRepos;
    TeacherDalJPA TeacherJpa;
    ITeacherDAL teacherDAL;
    TeacherService teacherService;
    Teacher tomTeacher;
    Teacher Dan;

    private Teacher mohammed;

    @BeforeEach
    public void init () {
        //mocking the repos
         teacherRepos = mock(ITeacherRepository.class);
         TeacherJpa = new TeacherDalJPA(teacherRepos);
        //mocking the DAL into the service instance
         teacherDAL = mock(ITeacherDAL.class);
         teacherService = new TeacherService(TeacherJpa);
         tomTeacher = new Teacher("Tom","Julo", Date.valueOf(LocalDate.of(2000,12,24)),"jDan@gmail.com" ,
                "db and management", "LKDFC", "Tom123","imtompass", constant.TEACHER_ROLE, 0);
         Dan = new Teacher(2,"Dan","John", Date.valueOf(LocalDate.of(2000,12,24)),"jDan@gmail.com" ,
                "db and management", "LKDFC", "Miko","c", constant.TEACHER_ROLE, 0);
         mohammed = new Teacher(3,"Mohammed","John", Date.valueOf(LocalDate.of(2000,12,24)),"jDan@gmail.com" ,
                 "db and management", "LKDFC", "mmm","c", constant.TEACHER_ROLE, 0);

        when(TeacherJpa.getTeacherByUsername("Tom123")).thenReturn(tomTeacher);
        when(TeacherJpa.getTeacherByUsername("Miko")).thenReturn(Dan);
        when(TeacherJpa.getAllTeachers()).thenReturn(Arrays.asList(tomTeacher,Dan));
        when(TeacherJpa.getTeacherByPersonID(2)).thenReturn(Dan);
    }

    @Test
    void getTeacherByUsernameReturnedObject() {

        assertEquals(tomTeacher, teacherService.getTeacherByUsername("Tom123"));

    }

    @Test
    void getTeacherByUsernameDoesNotExists() {
        assertThrows(UserDoesNotExistException.class, () -> {
            when(TeacherJpa.getTeacherByUsername("dad")).thenThrow(UserDoesNotExistException.class);
            teacherService.getTeacherByUsername("dad");
        });
    }

    @Test
    void getTeacherByPersonID() {
        assertEquals(Dan, teacherService.getTeacherByPersonID(2));
    }

    @Test
    void getTeacherByIDDoesNotExists() {
        assertThrows(UserDoesNotExistException.class, () -> {
            when(TeacherJpa.getTeacherByPersonID(anyInt())).thenThrow(UserDoesNotExistException.class);
            teacherService.getTeacherByPersonID(12);
        });
    }


    @Test
    void getAllTeachers() {
        assertEquals(Arrays.asList(tomTeacher,Dan), teacherService.getAllTeachers());
    }


    @Test
    void addTeacherFromBothJpaAndService() {
        TeacherJpa.AddTeacher(mohammed);
        teacherService.AddTeacher(mohammed);
        verify(teacherRepos, times(2)).save(mohammed);
    }

    @Test
    void addTeacherOnlyInService() {
        teacherService.AddTeacher(mohammed);
        verify(teacherRepos, times(1)).save(mohammed);
    }

    @Test
    void deleteTeacher() {
        teacherService.DeleteTeacher(2);
        verify(teacherRepos, times(1)).delete(Dan);
    }

    @Test
    void setTeacherInfoById() {
        teacherService.setTeacherInfoById(3,"jamal","lamh",
                Date.valueOf(LocalDate.of(1988,5,3)),"jmL@gmail.com");
        verify(teacherRepos, times(1)).setTeacherInfoById(3,"jamal","lamh",
                Date.valueOf(LocalDate.of(1988,5,3)),"jmL@gmail.com");
    }

    @Test
    void updatePoints() {
        teacherService.updatePoints(2,15);
        verify(teacherRepos, times(1)).updatePoints(2,15);
    }
}