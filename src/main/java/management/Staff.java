package management;

import list.JsonController;
import java.io.IOException;
import static list.JsonController.*;

public class Staff {

    // staff variable creation:
    public String firstName;
    public String lastName;
    public String password;
    public String employeeType;
    public String employeeID;

    // constructor for staff:
    public Staff(){
    }

    // overloaded constructor for staff:
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

    // verifies whether if the presented employeeID and password are correct:
    public boolean loginVerification(String employeeID, String password){

        for (Staff s : staffList) {
            if(s.employeeID.equals(employeeID) && s.password.equals(password)) {
                return true;
            }
        }
        return false;
    }

    // checks for existing customer
    public static void startOrder(String phoneNumber){
    }

    // boolean method that determines if the current user logs out:
    public static boolean logout(){
        return true;
    }

    // transitions the current user to the previously visited screen:
    public static void goToPrevScreen(){
    }

    // updates customer information:
    public static boolean updateCustomerInfo(String phoneNumber){
        return true;
    }

    // creates new staff into system:
    public static boolean createNewStaff(String firstName, String lastName, String password, String employeeID) throws IOException {

        for (Staff s : JsonController.staffList) {
            if (s.employeeID.equals(employeeID)) {
                return false;
            }
        }

        Staff staff = new Staff(firstName, lastName, password, employeeID);

        staffList.add(staff);

        serializeAStaffList(staff);

        return true;
    }

    // creates new manager into system:
    public static boolean createNewManager(String firstName, String lastName, String password, String employeeID) throws IOException {

        for (Staff s : JsonController.staffList) {
            if (s.employeeID.equals(employeeID)) {
                return false;
            }
        }

        Staff staff = new Manager(firstName, lastName, password, employeeID);

        staffList.add(staff);

        serializeAStaffList(staff);

        return true;
    }

    // removes existing staff from system:
    public static boolean removeStaff(String employeeID) throws IOException {

        boolean temp = false;

        for (Staff s : JsonController.staffList) {
            if (s.employeeType.equals(employeeID)) {
                JsonController.customerList.remove(s);
                temp = true;
            }
        }

        JsonController.serializeAStaffList();

        return temp;
    }

    // removes existing manager(s) from system:
    public static boolean removeManager(String employeeID) throws IOException {

        boolean temp = false;

        for (Staff s : JsonController.staffList) {
            if (s.employeeType.equals(employeeID)) {
                JsonController.customerList.remove(s);
                temp = true;
            }
        }

        JsonController.serializeAStaffList();

        return temp;
    }
}