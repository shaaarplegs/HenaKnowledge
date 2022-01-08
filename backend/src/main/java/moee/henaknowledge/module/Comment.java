package moee.henaknowledge.module;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@Table(name= "Comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int commentID;
    private int personID;
    @Lob
    private String commentBody;
    private int experienceID;

    public Comment(int commentID, int personID, String commentBody) {
        this.commentID = commentID;
        this.personID = personID;
        this.commentBody = commentBody;
    }

    public Comment(int commentID, int personID, String commentBody, int experienceID) {
        this.commentID = commentID;
        this.personID = personID;
        this.commentBody = commentBody;
        this.experienceID = experienceID;
    }

    public Comment() { }

    @Override
    public String toString() {
        return "Comment{" +
                "commentID=" + commentID +
                ", personID=" + personID +
                ", commentBody='" + commentBody + '\'' +
                ", experienceID=" + experienceID +
                '}';
    }
}
