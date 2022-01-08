package moee.henaknowledge.dal_interfaces;

public interface IPersonDAL {
    String getFullNameByPersonID(int PersonID);
    int getPersonIDByCode(String Code);
}
