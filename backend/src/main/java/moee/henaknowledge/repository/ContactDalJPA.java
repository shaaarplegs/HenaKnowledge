package moee.henaknowledge.repository;


import moee.henaknowledge.dal_interfaces.IContactDAL;
import moee.henaknowledge.module.Contact;
import moee.henaknowledge.module.Experience;
import moee.henaknowledge.util.points;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ContactDalJPA implements IContactDAL {

    @Autowired
    IContactRepository repos;

    @Autowired
    IStudentRepository studentRepos;

    @Autowired
    ITeacherRepository teacherRepos;

    @Override
    public Optional<Contact> getContactByID(int contactID) {
        if(repos.findById(contactID).isPresent()){
            return repos.findById(contactID);
        }
        return Optional.empty();
    }

    @Override
    public List<Contact> getAllContacts() {
        return repos.findAll();
    }

    @Override
    public void AddContact(Contact contact) {
        //while pending equals to 1 meaning that the student has asked but teached has not yet responded.
        if(contact.getPending() == 1) {
            increasePointPerQuestion(contact.getStudentID());
        }

        repos.save(contact);
    }

    @Override
    public void DeleteContactByID(int contactID) {
        repos.deleteById(contactID);
    }

    private void increasePointPerQuestion(int PersonID){

        for (var student:
                studentRepos.findAll()) {
            if(student.getPersonID() == PersonID){
                studentRepos.updatePoints(PersonID,student.getPoints()+ points.pointsPerQuestion);
            }
        }
    }

    private void increasePointPerAnswer(int PersonID){

        for (var teacher:
                teacherRepos.findAll()) {
            if(teacher.getPersonID() == PersonID){
                teacherRepos.updatePoints(PersonID,teacher.getPoints()+points.pointsPerAnswer);
            }
        }
    }


    @Override
    public void UpdateContact(int ID, String studentQuestion, String teacherResponse, int pending, int wasUseful, int wasNotUseful, int studentID, int teacherID) {

        repos.UpdateContact(ID,studentQuestion,teacherResponse,pending,wasUseful,wasNotUseful,studentID,teacherID);

        //while pending equals to 0 and was useful equals to 1 meanign teacher has answer, student has marked it as useful thus we add points.
        if(pending == 0 && wasUseful == 1) {
            increasePointPerAnswer(teacherID);
        }
    }

    @Override
    public List<Contact> getAllContactsByStudentID(int studentID) {
        var contacts = repos.findAll();
        List<Contact> filteredContacts = new ArrayList<>();

        for (var contact:
             contacts) {
            if(contact.getStudentID() == studentID) {
              filteredContacts.add(contact);
            }
        }
        return filteredContacts;
    }

    @Override
    public List<Contact> getAllContactsByTeacherID(int teacherID) {
        var contacts = repos.findAll();
        List<Contact> filteredContacts = new ArrayList<>();

        for (var contact:
                contacts) {
            if(contact.getTeacherID() == teacherID) {
                filteredContacts.add(contact);
            }
        }
        return filteredContacts;
    }
}
