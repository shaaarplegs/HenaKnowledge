package moee.henaknowledge.module;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@EqualsAndHashCode(callSuper=false)
@Entity
@Table(name="ExperienceOpinion")
public class ExperienceOpinion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int opinionID;
    @Column(name="likes")
    private int likes;
    @Column(name="dislikes")
    private int dislikes;
    @Column(name="experienceID")
    private int experienceID;
    @Column(name="personID")
    private int personID;

    public ExperienceOpinion(int opinionID, int likes, int dislikes, int experienceID, int personID) {
        this.opinionID = opinionID;
        this.likes = likes;
        this.dislikes = dislikes;
        this.experienceID = experienceID;
        this.personID = personID;
    }

    public ExperienceOpinion(int likes, int dislikes, int experienceID, int personID) {
        this.likes = likes;
        this.dislikes = dislikes;
        this.experienceID = experienceID;
        this.personID = personID;
    }

    public ExperienceOpinion() {
    }

    @Override
    public String toString() {
        return "ExperienceOpinion{" +
                "opinionID=" + opinionID +
                ", likes=" + likes +
                ", dislikes=" + dislikes +
                ", experienceID=" + experienceID +
                ", personID=" + personID +
                '}';
    }
}
