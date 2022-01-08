package moee.henaknowledge.module;


import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Email {
    private String to;
    private String subject;
    private String text;
}
