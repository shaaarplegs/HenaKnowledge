package moee.henaknowledge.dto;

import lombok.*;



import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class ExperienceDTO {

    private int experienceID;
    private String title;
    private String description;
    private int likes;
    private int dislikes;
    private int personID;
    private List<Integer> personsIDS;

    public ExperienceDTO(int experienceID, String title, String description, int likes, int dislikes,
                         int personID) {

        this.experienceID=experienceID;
        this.title=title;
        this.description=description;
        this.likes=likes;
        this.dislikes=dislikes;
        this.personID=personID;
    }
}
