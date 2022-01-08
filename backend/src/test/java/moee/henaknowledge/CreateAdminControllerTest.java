package moee.henaknowledge;

import moee.henaknowledge.controller.AdminController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;
@ActiveProfiles("test")
@SpringBootTest
public class CreateAdminControllerTest {
    @Autowired
    private AdminController admincontroller;

    @Test
    public void contextLoads() throws Exception {
        assertThat(admincontroller).isNotNull();
    }
}
