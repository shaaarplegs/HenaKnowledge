package moee.henaknowledge.module;


import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;


@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
@Entity
public class Experience {

    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    @GeneratedValue(
            strategy= GenerationType.AUTO,
            generator="native"
    )
    @GenericGenerator(
            name = "native",
            strategy = "native"
    )
    @Column(name="experience_id")
    private int experienceID;
    @Column(name="title")
    private String title;
    @Column(name="description")
    @Lob
    private String description;
    @Column(name="likes")
    private int likes;
    @Column(name="dislikes")
    private int dislikes;
    @Column(name="personID")
    private int personID;



    public Experience(int experienceID, String title, String description, int likes, int dislikes, int personID) {
        this.experienceID = experienceID;
        this.title = title;
        this.description = description;
        this.likes = likes;
        this.dislikes = dislikes;
        this.personID = personID;
    }

    public Experience(String title, String description, int likes, int dislikes, int personID) {
        this.title = title;
        this.description = description;
        this.likes = likes;
        this.dislikes = dislikes;
        this.personID = personID;
    }



    public void Experience() {

    }

    @Override
    public String toString() {
        return "Experience{" +
                "experienceID=" + experienceID +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", likes=" + likes +
                ", dislikes=" + dislikes +
                ", personID=" + personID +
                '}';
    }
}
