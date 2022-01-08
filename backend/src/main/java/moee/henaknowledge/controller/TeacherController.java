package moee.henaknowledge.controller;


import moee.henaknowledge.dto.TeacherDTO;
import moee.henaknowledge.module.Email;
import moee.henaknowledge.module.Student;
import moee.henaknowledge.module.Teacher;
import moee.henaknowledge.service.SmtpMailSender;
import moee.henaknowledge.service_interfaces.ITeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Teacher")
@CrossOrigin("*")
public class TeacherController {


    @Autowired
    private ITeacherService service;


    @Autowired
    private SmtpMailSender smtpMailSender;

    @GetMapping("/testing/confirmed")
    public String returnTestingConfirmation() {
        return "This message is returned by the teacher controller.";
    }

    @GetMapping
    public ResponseEntity<List<Teacher>> getAllTeachers() {
        var Teachers = service.getAllTeachers();
        if (Teachers != null) {
            return ResponseEntity.ok().body(Teachers);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @GetMapping("{personID}")
    public ResponseEntity<Teacher> getTeacherPath(@PathVariable(value = "personID") int personID) {
        Teacher t = service.getTeacherByPersonID(personID);
        if (t != null) {
            return ResponseEntity.ok().body(t);
        } else {
            return ResponseEntity.notFound().build();
        }
    }



    @PostMapping("/add")
    public ResponseEntity<Teacher> createTeacher(@RequestBody TeacherDTO teacherDTO) {
        if (teacherDTO == null) {
            String entity = "Invalid teacher variables. ";
            return new ResponseEntity(entity, HttpStatus.CONFLICT);
        } else {


            //async function that sends credentials to the new signed up teacher
            Email e = new Email(teacherDTO.getEmail(), "Signing up credentials", "Your Henaknowledge credentials, username: " +
                    teacherDTO.getUsername() + ", password: " + teacherDTO.getPassword());
            smtpMailSender.sendTextEmail(e);
            String msg = "Teacher added successfully.";

            Teacher teacher = new Teacher(teacherDTO.getFirstName(),teacherDTO.getLastName(),teacherDTO.getDateOfBirth(),
                    teacherDTO.getEmail(),teacherDTO.getSpecialization(),teacherDTO.getCode(), teacherDTO.getUsername()
            ,teacherDTO.getPassword(), teacherDTO.getRole(), teacherDTO.getPoints());

            service.AddTeacher(teacher);

            return new ResponseEntity(msg, HttpStatus.CREATED);
        }
    }

    @DeleteMapping()
    public ResponseEntity deleteTeacher(@RequestParam int personID) {

        Teacher teacher = service.getTeacherByPersonID(personID);
        Email e = new Email(teacher.getEmail(), "Access removed", "Your Henaknowledge access has been removed. If you think that is a mistake, please contact Mohammedalharbi000@gmail.com");
        smtpMailSender.sendTextEmail(e);

        service.DeleteTeacher(personID);
        // Idempotent method. Always return the same response (even if the resource has already been deleted before).
        return ResponseEntity.ok().build();
    }


    @PutMapping()
    public ResponseEntity<Student> updateTeacher(@RequestParam("PersonID") int PersonID, @RequestParam("first_name") String first_name, @RequestParam("last_name") String last_name
            , @RequestParam("email") String email) {
        Teacher t = service.getTeacherByPersonID(PersonID);
        if (t == null) {
            return new ResponseEntity("Please provide a valid teacher ID.", HttpStatus.NOT_FOUND);
        }
        else
        {
            service.setTeacherInfoById(PersonID,first_name,last_name,t.getDateOfBirth(),email);
            return ResponseEntity.ok().build();
        }
    }



    @GetMapping("/getTeacher")
    public ResponseEntity<Teacher> getTeacherDetails(@RequestParam("username") String obtainedT) {
        Teacher t = service.getTeacherByUsername(obtainedT);
        if (t != null) {
            return ResponseEntity.ok().body(t);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
