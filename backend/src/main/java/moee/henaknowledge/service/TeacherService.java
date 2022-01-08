package moee.henaknowledge.service;

import moee.henaknowledge.dal_interfaces.ITeacherDAL;
import moee.henaknowledge.module.Teacher;
import moee.henaknowledge.service_interfaces.ITeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class TeacherService implements ITeacherService {

    ITeacherDAL dal;
    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Autowired
    public TeacherService(ITeacherDAL dal) {
        this.dal = dal;
    }

    @Override
    public Teacher getTeacherByUsername(String username) {
        return dal.getTeacherByUsername(username);
    }

    @Override
    public Teacher getTeacherByPersonID(int ID) {
        return dal.getTeacherByPersonID(ID);
    }

    @Override
    public List<Teacher> getAllTeachers() {
        return dal.getAllTeachers();
    }

    @Override
    public void AddTeacher(Teacher teacher) {
        String encodedPassword = passwordEncoder.encode(teacher.getPassword());
        teacher.setPassword(encodedPassword);
        dal.AddTeacher(teacher);
    }

    @Override
    public void DeleteTeacher(int ID) {
        dal.DeleteTeacher(ID);
    }

    @Override
    public void setTeacherInfoById(int ID, String firstname, String lastname, Date DateOfBirth, String Email) {
        dal.setTeacherInfoById(ID,firstname,lastname,DateOfBirth,Email);
    }

    @Override
    public void updatePoints(int ID, int points) {
        dal.updatePoints(ID,points);
    }
}
