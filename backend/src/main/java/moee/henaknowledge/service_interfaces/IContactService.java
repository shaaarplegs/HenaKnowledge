package moee.henaknowledge.service_interfaces;

import moee.henaknowledge.module.Contact;

import java.util.List;
import java.util.Optional;

public interface IContactService {
    Optional<Contact> getContactByID(int contactID);
    List<Contact> getAllContacts();
    void AddContact(Contact contact);
    void DeleteContactByID(int contactID);
    void UpdateContact(int ID, String studentQuestion, String teacherResponse,
                       int pending, int wasUseful, int wasNotUseful,
                       int studentID, int teacherID);
    List<Contact> getAllContactsByStudentID(int studentID);
    List<Contact> getAllContactsByTeacherID(int teacherID);
}
