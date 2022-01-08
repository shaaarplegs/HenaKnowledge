package moee.henaknowledge.dto;

import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class CommentDTO {

    private int commentID;
    private int personID;
    private String commentBody;
    private int experienceID;

    public CommentDTO(int commentID, int personID, String commentBody) {
        this.commentID = commentID;
        this.personID = personID;
        this.commentBody = commentBody;
    }

    public CommentDTO(int commentID, int personID, String commentBody, int experienceID) {
        this.commentID = commentID;
        this.personID = personID;
        this.commentBody = commentBody;
        this.experienceID = experienceID;
    }
}
