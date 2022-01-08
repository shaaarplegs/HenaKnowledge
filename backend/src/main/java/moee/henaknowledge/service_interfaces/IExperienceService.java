package moee.henaknowledge.service_interfaces;


import moee.henaknowledge.module.Experience;

import java.util.List;
import java.util.Optional;

public interface IExperienceService {
    Optional<Experience> getExperienceByExperienceID(int ID);
    List<Experience> getAllExperiences();
    void AddExperience(Experience e);
    void DeleteExperienceByID(int experienceID);
    void SetExperienceById(int experienceID, String updatedTitle, String updatedDescription);
    void like(int experienceID, int personID);
    void dislike(int experienceID, int personID);
}
