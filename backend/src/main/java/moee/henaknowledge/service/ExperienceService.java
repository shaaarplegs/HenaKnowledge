package moee.henaknowledge.service;

import moee.henaknowledge.dal_interfaces.IExperienceDAL;
import moee.henaknowledge.module.Experience;
import moee.henaknowledge.service_interfaces.IExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExperienceService implements IExperienceService {

    IExperienceDAL dal;

    @Autowired
    public ExperienceService(IExperienceDAL dal) {
        this.dal = dal;
    }

    @Override
    public Optional<Experience> getExperienceByExperienceID(int ID) {
        return dal.getExperienceByExperienceID(ID);
    }

    @Override
    public List<Experience> getAllExperiences() {
        return dal.getAllExperiences();
    }

    @Override
    public void AddExperience(Experience e) {
        dal.AddExperience(e);
    }

    @Override
    public void DeleteExperienceByID(int experienceID) {
        dal.DeleteExperienceByID(experienceID);
    }

    @Override
    public void SetExperienceById(int experienceID, String updatedTitle, String updatedDescription) {
        dal.SetExperienceById(experienceID,updatedTitle,updatedDescription);
    }

    @Override
    public void like(int experienceID, int personID) {
        dal.like(experienceID,personID);
    }

    @Override
    public void dislike(int experienceID, int personID) {
        dal.dislike(experienceID,personID);
    }
}
