package management;

import list.JsonController;

import static list.JsonController.*;

public class Manager extends Staff{

    // constructor to call parent constructor (management.Staff) with super
    public Manager(String firstName, String lastName, String password, String employeeID) {
//
        super(firstName, lastName, password, employeeID);
        super.setEmployeeType("Manager");
    }

    public static boolean updateCustomerPaymentInfo(String phoneNumber){

        return true;
    }

    public static boolean createNewStaff(String firstName, String lastName, String password, String employeeID) {

        for (Staff s : JsonController.staffList) {
            if (s.employeeID.equals(employeeID)) {
                return false;
            }
        }

        Staff staff = new Staff(firstName, lastName, password, employeeID);

        staffList.add(staff);

        serializeStaff();

        return true;
    }

    public static boolean createNewManager(String firstName, String lastName, String password, String employeeID) {

        for (Staff s : JsonController.staffList) {
            if (s.employeeID.equals(employeeID)) {
                return false;
            }
        }

        Staff manager = new Manager(firstName, lastName, password, employeeID);

        staffList.add(manager);

        serializeStaff();

        return true;
    }

    public static boolean removeWorker(String employeeID) {
//        Use list.JsonController.staffList to make updates to the class list to be used in the json file

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