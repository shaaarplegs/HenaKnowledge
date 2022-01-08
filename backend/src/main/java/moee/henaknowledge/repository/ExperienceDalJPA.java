package moee.henaknowledge.repository;

import moee.henaknowledge.dal_interfaces.IExperienceDAL;
import moee.henaknowledge.dal_interfaces.IExperienceOpinionDAL;
import moee.henaknowledge.module.Experience;
import moee.henaknowledge.module.ExperienceOpinion;
import moee.henaknowledge.util.points;
import org.hibernate.engine.transaction.jta.platform.internal.SynchronizationRegistryBasedSynchronizationStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ExperienceDalJPA implements IExperienceDAL {

    @Autowired
    IExperienceRepository repos;

    @Autowired
    IStudentRepository studentRepos;

    @Autowired
    ITeacherRepository teacherRepos;

    @Autowired
    IExperienceOpinionRepository Opinionrepos;

    @Override
    public Optional<Experience> getExperienceByExperienceID(int ID) {
        return repos.findByExperienceID(ID);
    }

    @Override
    public List<Experience> getAllExperiences() {
        return repos.findAll();
    }


    private void increasePointsPerExperience(Experience experience ){

        var publisher = experience.getPersonID();
        for (var student:
                studentRepos.findAll()) {
            if(student.getPersonID() == publisher){
                studentRepos.updatePoints(publisher,student.getPoints()+points.pointsPerExperience);
            }
        }
        for (var teacher:
                teacherRepos.findAll()) {
            if(teacher.getPersonID() == publisher){
                teacherRepos.updatePoints(publisher,teacher.getPoints()+points.pointsPerExperience);
            }
        }
    }

    private void increasePointsPerLike(Experience experience ){

        var publisher = experience.getPersonID();
        for (var student:
                studentRepos.findAll()) {
            if(student.getPersonID() == publisher){
                studentRepos.updatePoints(publisher,student.getPoints()+points.pointsPerLike);
            }
        }
        for (var teacher:
                teacherRepos.findAll()) {
            if(teacher.getPersonID() == publisher){
                teacherRepos.updatePoints(publisher,teacher.getPoints()+points.pointsPerLike);
            }
        }
    }

    private void decreasePointPerDislike(Experience experience ){

        var publisher = experience.getPersonID();
        for (var student:
                studentRepos.findAll()) {
            if(student.getPersonID() == publisher){
                studentRepos.updatePoints(publisher,student.getPoints()-points.pointsPerDislike);
            }
        }
        for (var teacher:
                teacherRepos.findAll()) {
            if(teacher.getPersonID() == publisher){
                teacherRepos.updatePoints(publisher,teacher.getPoints()-points.pointsPerDislike);
            }
        }
    }

    @Override
    public void AddExperience(Experience experience) {
         repos.save(experience);
         increasePointsPerExperience(experience);
    }

    @Override
    public void DeleteExperienceByID(int experienceID) {
        repos.deleteById(experienceID);
    }

    @Override
    public void SetExperienceById(int experienceID, String updatedTitle, String updatedDescription) {
        repos.updatedExperienceByExperienceID(experienceID,updatedTitle,updatedDescription);
    }

    private ExperienceOpinion getExperienceOpinionHelpingMethod(int experienceID, int personID) {
        //check if experience opinion exists given experienceID and Person ID
        var opinion = Opinionrepos.findExperienceOpinionByPersonIDAndExperienceID(
                personID,experienceID
        );
        if(opinion.isPresent()){
            return opinion.get();
        }
        return null;
    }



    @Override
    public void like(int experienceID, int personID) {

        var theExperience = repos.findById(experienceID);
        var theExperienceOpinion = getExperienceOpinionHelpingMethod(experienceID, personID);

        if(theExperienceOpinion == null){
            //the person would like to like or dislike for the first time in the specified experienceID
            Opinionrepos.save(new ExperienceOpinion(1,0,experienceID,personID));
            if(theExperience.isPresent()){
                repos.likeTheExperience(experienceID,theExperience.get().getLikes()+1);
                increasePointsPerLike(theExperience.get());
            }
        }
        else {
            if(theExperienceOpinion.getLikes() == 1) {
                // trying to like the experience again
            }
            else if ( theExperienceOpinion.getDislikes() == 1) {
                Opinionrepos.updateOpinion(theExperienceOpinion.getOpinionID(),1,0);
                if(theExperience.isPresent()) {
                    repos.dislikesTheExperience(experienceID, theExperience.get().getDislikes() - 1);
                    repos.likeTheExperience(experienceID, theExperience.get().getLikes() + 1);
                    increasePointsPerLike(theExperience.get());
                }
            }
        }
    }

    @Override
    public void dislike(int experienceID, int personID) {

        var theExperience = repos.findById(experienceID);
        var theExperienceOpinion = getExperienceOpinionHelpingMethod(experienceID, personID);

        if(theExperienceOpinion == null){
            //the person would like to like or dislike for the first time in the specified experienceID
            Opinionrepos.save(new ExperienceOpinion(0,1,experienceID,personID));
            if(theExperience.isPresent()) {
                repos.dislikesTheExperience(experienceID, theExperience.get().getDislikes()+1);
                decreasePointPerDislike(theExperience.get());
            }
        }
        else {
            if(theExperienceOpinion.getLikes() == 1) {
                Opinionrepos.updateOpinion(theExperienceOpinion.getOpinionID(),0,1);
                if(theExperience.isPresent()) {
                    repos.dislikesTheExperience(experienceID, theExperience.get().getDislikes() + 1);
                    repos.likeTheExperience(experienceID, theExperience.get().getLikes() - 1);
                    decreasePointPerDislike(theExperience.get());
                }
            }
            else if ( theExperienceOpinion.getDislikes() == 1) {
                // trying to dislike the experience again
            }
        }
    }
}
