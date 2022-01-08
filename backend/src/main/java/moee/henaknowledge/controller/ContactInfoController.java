package moee.henaknowledge.controller;

import moee.henaknowledge.dto.ContactDTO;
import moee.henaknowledge.module.Contact;
import moee.henaknowledge.service_interfaces.IContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ContactInfo")
@CrossOrigin("*")
public class ContactInfoController {

    @Autowired
    IContactService service;


    @PostMapping("/add")
    public ResponseEntity<Contact> addContactInfo(@RequestBody ContactDTO ciDTO) {
        if (ciDTO == null) {
            return ResponseEntity.notFound().build();
        } else {
            Contact modifiedContactInfo = new Contact(ciDTO.getStudentQuestion(),ciDTO.getTeacherResponse(),
                    ciDTO.getPending(), ciDTO.getWasUseful(), ciDTO.getWasNotUseful(), ciDTO.getStudentID(), ciDTO.getTeacherID());
            service.AddContact(modifiedContactInfo);
            return ResponseEntity.ok().body(modifiedContactInfo);
        }
    }

    @GetMapping()
    public ResponseEntity<List<Contact>> getAllContactInfo () {
       return ResponseEntity.ok().body(service.getAllContacts());
    }

    @GetMapping("/GetAllContacts")
    public ResponseEntity<List<Contact>> getAllContactInfoByStudentID (@RequestParam("studentID") int studentID) {
        return ResponseEntity.ok().body(service.getAllContactsByStudentID(studentID));
    }

    @GetMapping("/GetAllContactsByTeacherID")
    public ResponseEntity<List<Contact>> getAllContactInfoByTeacherID (@RequestParam("teacherID") int teacherID) {
        return ResponseEntity.ok().body(service.getAllContactsByTeacherID(teacherID));
    }


    @PutMapping()
    public ResponseEntity<Contact> updateContactInfo(@RequestBody ContactDTO ciDTO) {
        Contact c = null;
        var con = service.getContactByID(ciDTO.getID());
        if(con.isPresent()){
            c = con.get();
        }
        if (c == null) {
            return new ResponseEntity("Please provide a ContactInfo ID .", HttpStatus.NOT_FOUND);
        }
        else
        {
            service.UpdateContact(
                    ciDTO.getID(), ciDTO.getStudentQuestion(), ciDTO.getTeacherResponse(),
                    ciDTO.getPending(), ciDTO.getWasUseful(), ciDTO.getWasNotUseful(), ciDTO.getStudentID(),
                    ciDTO.getTeacherID()
            );
            return ResponseEntity.ok().build();
        }

    }

    @GetMapping("/getContactInfo")
    public ResponseEntity<Contact> getContactByID(@RequestParam("ID") int ContactID) {
        var s = service.getContactByID(ContactID);
        if (s.isPresent()) {
            return ResponseEntity.ok().body(s.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}