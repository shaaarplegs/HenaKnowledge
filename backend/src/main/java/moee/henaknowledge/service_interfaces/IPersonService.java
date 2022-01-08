package moee.henaknowledge.service_interfaces;

public interface IPersonService {
    String getFullNameByPersonID(int PersonID);
    int getPersonIDByCode(String Code);
}
