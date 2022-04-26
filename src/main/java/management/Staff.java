package management;

import list.JsonController;
import java.io.IOException;
import static list.JsonController.*;

public class Staff {
    // staff varibles/attributes:
    public String firstName;
    public String lastName;
    public String password;
    public String employeeType;
    public String employeeID;

    public Staff(){
    }

    // staff overloaded constructor:
    public Staff(String firstName, String lastName, String password, String employeeID) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.employeeID = employeeID;
        employeeType = "Staff";
    }

    // getters and setters for staff:
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getEmployeeType() {
        return employeeType;
    }
    public void setEmployeeType(String employeeType) {
        this.employeeType = employeeType;
    }
    public String getEmployeeID() {
        return employeeID;
    }
    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    // checks whether if the specified username and password are valid:
    public boolean loginVerification(String employeeID, String password){

        for (Staff s : staffList) {
            if(s.employeeID.equals(employeeID) && s.password.equals(password)) {
                return true;
            }
        }
        return false;
    }

    // checks for existing customer to start order:
    public static void startOrder(String phoneNumber){
        // for loop to go through customerList to verify existing customer
    }

    // returns true if the current user logs out:
    public static boolean logout(){
        return true;
    }

    // transitions the user to the previous screen:
    public static void goToPrevScreen(){
    }

    // returns true if customer information is updated:
    public static boolean updateCustomerInfo(String phoneNumber){
        return true;
    }

    // creates a new manager into the system:
    public static boolean createNewManager(String firstName, String lastName, String password, String employeeID) throws IOException {

        for (Staff s : JsonController.staffList) {
            if (s.employeeID.equals(employeeID)) {
                return false;
            }
        }

        Staff staff = new Manager(firstName, lastName, password, employeeID);

        staffList.add(staff);

        serializeStaff();

        return true;
    }

    // determines whether if there is a duplicate employeeID within the system:
    public static boolean isDuplicate(String employeeID) {
        for(Staff s : staffList) {
            if (s.employeeID.equals(employeeID)) {
                return true;
            }
        }
        return false;
    }
}