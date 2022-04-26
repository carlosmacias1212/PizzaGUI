package management;

public class Manager extends Staff{

    // manager overloaded constructor to call parent constructor (management.Staff) with super:
    public Manager(String firstName, String lastName, String password, String employeeID) {
        super(firstName, lastName, password, employeeID);
        super.setEmployeeType("Manager");
    }

    // boolean method to indicate customer payment information updates:
    public static boolean updateCustomerPaymentInfo(String phoneNumber){
        return true;
    }
}