package moee.henaknowledge.module;

import lombok.*;
import moee.henaknowledge.util.constant;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.sql.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class Teacher extends Person{

    private String specialization;

    private String code;

    @Column(name="username", unique=true)
    private String username;

    private String password;

    private String role;

    private int points;


    public Teacher(int personID, String firstName, String lastName, Date dateOfBirth, String email, String specialization, String code, String username, String password, String role, int points) {
        super(personID, firstName, lastName, dateOfBirth, email);
        this.specialization = specialization;
        this.code = code;
        this.username = username;
        this.password = password;
        this.role = constant.TEACHER_ROLE;
        this.points = points;
    }

        public Teacher(String firstName, String lastName, Date dateOfBirth, String email, String specialization, String code, String username, String password, String role, int points) {
            super(firstName, lastName, dateOfBirth, email);
        this.specialization = specialization;
        this.code = code;
        this.username = username;
        this.password = password;
        this.role = constant.TEACHER_ROLE;
        this.points = points;
    }

    public Teacher(String specialization, String code, String username, String password, String role, int points) {
        this.specialization = specialization;
        this.code = code;
        this.username = username;
        this.password = password;
        this.role = constant.TEACHER_ROLE;
        this.points = points;
    }


    @Override
    public String toString() {
        return "Teacher{" +
                "specialization='" + specialization + '\'' +
                ", code='" + code + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                ", points=" + points +
                '}';
    }
}
