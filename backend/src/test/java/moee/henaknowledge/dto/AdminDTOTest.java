package moee.henaknowledge.dto;


import moee.henaknowledge.util.constant;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;


import java.sql.Date;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;


@ActiveProfiles("test")
@SpringBootTest
class AdminDTOTest {

    //arange
    private AdminDTO Mohammed = new AdminDTO(1,"Mohammed","Harbi", Date.valueOf(LocalDate.of(2000,12,24)),
            "Admin@gmail.com", "adminUsr", "adminPass123", constant.ADMIN_ROLE);

    @Test
    void getPersonID() {
        //act
        var actual = Mohammed.getPersonID();
        int expected = 1;

        //assert
        assertEquals(expected,actual);
    }


    @Test
    void getUsername() {
        //act
        var actual = Mohammed.getUsername();
        var expected = "adminUsr";

        //assert
        assertEquals(expected,actual);
    }

    @Test
    void setUsername() {
        //act
        var newUsrName = "Ahmed";
        Mohammed.setUsername(newUsrName);
        var actual = Mohammed.getUsername();
        var expected = newUsrName;

        //assert
        assertEquals(expected,actual);
    }

    @Test
    void getPassword() {
        //act
        var actual = Mohammed.getPassword();
        var expected = "adminPass123";

        //assert
        assertEquals(expected,actual);
    }

    @Test
    void setPassword() {
        //act
        var newPass = "444";
        Mohammed.setPassword(newPass);
        var actual = Mohammed.getPassword();
        var expected = newPass;

        //assert
        assertEquals(expected,actual);
    }

    @Test
    void getRole() {
        //act
        var actual = Mohammed.getRole();
        var expected = "Admin";

        //assert
        assertEquals(expected,actual);
    }

    @Test
    void testEquals() {
        //act
        AdminDTO Mohammed5 = new AdminDTO(1,"Mohammed","Harbi", Date.valueOf(LocalDate.of(2000,12,24)),
                "Admin@gmail.com", "adminUsr", "adminPass123",constant.ADMIN_ROLE);
        //assert
        assertEquals(Mohammed,Mohammed5);
    }

    @Test
    void testHashCode() {

        //act
        AdminDTO Mohammed5 = new AdminDTO(1,"Mohammed","Harbi", Date.valueOf(LocalDate.of(2000,12,24)),
                "Admin@gmail.com", "adminUsr", "adminPass123",constant.ADMIN_ROLE);
        //assert
        assertTrue(Mohammed.hashCode() == Mohammed5.hashCode());

    }
}