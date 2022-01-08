package moee.henaknowledge.module;


import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ID;
    @Lob
    private String studentQuestion;
    @Lob
    private String teacherResponse;
    private int pending;
    private int wasUseful;
    private int wasNotUseful;
    private int studentID;
    private int teacherID;

    public Contact(int ID, String studentQuestion, String teacherResponse, int pending, int wasUseful, int wasNotUseful, int studentID, int teacherID) {
        this.ID = ID;
        this.studentQuestion = studentQuestion;
        this.teacherResponse = teacherResponse;
        this.pending = pending;
        this.wasUseful = wasUseful;
        this.wasNotUseful = wasNotUseful;
        this.studentID = studentID;
        this.teacherID = teacherID;
    }

    public Contact(String studentQuestion, String teacherResponse, int pending, int wasUseful, int wasNotUseful, int studentID, int teacherID) {
        this.studentQuestion = studentQuestion;
        this.teacherResponse = teacherResponse;
        this.pending = pending;
        this.wasUseful = wasUseful;
        this.wasNotUseful = wasNotUseful;
        this.studentID = studentID;
        this.teacherID = teacherID;
    }
}
