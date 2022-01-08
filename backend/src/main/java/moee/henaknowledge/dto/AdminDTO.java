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
public class AdminDTO extends Person {

    private String username;

    private String password;

    private String role;

    public AdminDTO(int personID, String firstName, String lastName, Date dateOfBirth, String email, String username, String password, String role) {
        super(personID, firstName, lastName, dateOfBirth, email);
        this.username = username;
        this.password = password;
        this.role = constant.ADMIN_ROLE;
    }

    public AdminDTO(String firstName, String lastName, Date dateOfBirth, String email, String username, String password, String role) {
        super(firstName, lastName, dateOfBirth, email);
        this.username = username;
        this.password = password;
        this.role = constant.ADMIN_ROLE;
    }

}
