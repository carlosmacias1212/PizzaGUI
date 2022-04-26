package management;

import list.JsonController;
import static list.JsonController.*;

public class Manager extends Staff{

    // manager overloaded constructor to call parent constructor (management.Staff) with super:
    public Manager(String firstName, String lastName, String password, String employeeID) {
        super(firstName, lastName, password, employeeID);
        super.setEmployeeType("Manager");
    }

    // determines whether if customer payment information was updated:
    public static boolean updateCustomerPaymentInfo(String phoneNumber){
        return true;
    }

    // creates/adds new staff into the system:
    public static boolean createNewStaff(String firstName, String lastName, String password, String employeeID) {

        Staff staff = new Staff(firstName, lastName, password, employeeID);

        staffList.add(staff);

        serializeStaff();

        return true;
    }

    // creates/adds new manager(s) into the system:
    public static boolean createNewManager(String firstName, String lastName, String password, String employeeID) {

        Staff manager = new Manager(firstName, lastName, password, employeeID);

        staffList.add(manager);

        serializeStaff();

        return true;
    }

    // removes staff from system:
    public static boolean removeWorker(String employeeID) {

        boolean temp = false;

        for (Staff s : staffList) {
            if (s.employeeID.equals(employeeID)) {
                staffList.remove(s);
                serializeStaff();
                return true;
            }
        }
        return temp;
    }
}