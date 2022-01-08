package moee.henaknowledge.dal_interfaces;


import moee.henaknowledge.module.Teacher;
import java.sql.Date;
import java.util.List;

public interface ITeacherDAL {
    Teacher getTeacherByUsername(String username);
    Teacher getTeacherByPersonID(int ID);
    List<Teacher> getAllTeachers();
    void AddTeacher(Teacher teacher);
    void DeleteTeacher(int ID);
    void setTeacherInfoById(int ID, String firstname, String lastname, Date DateOfBirth, String Email);
    void updatePoints(int ID, int points);
}
