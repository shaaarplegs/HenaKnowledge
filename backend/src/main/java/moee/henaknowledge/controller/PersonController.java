package moee.henaknowledge.controller;


import moee.henaknowledge.service_interfaces.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Person")
@CrossOrigin("*")
public class PersonController {

    @Autowired
    private IPersonService service;



    @GetMapping("/getFullName")
    public String getStudentPath(@RequestParam("PersonID") int PersonID) {
        return service.getFullNameByPersonID(PersonID);
    }

    @GetMapping("/getPersonID")
    public int getStudentPath(@RequestParam("Code") String Code) {
        return service.getPersonIDByCode(Code);
    }
}
