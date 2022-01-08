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
@AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class Admin extends Person{

    @Column(name="username", unique=true)
    private String username;

    private String password;

    private String role;


    public Admin(int personID, String firstName, String lastName, Date dateOfBirth, String email, String username, String password, String role) {
        super(personID, firstName, lastName, dateOfBirth, email);
        this.username = username;
        this.password = password;
        this.role = constant.ADMIN_ROLE;
    }

    public Admin(String firstName, String lastName, Date dateOfBirth, String email, String username, String password, String role) {
        super(firstName, lastName, dateOfBirth, email);
        this.username = username;
        this.password = password;
        this.role = constant.ADMIN_ROLE;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
