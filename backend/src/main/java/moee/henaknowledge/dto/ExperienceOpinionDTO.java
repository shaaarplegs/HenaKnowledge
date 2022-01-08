package moee.henaknowledge.dto;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class ExperienceOpinionDTO {
    private int opinionID;
    private int experienceID;
    private int personID;

    public ExperienceOpinionDTO(int opinionID, int experienceID, int personID) {
        this.opinionID = opinionID;
        this.experienceID = experienceID;
        this.personID = personID;
    }

    public ExperienceOpinionDTO(int experienceID, int personID) {
        this.experienceID = experienceID;
        this.personID = personID;
    }

    @Override
    public String toString() {
        return "ExperienceOpinionDTO{" +
                "opinionID=" + opinionID +
                ", experienceID=" + experienceID +
                ", personID=" + personID +
                '}';
    }
}
