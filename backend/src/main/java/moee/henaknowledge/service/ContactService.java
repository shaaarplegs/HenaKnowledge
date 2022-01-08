package moee.henaknowledge.service;

import moee.henaknowledge.dal_interfaces.IContactDAL;
import moee.henaknowledge.module.Contact;
import moee.henaknowledge.service_interfaces.IContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactService implements IContactService {

    IContactDAL dal;

    @Autowired
    public ContactService(IContactDAL dal) {
        this.dal = dal;
    }

    @Override
    public Optional<Contact> getContactByID(int contactID) {
        return dal.getContactByID(contactID);
    }

    @Override
    public List<Contact> getAllContacts() {
        return dal.getAllContacts();
    }

    @Override
    public void AddContact(Contact contact) {
        dal.AddContact(contact);
    }

    @Override
    public void DeleteContactByID(int contactID) {
        dal.DeleteContactByID(contactID);
    }

    @Override
    public void UpdateContact(int ID, String studentQuestion, String teacherResponse, int pending, int wasUseful, int wasNotUseful, int studentID, int teacherID) {
        dal.UpdateContact(ID,studentQuestion,teacherResponse,pending,wasUseful,wasNotUseful,studentID,teacherID);
    }

    @Override
    public List<Contact> getAllContactsByStudentID(int studentID) {
        return dal.getAllContactsByStudentID(studentID);
    }

    @Override
    public List<Contact> getAllContactsByTeacherID(int teacherID) {
        return dal.getAllContactsByTeacherID(teacherID);
    }
}
