package moee.henaknowledge.controller;


import moee.henaknowledge.dto.StudentDTO;
import moee.henaknowledge.module.Admin;
import moee.henaknowledge.module.Email;
import moee.henaknowledge.module.Student;
import moee.henaknowledge.service.SmtpMailSender;
import moee.henaknowledge.service_interfaces.IAdminService;
import moee.henaknowledge.service_interfaces.IStudentService;
import moee.henaknowledge.util.constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/Student")
@CrossOrigin("*")
public class StudentController {

    @Autowired
    private IStudentService service;

    @Autowired
    private SmtpMailSender smtpMailSender;


    @GetMapping("/testing/confirmed")
    public String returnTestingConfirmation() {
        return "This message is returned by the student controller.";
    }

    @GetMapping("{personID}")
    public ResponseEntity<Student> getStudentPath(@PathVariable(value = "personID") int personID) {
        var s = service.getStudentByPersonID(personID);
        if (s != null) {
            return ResponseEntity.ok().body(s);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @GetMapping("/getStudent")
    public ResponseEntity<Student> getStudentPath(@RequestParam("username") String obtainedS) {
        var s = service.getStudentByUsername(obtainedS);
        if (s != null) {
            return ResponseEntity.ok().body(s);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        var students = service.getAllStudents();
        if (students != null) {
            return ResponseEntity.ok().body(students);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @PostMapping("/add")
    public ResponseEntity<Student> createStudent(@RequestBody StudentDTO student) {
        if (student == null) {
            return ResponseEntity.notFound().build();
        } else {


            //async function that sends credentials to the new signed up student
            var e = new Email(student.getEmail(), "Signing up credentials", "Your Henaknowledge credentials, username: " +
                    student.getUsername() + ", password: " + student.getPassword());
            smtpMailSender.sendTextEmail(e);
            String msg = "Student added successfully.";

            Student modifedStudent = new Student(student.getFirstName(), student.getLastName(),student.getDateOfBirth(),student.getEmail(),
                    student.getSpecialization(),student.getCode(), student.getUsername(), student.getPassword(), student.getRole(), student.getPoints());
            service.AddStudent(modifedStudent);
            return ResponseEntity.ok().body(modifedStudent);
        }
    }

    @DeleteMapping()
    public void deleteStudent(@RequestParam int personID) {
        Student student = service.getStudentByPersonID(personID);
        Email e = new Email(student.getEmail(), "Fired", "Your Henaknowledge access has been removed. If you think that is a mistake, please contact Mohammedalharbi000@gmail.com");
        smtpMailSender.sendTextEmail(e);
        service.DeleteStudent(personID);
    }


    @PutMapping()
    public ResponseEntity<Student> updateStudent(@RequestParam("PersonID") int PersonID, @RequestParam("first_name") String first_name, @RequestParam("last_name") String last_name
            , @RequestParam("email") String email) {
        Student s = service.getStudentByPersonID(PersonID);
        if (s == null) {
            return new ResponseEntity("Please provide a valid student ID.", HttpStatus.NOT_FOUND);
        }
        else
        {
            service.setStudentInfoById(PersonID,first_name,last_name,s.getDateOfBirth(),email);
            return ResponseEntity.ok().build();
        }

    }

}
