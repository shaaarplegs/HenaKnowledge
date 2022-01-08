package moee.henaknowledge.controller;

import moee.henaknowledge.dto.AdminDTO;
import moee.henaknowledge.module.Admin;
import moee.henaknowledge.service_interfaces.IAdminService;
import moee.henaknowledge.util.points;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/Admin")
@CrossOrigin("*")
public class AdminController {

    @Autowired
    private IAdminService service;

    @GetMapping("/testing/confirmed")
    public String returnTestingConfirmation() {
        return "This message is returned by the admin controller.";
    }



    @GetMapping("{personID}")

    public ResponseEntity<Admin> getStudentPath(@PathVariable(value = "personID") int personID) {
            var a = service.getAdminByPersonID(personID);
        if (a != null) {
            return ResponseEntity.ok().body(a);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @GetMapping
    public ResponseEntity<List<Admin>> getAllAdmins() {
        var admins = service.getAllAdmins();
        if (admins != null) {
            return ResponseEntity.ok().body(admins);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @PostMapping("/add")
    public String createAdmin(@RequestBody AdminDTO admin) {
        if (admin == null) {
            return "Invalid admin variables. ";
        } else {

            var modiferAdmin = new Admin(admin.getFirstName(), admin.getLastName(), admin.getDateOfBirth(), admin.getEmail()
            , admin.getUsername(), admin.getPassword(), admin.getRole());
            service.AddAdmin(modiferAdmin);
            return "Admin added successfully.";
        }
    }

    @DeleteMapping()
    public void deleteAdmin(@RequestParam int personID) {
        service.DeleteAdmin(personID);
    }


    @PutMapping()
    //http://localhost:8080/Admin?PersonID=5&first_name=sal2&last_name=harbi&date_of_birth=1990-07-24&email=saltest2@gmail.com
    public ResponseEntity<Admin> updateAdmin(@RequestParam("PersonID") int PersonID, @RequestParam("first_name") String first_name, @RequestParam("last_name") String last_name
            , @RequestParam("date_of_birth") Date date_of_birth, @RequestParam("email") String email) {
        var a = service.getAdminByPersonID(PersonID);
        if (a == null) {
            return ResponseEntity.notFound().build();
        }
        else
        {
            service.setAdminInfoById(PersonID,first_name,last_name,date_of_birth,email);
            return ResponseEntity.ok().body(a);
        }
    }


    @GetMapping("/getAdmin")
    public ResponseEntity<Admin> getAdminPath(@RequestParam("username") String obtainedA) {
        var s = service.getAdminByUsername(obtainedA);
        if (s != null) {
            return ResponseEntity.ok().body(s);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/getAmountOfSharedExperienceByStudent")
    public ResponseEntity<Integer> getAmountOfSharedExperienceByStudent(@RequestParam("studentID") int studentID) {
        return ResponseEntity.ok().body(service.GetNumberOfSharedExperiences(studentID));
    }

    @GetMapping("/getAmountOfAskedQuestionsByStudent")
    public ResponseEntity<Integer> getAmountOfAskedQuestionsByStudent(@RequestParam("studentID") int studentID) {
        return ResponseEntity.ok().body(service.GetNumberOfAskedQuestions(studentID));
    }

    @GetMapping("/getAmountOfSharedExperienceByTeacher")
    public ResponseEntity<Integer> getAmountOfSharedExperienceByTeacher(@RequestParam("teacherID") int teacherID) {
        return ResponseEntity.ok().body(service.GetNumberOfSharedExperiencesByTeacherID(teacherID));
    }

    @GetMapping("/getAmountOfAskedQuestionsByTeacher")
    public ResponseEntity<Integer> getAmountOfAskedQuestionsByTeacher(@RequestParam("teacherID") int teacherID) {
        return ResponseEntity.ok().body(service.GetNumberOfAnsweredQuestionsByTeacherID(teacherID));
    }

    @GetMapping("/ChangePointsPerExperience")
    public void ChangePointsPerExperience(@RequestParam("pointsPerExperience") int newValue) {
       points.pointsPerExperience = newValue;
    }

    @GetMapping("/ChangePointsPerLike")
    public void ChangePointsPerLike(@RequestParam("pointsPerLike") int newValue) {
        points.pointsPerLike = newValue;
    }

    @GetMapping("/ChangePointsPerDislike")
    public void ChangePointsPerDislike(@RequestParam("pointsPerDislike") int newValue) {
        points.pointsPerDislike = newValue;
    }

    @GetMapping("/ChangePointsPerQuestion")
    public void ChangePointsPerQuestion(@RequestParam("pointsPerQuestion") int newValue) {
        points.pointsPerQuestion = newValue;
    }
    @GetMapping("/ChangePointsPerAnswer")
    public void ChangePointsPerAnswer(@RequestParam("pointsPerAnswer") int newValue) {
        points.pointsPerAnswer = newValue;
    }


    //
    @GetMapping("/GetPointsPerExperience")
    public int GetPointsPerExperience() {
        return points.pointsPerExperience;
    }

    @GetMapping("/GetPointsPerLike")
    public int GetPointsPerLike() {
        return points.pointsPerLike;
    }

    @GetMapping("/GetPointsPerDislike")
    public int GetPointsPerDislike() {
        return points.pointsPerDislike;
    }

    @GetMapping("/GetPointsPerQuestion")
    public int GetPointsPerQuestion() {
        return  points.pointsPerQuestion;
    }
    @GetMapping("/GetPointsPerAnswer")
    public int GetPointsPerAnswer() {
        return points.pointsPerAnswer;
    }


    @GetMapping("/ReedemStudentPoints")
    public void RedeemStudentPoints(@RequestParam("studentID") int studentID) {
        service.RedeemStudentPoints(studentID);
    }

    @GetMapping("/ReedemTeacherPoints")
    public void RedeemTeacherPoints(@RequestParam("teacherID") int teacherID) {
        service.RedeemTeacherPoints(teacherID);
    }

}

