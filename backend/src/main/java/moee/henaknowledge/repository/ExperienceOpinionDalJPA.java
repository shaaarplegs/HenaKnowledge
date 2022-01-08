package moee.henaknowledge.repository;

import moee.henaknowledge.dal_interfaces.IExperienceOpinionDAL;
import moee.henaknowledge.module.ExperienceOpinion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ExperienceOpinionDalJPA implements IExperienceOpinionDAL {

    @Autowired
    IExperienceOpinionRepository repos;


    @Override
    public Optional<ExperienceOpinion> getExperienceOpinionByExperienceOpinionID(int ID) {
        return repos.findById(ID);
    }

    @Override
    public List<ExperienceOpinion> getAllExperienceOpinions() {
        return repos.findAll();
    }

    @Override
    public void AddExperienceOpinionOpinion(ExperienceOpinion eo) {
        repos.save(eo);
    }

    @Override
    public void DeleteExperienceOpinionByID(int ExperienceOpinionID) {
        repos.deleteById(ExperienceOpinionID);
    }

    @Override
    public void like(int opinionID) {
        repos.updateOpinion(opinionID,1,0);
    }

    @Override
    public void dislike(int opinionID) {
        repos.updateOpinion(opinionID,0,1);
    }

    @Override
    public Optional<ExperienceOpinion>  getExperienceOpinionByPersonID(int PersonID) {
        return repos.findExperienceOpinionByPersonID(PersonID);
    }

    @Override
    public Optional<ExperienceOpinion>  getExperienceOpinionByPersonIDAndExperienceID(int PersonID, int ExperienceID) {
       var opinions = repos.findAll();
        for (var opinion:
             opinions) {
            if(opinion.getPersonID() == PersonID && opinion.getExperienceID() == ExperienceID) {
                return Optional.of(opinion);
            }
        }
        return Optional.empty();
    }

}
