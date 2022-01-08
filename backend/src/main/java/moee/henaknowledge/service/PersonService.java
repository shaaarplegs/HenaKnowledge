package moee.henaknowledge.service;

import moee.henaknowledge.dal_interfaces.IPersonDAL;
import moee.henaknowledge.service_interfaces.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService implements IPersonService {

    IPersonDAL dal;

    @Autowired
    public PersonService(IPersonDAL dal) {
        this.dal = dal;
    }

    @Override
    public String getFullNameByPersonID(int PersonID) {
        return dal.getFullNameByPersonID(PersonID);
    }

    @Override
    public int getPersonIDByCode(String Code) {
        return dal.getPersonIDByCode(Code);
    }
}
