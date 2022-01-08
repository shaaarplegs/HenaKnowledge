package moee.henaknowledge.service;

import moee.henaknowledge.dal_interfaces.IAdminDAL;
import moee.henaknowledge.module.Admin;
import moee.henaknowledge.service_interfaces.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class AdminService implements IAdminService {

    IAdminDAL dal;
    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Autowired
    public AdminService(IAdminDAL dal) {
        this.dal = dal;
    }

    @Override
    public Admin getAdminByUsername(String username) {
        return dal.getAdminByUsername(username);
    }

    @Override
    public Admin getAdminByPersonID(int ID) {
        return dal.getAdminByPersonID(ID);
    }

    @Override
    public List<Admin> getAllAdmins() {
        return dal.getAllAdmins();
    }

    @Override
    public void AddAdmin(Admin admin) {
        String encodedPassword = passwordEncoder.encode(admin.getPassword());
        admin.setPassword(encodedPassword);
        dal.AddAdmin(admin);
    }

    @Override
    public void DeleteAdmin(int ID) {
dal.DeleteAdmin(ID);
    }

    @Override
    public void setAdminInfoById(int ID, String firstname, String lastname, Date DateOfBirth, String Email) {
dal.setAdminInfoById(ID,firstname,lastname,DateOfBirth,Email);
    }

    @Override
    public int GetNumberOfSharedExperiences(int studentID) {
        return dal.GetNumberOfSharedExperiences(studentID);
    }

    @Override
    public int GetNumberOfAskedQuestions(int studentID) {
        return dal.GetNumberOfAskedQuestions(studentID);
    }

    @Override
    public int GetNumberOfSharedExperiencesByTeacherID(int teacherID) {
        return dal.GetNumberOfSharedExperiencesByTeacherID(teacherID);
    }

    @Override
    public int GetNumberOfAnsweredQuestionsByTeacherID(int teacherID) {
        return dal.GetNumberOfAnsweredQuestionsByTeacherID(teacherID);
    }

    @Override
    public void RedeemStudentPoints(int studentID) {
        dal.RedeemStudentPoints(studentID);
    }

    @Override
    public void RedeemTeacherPoints(int teacherID) {
        dal.RedeemTeacherPoints(teacherID);
    }
}
