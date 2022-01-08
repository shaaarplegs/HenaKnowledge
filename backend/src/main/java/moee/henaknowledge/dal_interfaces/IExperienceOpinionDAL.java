package moee.henaknowledge.dal_interfaces;


import moee.henaknowledge.module.ExperienceOpinion;

import java.util.List;
import java.util.Optional;

public interface IExperienceOpinionDAL {
    Optional<ExperienceOpinion> getExperienceOpinionByExperienceOpinionID(int ID);
    List<ExperienceOpinion> getAllExperienceOpinions();
    void AddExperienceOpinionOpinion(ExperienceOpinion eo);
    void DeleteExperienceOpinionByID(int ExperienceOpinionID);
    void like(int opinionID);
    void dislike(int opinionID);
    Optional<ExperienceOpinion>  getExperienceOpinionByPersonID(int PersonID);
    Optional<ExperienceOpinion>  getExperienceOpinionByPersonIDAndExperienceID(int PersonID, int ExperienceID);
}
