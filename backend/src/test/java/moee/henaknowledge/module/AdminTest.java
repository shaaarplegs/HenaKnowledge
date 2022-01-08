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
class AdminTest {

    //arange
    private Admin John = new Admin(2,"John","Doe", Date.valueOf(LocalDate.of(2000,12,24)),
            "Admin@gmail.com", "adminUsr", "adminPass123", constant.ADMIN_ROLE);

    @Test
    void getPersonID() {
        //act
        var actual = John.getPersonID();
        int expected = 2;

        //assert
        assertEquals(expected,actual);
    }


    @Test
    void getUsername() {
        //act
        var actual = John.getUsername();
        var expected = "adminUsr";

        //assert
        assertEquals(expected,actual);
    }

    @Test
    void setUsername() {
        //act
        var newUsrName = "difUser";
        John.setUsername(newUsrName);
        var actual = John.getUsername();
        var expected = newUsrName;

        //assert
        assertEquals(expected,actual);
    }

    @Test
    void getPassword() {
        //act
        var actual = John.getPassword();
        var expected = "adminPass123";

        //assert
        assertEquals(expected,actual);
    }

    @Test
    void setPassword() {
        //act
        var newPass = "difPass";
        John.setPassword(newPass);
        var actual = John.getPassword();
        var expected = newPass;

        //assert
        assertEquals(expected,actual);
    }

    @Test
    void getRole() {
        //act
        var actual = John.getRole();
        var expected = "Admin";

        //assert
        assertEquals(expected,actual);
    }

    @Test
    void testEquals() {
        //act
        Admin John2 = new Admin(2,"John","Doe", Date.valueOf(LocalDate.of(2000,12,24)),
                "Admin@gmail.com", "adminUsr", "adminPass123",constant.ADMIN_ROLE);
        //assert
        assertEquals(John,John2);
    }

    @Test
    void testHashCode() {

        //act
        Admin John2 = new Admin(2,"John","Doe", Date.valueOf(LocalDate.of(2000,12,24)),
                "Admin@gmail.com", "adminUsr", "adminPass123",constant.ADMIN_ROLE);
        //assert
        assertTrue(John.hashCode() == John2.hashCode());

    }
    @Test
    void testToString(){
        //act
        var actual = John.toString();
        var expected =  "Admin{" +
                "username='" + John.getUsername() + '\'' +
                ", password='" + John.getPassword() + '\'' +
                ", role='" + John.getRole() + '\'' +
                '}';

        //assert
        assertEquals(expected,actual);
    }

}