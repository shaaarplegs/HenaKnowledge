package moee.henaknowledge.service;

import moee.henaknowledge.dal_interfaces.IAdminDAL;
import moee.henaknowledge.dal_interfaces.ITeacherDAL;
import moee.henaknowledge.dto.AdminDTO;
import moee.henaknowledge.module.Admin;
import moee.henaknowledge.module.Teacher;
import moee.henaknowledge.repository.AdminDalJPA;
import moee.henaknowledge.repository.IAdminRepository;
import moee.henaknowledge.repository.ITeacherRepository;
import moee.henaknowledge.repository.TeacherDalJPA;
import moee.henaknowledge.service_interfaces.IAdminService;
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
class AdminServiceTest {

    //ARRANGE

    IAdminRepository adminRepos;
    AdminDalJPA AdminJPA;
    IAdminDAL adminDAL;
    AdminService adminService;
    Admin Mohammed;
    Admin John;

    @BeforeEach
    public void init () {
        //mocking the repos
        adminRepos = mock(IAdminRepository.class);
        AdminJPA = new AdminDalJPA(adminRepos);
        //mocking the DAL into the service instance
        adminDAL = mock(IAdminDAL.class);
        adminService = new AdminService(AdminJPA);
          Mohammed = new Admin(1,"Mohammed","Harbi", Date.valueOf(LocalDate.of(2000,12,24)),
                "Admin@gmail.com", "adminUsr", "adminPass123", constant.ADMIN_ROLE);
          John = new Admin(2,"John","Doe", Date.valueOf(LocalDate.of(2000,12,24)),
                "Admin@gmail.com", "admin2", "adminPass123", constant.ADMIN_ROLE);

          //ACT
        when(AdminJPA.getAdminByUsername("admin2")).thenReturn(John);
        when(AdminJPA.getAdminByUsername("adminUsr")).thenReturn(Mohammed);
        when(AdminJPA.getAllAdmins()).thenReturn(Arrays.asList(Mohammed,John));
        when(AdminJPA.getAdminByPersonID(2)).thenReturn(John);
    }


    @Test
    void getAdminByUsername() {
        assertEquals(Mohammed, adminService.getAdminByUsername("adminUsr"));
    }

    @Test
    void getAdminByPersonID() {
        assertEquals(John, adminService.getAdminByPersonID(2));
    }

    @Test
    void getAllAdmins() {
        assertEquals(Arrays.asList(Mohammed,John), adminService.getAllAdmins());
    }

    @Test
    void addAdmin() {
        Admin John2 = new Admin(2,"Johnkkki","Doe", Date.valueOf(LocalDate.of(2000,12,24)),
                "Admin@gmail.com", "adminUssr", "adminPass123",constant.ADMIN_ROLE);
        //ACT
        adminService.AddAdmin(John2);

        verify(adminRepos, times(1)).save(John2);
    }

    @Test
    void deleteAdmin() {
        //ACT
        adminService.DeleteAdmin(2);
        verify(adminRepos, times(1)).delete(John);
    }

    @Test
    void setAdminInfoById() {
        //ACT
        adminService.setAdminInfoById(5,"khaled","jamal", Date.valueOf(LocalDate.of(2000,12,24))
        ,"jmalalyati@gmail.com");
        verify(adminRepos, times(1)).setAdminInfoById(5,"khaled","jamal", Date.valueOf(LocalDate.of(2000,12,24))
                ,"jmalalyati@gmail.com");
    }
}