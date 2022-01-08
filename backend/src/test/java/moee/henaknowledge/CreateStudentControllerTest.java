package moee.henaknowledge;


import moee.henaknowledge.controller.AdminController;
import moee.henaknowledge.controller.StudentController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;
@ActiveProfiles("test")
@SpringBootTest
public class CreateStudentControllerTest {
    @Autowired
    private StudentController studentController;

    @Test
    public void contextLoads() throws Exception {
        assertThat(studentController).isNotNull();
    }
}
