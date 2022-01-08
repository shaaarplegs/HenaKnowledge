package moee.henaknowledge.repository;

import moee.henaknowledge.dal_interfaces.IAdminDAL;
import moee.henaknowledge.module.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public  class AdminDalJPA implements IAdminDAL {

    @Autowired
    IAdminRepository repos;

    @Autowired
    IExperienceRepository experienceRepos;

    @Autowired
    IContactRepository contactRepository;

    @Autowired
    IStudentRepository studentRepository;

    @Autowired
    ITeacherRepository teacherRepository;

    public AdminDalJPA(IAdminRepository repos) {
        this.repos = repos;
    }

    @Override
    public Admin getAdminByUsername(String username) {
        return repos.getAdminByUsername(username);
    }

    @Override
    public Admin getAdminByPersonID(int ID) {
        return repos.getAdminByPersonID(ID);
    }

    @Override
    public List<Admin> getAllAdmins() {
        return repos.findAll();
    }

    @Override
    public void AddAdmin(Admin admin) {
        repos.save(admin);
    }

    @Override
    public void DeleteAdmin(int ID) {
        repos.delete(getAdminByPersonID(ID));
    }

    @Override
    public void setAdminInfoById(int ID, String firstname, String lastname, Date DateOfBirth, String Email) {
            repos.setAdminInfoById(ID,firstname,lastname,DateOfBirth,Email);
    }

    @Override
    public int GetNumberOfSharedExperiences(int studentID) {
        int numberOfSharedExperiences = 0;
        var sharedExperiences = experienceRepos.findAll();
        for (var experience:
             sharedExperiences) {
            if(experience.getPersonID() == studentID) {
                numberOfSharedExperiences++;
            }
        }
        return numberOfSharedExperiences;
    }

    @Override
    public int GetNumberOfAskedQuestions(int studentID) {
        int numberOfAskedQuestions = 0;
        var contacts = contactRepository.findAll();
        for (var contact:
                contacts) {
            if(contact.getStudentID() == studentID) {
                numberOfAskedQuestions++;
            }
        }
        return numberOfAskedQuestions;
    }

    @Override
    public int GetNumberOfSharedExperiencesByTeacherID(int teacherID) {
        int numberOfSharedExperiences = 0;
        var sharedExperiences = experienceRepos.findAll();
        for (var experience:
                sharedExperiences) {
            if(experience.getPersonID() == teacherID) {
                numberOfSharedExperiences++;
            }
        }
        return numberOfSharedExperiences;
    }

    @Override
    public int GetNumberOfAnsweredQuestionsByTeacherID(int teacherID) {
        int numberOfAnsweredQuestions = 0;
        var contacts = contactRepository.findAll();
        for (var contact:
                contacts) {
            if(contact.getTeacherID() == teacherID) {
                numberOfAnsweredQuestions++;
            }
        }
        return numberOfAnsweredQuestions;
    }

    @Override
    public void RedeemStudentPoints(int studentID) {
        studentRepository.updatePoints(studentID, 0);
    }

    @Override
    public void RedeemTeacherPoints(int teacherID) {
        teacherRepository.updatePoints(teacherID, 0);
    }
}
