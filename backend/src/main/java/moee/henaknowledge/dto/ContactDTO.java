package moee.henaknowledge.dto;


import lombok.*;

import javax.persistence.Lob;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class ContactDTO {
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

    public ContactDTO(int ID, String studentQuestion, String teacherResponse, int pending, int wasUseful, int wasNotUseful, int studentID, int teacherID) {
        this.ID = ID;
        this.studentQuestion = studentQuestion;
        this.teacherResponse = teacherResponse;
        this.pending = pending;
        this.wasUseful = wasUseful;
        this.wasNotUseful = wasNotUseful;
        this.studentID = studentID;
        this.teacherID = teacherID;
    }

    public ContactDTO(String studentQuestion, String teacherResponse, int pending, int wasUseful, int wasNotUseful, int studentID, int teacherID) {
        this.studentQuestion = studentQuestion;
        this.teacherResponse = teacherResponse;
        this.pending = pending;
        this.wasUseful = wasUseful;
        this.wasNotUseful = wasNotUseful;
        this.studentID = studentID;
        this.teacherID = teacherID;
    }
}
