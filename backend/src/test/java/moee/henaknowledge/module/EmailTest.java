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
class EmailTest {

    //Arrange
    String to = "mohammedalharbi@gmail.com";
    String subject = "Test email";
    String body = "This is an automatic email for testing purposes.";
    Email email = new Email(to, subject, body);

    @Test
    public void TestGetToString() {
        //ACT
        var actual = email.getTo();
        var expected = "mohammedalharbi@gmail.com";
        //ASSERT
        assertEquals(expected, actual);
    }

    @Test
    public void TestGetSubjectString() {
        //ACT
        var actual = email.getSubject();
        var expected = "Test email";
        //ASSERT
        assertEquals(expected, actual);
    }

    @Test
    public void TestGetBodyString() {
        //ACT
        var actual = email.getText();
        var expected = "This is an automatic email for testing purposes.";
        //ASSERT
        assertEquals(expected, actual);
    }

    @Test
    void testEquals() {
        //act
        Email email2 = new Email(to, subject, body);
        //assert
        assertEquals(email,email2);
    }

    @Test
    void testHashCode() {

        //act
        Email email2 = new Email(to, subject, body);
        //assert
        assertTrue(email.hashCode() == email2.hashCode());

    }
}