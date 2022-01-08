//package moee.henaknowledge.service_interfaces;
//
//import moee.henaknowledge.module.Admin;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
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
//
////switch to test properties so that unit tests use h2 instead of the production db
//@ActiveProfiles("test")
//
//@SpringBootTest
//class IAdminServiceTestFakeDB {
//
//    @Autowired
//    IAdminService service;
//
//    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//
//
//    @BeforeEach
//    void init() {
//        System.out.println("startup a new test");
//
//        Admin a1 = new Admin("mohammed", "harbi", Date.valueOf(LocalDate.of(2000,12,24)), "mohammedalharbi@gmail.com"
//                , "ADMIN", "ADMIN", "Admin");
//        Admin a2 = new Admin("miko", "osun", Date.valueOf(LocalDate.of(2000,12,24)), "mohammedalharbi@gmail.com"
//                , "HKADMIN", "HKADMIN", "Admin");
//
//        //ACT
//        service.AddAdmin(a1);
//        service.AddAdmin(a2);
//    }
//
//
//    @Test
//    void getAdminByUsername() {
//        var expected = "ADMIN";
//
//        var actual = service.getAdminByPersonID(1).getUsername();
//
//        //ASSERT
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    void getAdminByPersonID() {
//
//        //ACT
//        var actual = service.getAdminByPersonID(1);
//        var expected = new Admin("mohammed", "harbi", Date.valueOf(LocalDate.of(2000,12,24)), "mohammedalharbi@gmail.com"
//                , "ADMIN", actual.getPassword(), "Admin");
//
//        //ASSERT
//        assertEquals(expected, actual);
//    }
//
//
//
//    @Test
//    void addAdmin() {
//        //ACT
//        Admin khaledAdmin = new Admin("khaled", "kamal", Date.valueOf(LocalDate.of(2000,12,24)), "mohammedalharbi@gmail.com"
//                , "HK2ADMIN", "HK2ADMIN", "Admin");
//        service.AddAdmin(khaledAdmin);
//
//        var actual = service.getAdminByUsername("HK2ADMIN");
//
//        var expected = new Admin("khaled", "kamal", Date.valueOf(LocalDate.of(2000,12,24)), "mohammedalharbi@gmail.com"
//                , "HK2ADMIN", actual.getPassword(), "Admin");
//        //ASSERT
//        assertEquals(expected, actual);
//    }
//
//
//
//
//    @Test
//    void setAdminInfoById() {
//        //ACT
//        service.setAdminInfoById(1, "moe", "harbi",  Date.valueOf(LocalDate.of(2000,12,24)),"mohammedalharbi@gmail.com");
//        var actual = service.getAdminByPersonID(1);
//        Admin expected = new Admin(1, "moe", "harbi", Date.valueOf(LocalDate.of(2000,12,24)), "mohammedalharbi@gmail.com"
//                , "ADMIN", actual.getPassword(), "Admin");
//
//
//        //ASSERT
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    void deleteAdmin() {
//        //ACT
//        Admin a3 = new Admin("blabla", "harbi", Date.valueOf(LocalDate.of(2000,12,24)), "mohammedalharbi@gmail.com"
//                , "ADMIN", "A1", "Admin");
//        service.AddAdmin(a3);
//
//        service.DeleteAdmin(3);
//
//        Admin actual = service.getAdminByPersonID(3);
//
//        //ASSERT
//        assertEquals(null, actual);
//    }
//}