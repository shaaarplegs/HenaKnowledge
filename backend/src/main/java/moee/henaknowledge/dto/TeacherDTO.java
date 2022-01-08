package moee.henaknowledge.dto;


import lombok.*;
import moee.henaknowledge.module.Person;
import moee.henaknowledge.util.constant;
import java.sql.Date;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
@ToString
public class TeacherDTO extends Person {

    private String specialization;

    private String code;

    private String username;

    private String password;

    private String role;

    private int points;

    public TeacherDTO(int personID, String firstName, String lastName, Date dateOfBirth, String email, String specialization, String code, String username, String password, String role, int points) {
        super(personID, firstName, lastName, dateOfBirth, email);
        this.specialization = specialization;
        this.code = code;
        this.username = username;
        this.password = password;
        this.role = constant.TEACHER_ROLE;
        this.points = points;
    }

    public TeacherDTO(String firstName, String lastName, Date dateOfBirth, String email, String specialization, String code, String username, String password, String role, int points) {
        super(firstName, lastName, dateOfBirth, email);
        this.specialization = specialization;
        this.code = code;
        this.username = username;
        this.password = password;
        this.role = constant.TEACHER_ROLE;
        this.points = points;
    }
}
