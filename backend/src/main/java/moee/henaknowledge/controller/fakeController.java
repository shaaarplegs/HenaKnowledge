package moee.henaknowledge.controller;

import moee.henaknowledge.dto.AdminDTO;
import moee.henaknowledge.dto.ExperienceDTO;
import moee.henaknowledge.module.Admin;
import moee.henaknowledge.service_interfaces.IAdminService;
import moee.henaknowledge.util.constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDate;

@RestController
@RequestMapping("/Fake")
@CrossOrigin("*")
public class fakeController {

    @GetMapping()
    public @ResponseBody String returnTestingConfirmation() {
        return "This message is returned by the fake controller.";
    }

    @Autowired
    private IAdminService service;

    @GetMapping
    @RequestMapping("SetUpAdmin")
    public void SetUpAdmin() {

         Admin Mohammed = new Admin("Mohammed","Harbi", Date.valueOf(LocalDate.of(2000,12,24)),
                "Admin@gmail.com", "ADMIN", "ADMIN", constant.ADMIN_ROLE);
            service.AddAdmin(Mohammed);
    }

    @PostMapping
    @RequestMapping("printme")
    public String printme(@RequestBody ExperienceDTO e) {
            return "title is " + e.getTitle() + ". This is obtain from gradle task.";
    }
}
