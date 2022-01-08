package moee.henaknowledge.service;

import moee.henaknowledge.module.Admin;
import moee.henaknowledge.module.MyDetails;
import moee.henaknowledge.module.Student;
import moee.henaknowledge.module.Teacher;
import moee.henaknowledge.repository.IAdminRepository;
import moee.henaknowledge.repository.IStudentRepository;
import moee.henaknowledge.repository.ITeacherRepository;
import moee.henaknowledge.util.constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    IAdminRepository iAdminRepository;

    @Autowired
    IStudentRepository iStudentRepository;

    @Autowired
    ITeacherRepository iTeacherRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<Teacher> teacherOpt = iTeacherRepository.findByUsername(username);
        Optional<Student> studentOpt = iStudentRepository.findByUsername(username);
        Optional<Admin> adminOpt = iAdminRepository.findByUsername(username);

        UserDetails userD = null;

        if (teacherOpt.isPresent()) {
            userD =  teacherOpt.map(MyDetails::new).orElse(new MyDetails());
        }
         if(studentOpt.isPresent()) {
             userD =  studentOpt.map(MyDetails::new).orElse(new MyDetails());
        }
         if(adminOpt.isPresent()) {
             userD =  adminOpt.map(MyDetails::new).orElse(new MyDetails());
        }
       return userD;
    }

    public String getUserByUsername(String username) {
        if (iTeacherRepository.findByUsername(username).isPresent()) {
            return constant.TEACHER_ROLE;
        }
        if(iStudentRepository.findByUsername(username).isPresent()) {
            return constant.STUDENT_ROLE;
        }
        if(iAdminRepository.findByUsername(username).isPresent()) {
            return constant.ADMIN_ROLE;
        }
        return "not found";
    }
}
