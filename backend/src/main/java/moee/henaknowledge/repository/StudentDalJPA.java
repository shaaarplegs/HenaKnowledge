package moee.henaknowledge.repository;

import moee.henaknowledge.dal_interfaces.IStudentDAL;
import moee.henaknowledge.module.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public class StudentDalJPA implements IStudentDAL {

    @Autowired
    IStudentRepository repos;

    public StudentDalJPA(IStudentRepository repos) {
        this.repos = repos;
    }

    @Override
    public Student getStudentByUsername(String username) {
        return repos.getStudentByUsername(username);
    }

    @Override
    public Student getStudentByPersonID(int ID) {
        return repos.getStudentByPersonID(ID);
    }

    @Override
    public List<Student> getAllStudents() {
        return repos.findAll();
    }

    @Override
    public void AddStudent(Student student) {
        repos.save(student);
    }

    @Override
    public void DeleteStudent(int ID) {
        repos.delete(getStudentByPersonID(ID));
    }

    @Override
    public void setStudentInfoById(int ID, String firstname, String lastname, Date DateOfBirth, String Email) {
        repos.setStudentInfoById(ID,firstname,lastname,DateOfBirth,Email);
    }

    @Override
    public void updatePoints(int ID, int points) {
        repos.updatePoints(ID,points);
    }
}
