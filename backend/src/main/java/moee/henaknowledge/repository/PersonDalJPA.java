package moee.henaknowledge.repository;

import moee.henaknowledge.dal_interfaces.IPersonDAL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PersonDalJPA implements IPersonDAL {

    @Autowired
    IPersonRepository repos;

    @Autowired
    IStudentRepository studentRepository;

    @Autowired
    ITeacherRepository teacherRepository;

    @Override
    public String getFullNameByPersonID(int PersonID) {
        var a = repos.findById(PersonID);
        if(a.isPresent()){
            return a.get().getFirstName() + " " + a.get().getLastName();
        }
        return null;
    }

    @Override
    public int getPersonIDByCode(String Code) {
        for (var student:
             studentRepository.findAll()) {
            if(student.getCode().equals(Code)) {
                return student.getPersonID();
            }
        }
        for (var teacher:
                teacherRepository.findAll()) {
            if(teacher.getCode().equals(Code)) {
                return teacher.getPersonID();
            }
        }
        return 0;
    }
}
