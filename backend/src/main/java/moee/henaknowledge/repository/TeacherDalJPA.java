package moee.henaknowledge.repository;

import moee.henaknowledge.dal_interfaces.ITeacherDAL;
import moee.henaknowledge.module.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public class TeacherDalJPA implements ITeacherDAL {

    @Autowired
    ITeacherRepository repos;

    public TeacherDalJPA(ITeacherRepository repos) {
        this.repos = repos;
    }

    @Override
    public Teacher getTeacherByUsername(String username) {
        return repos.getTeacherByUsername(username);
    }

    @Override
    public Teacher getTeacherByPersonID(int ID) {
        return repos.getTeacherByPersonID(ID);
    }

    @Override
    public List<Teacher> getAllTeachers() {
        return repos.findAll();
    }

    @Override
    public void AddTeacher(Teacher teacher) {
        repos.save(teacher);
    }

    @Override
    public void DeleteTeacher(int ID) {
        repos.delete(getTeacherByPersonID(ID));
    }

    @Override
    public void setTeacherInfoById(int ID, String firstname, String lastname, Date DateOfBirth, String Email) {
        repos.setTeacherInfoById(ID,firstname,lastname,DateOfBirth,Email);
    }

    @Override
    public void updatePoints(int ID, int points) {
        repos.updatePoints(ID,points);
    }
}
