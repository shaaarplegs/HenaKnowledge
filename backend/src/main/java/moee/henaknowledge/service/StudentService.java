package moee.henaknowledge.service;

import moee.henaknowledge.dal_interfaces.IStudentDAL;
import moee.henaknowledge.module.Student;
import moee.henaknowledge.service_interfaces.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class StudentService implements IStudentService {

    IStudentDAL dal;
    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Autowired
    public StudentService(IStudentDAL dal) {
        this.dal = dal;
    }

    @Override
    public Student getStudentByUsername(String username) {
        return dal.getStudentByUsername(username);
    }

    @Override
    public Student getStudentByPersonID(int ID) {
        return dal.getStudentByPersonID(ID);
    }

    @Override
    public List<Student> getAllStudents() {
        return dal.getAllStudents();
    }

    @Override
    public void AddStudent(Student student) {
        String encodedPassword = passwordEncoder.encode(student.getPassword());
        student.setPassword(encodedPassword);
        dal.AddStudent(student);
    }

    @Override
    public void DeleteStudent(int ID) {
dal.DeleteStudent(ID);
    }

    @Override
    public void setStudentInfoById(int ID, String firstname, String lastname, Date DateOfBirth, String Email) {
dal.setStudentInfoById(ID,firstname,lastname,DateOfBirth,Email);
    }

    @Override
    public void updatePoints(int ID, int points) {
        dal.updatePoints(ID,points);
    }

}
