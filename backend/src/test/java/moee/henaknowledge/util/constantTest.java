package moee.henaknowledge.util;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;
@ActiveProfiles("test")
@SpringBootTest
class constantTest {
    @Test
    public void TestAdminRoleConstant() {
        var actual = constant.ADMIN_ROLE;
        var expected = "Admin";
        assertEquals(expected, actual);
    }

    @Test
    public void TestStudentRoleConstant() {
        var actual = constant.STUDENT_ROLE;
        var expected = "Student";
        assertEquals(expected, actual);
    }

    @Test
    public void TestTeacherRoleConstant() {
        var actual = constant.TEACHER_ROLE;
        var expected = "Teacher";
        assertEquals(expected, actual);
    }
}