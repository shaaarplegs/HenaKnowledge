package moee.henaknowledge.dal_interfaces;

import moee.henaknowledge.module.Admin;

import java.sql.Date;
import java.util.List;

public interface IAdminDAL {
    Admin getAdminByUsername(String username);
    Admin getAdminByPersonID(int ID);
    List<Admin> getAllAdmins();
    void AddAdmin(Admin admin);
    void DeleteAdmin(int ID);
    void setAdminInfoById(int ID, String firstname, String lastname, Date DateOfBirth, String Email);
    int GetNumberOfSharedExperiences(int studentID);
    int GetNumberOfAskedQuestions(int studentID);

    int GetNumberOfSharedExperiencesByTeacherID(int teacherID);
    int GetNumberOfAnsweredQuestionsByTeacherID(int teacherID);

    void RedeemStudentPoints(int studentID);
    void RedeemTeacherPoints(int teacherID);
}
