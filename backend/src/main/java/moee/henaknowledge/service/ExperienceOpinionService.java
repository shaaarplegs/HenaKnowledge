package moee.henaknowledge.service;


import moee.henaknowledge.dal_interfaces.IExperienceOpinionDAL;
import moee.henaknowledge.module.ExperienceOpinion;
import moee.henaknowledge.service_interfaces.IExperienceOpinionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExperienceOpinionService implements IExperienceOpinionService {

    IExperienceOpinionDAL dal;

    @Autowired
    public ExperienceOpinionService(IExperienceOpinionDAL dal) {
        this.dal = dal;
    }


    @Override
    public Optional<ExperienceOpinion> getExperienceOpinionByExperienceOpinionID(int ID) {
        return dal.getExperienceOpinionByExperienceOpinionID(ID);
    }

    @Override
    public List<ExperienceOpinion> getAllExperienceOpinions() {
        return dal.getAllExperienceOpinions();
    }

    @Override
    public void AddExperienceOpinionOpinion(ExperienceOpinion eo) {
        dal.AddExperienceOpinionOpinion(eo);
    }

    @Override
    public void DeleteExperienceOpinionByID(int ExperienceOpinionID) {
        dal.DeleteExperienceOpinionByID(ExperienceOpinionID);
    }

    @Override
    public void like(int opinionID) {
        dal.like(opinionID);
    }

    @Override
    public void dislike(int opinionID) {
        dal.dislike(opinionID);
    }

    @Override
    public Optional<ExperienceOpinion>  getExperienceOpinionByPersonID(int PersonID) {
        return dal.getExperienceOpinionByPersonID(PersonID);
    }

    @Override
    public Optional<ExperienceOpinion>  getExperienceOpinionByPersonIDAndExperienceID(int PersonID, int ExperienceID) {
        return dal.getExperienceOpinionByPersonIDAndExperienceID(PersonID,ExperienceID);
    }
}
