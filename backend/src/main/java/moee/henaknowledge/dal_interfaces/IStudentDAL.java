package moee.henaknowledge.dal_interfaces;

import moee.henaknowledge.module.Student;

import java.sql.Date;
import java.util.List;

public interface IStudentDAL {
    Student getStudentByUsername(String username);
    Student getStudentByPersonID(int ID);
    List<Student> getAllStudents();
    void AddStudent(Student student);
    void DeleteStudent(int ID);
    void setStudentInfoById(int ID, String firstname, String lastname, Date DateOfBirth, String Email);
    void updatePoints(int ID, int points);
}
