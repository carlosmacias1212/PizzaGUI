package customer_info;

import list.JsonController;
import java.io.IOException;
import static list.JsonController.customerList;
import static list.JsonController.serializeCustomers;

public class Customer {

    // customer variable/attributes:
    String firstName;
    String lastName;
    private customerAddress address;
    private String phoneNumber;
    private customerCreditCard creditCard;

    public Customer(){
    }
    // customer overloaded constructor
    public Customer(String firstName, String lastName, customerAddress address, String phoneNumber, customerCreditCard creditCard) {
        this.firstName = firstName;
        this.address = address;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.creditCard = creditCard;
    }

    // getters and setters for customer:
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

    public customerAddress getAddress() {
        return address;
    }

    public void setAddress(customerAddress address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public customerCreditCard getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(customerCreditCard creditCard) {
        this.creditCard = creditCard;
    }

    // creates a new customer within the system:
    public static Customer createNewCustomer(String firstName, String lastName, customerAddress address, String phoneNumber, customerCreditCard creditCard) {

        Customer customer = new Customer(firstName, lastName, address, phoneNumber, creditCard);

        return customer;
    }

    // boolean method that determines if there is a duplicate customer phone number within the system:
    public static boolean isDuplicate(String phoneNumber) {

        for (Customer c : customerList) {
            if (c.phoneNumber.equals(phoneNumber)) {
                return true;
            }
        }
        return false;
    }

    // checks to see if a customer phone number exists within the system:
    public static boolean doesExist(String phoneNumber) {

        for (Customer c : customerList) {
            if (c.phoneNumber.equals(phoneNumber)){
                return true;
            }
        }
        return false;
    }

    // removes a customer from the system:
    public static boolean removeCustomer(String phoneNumber) {
        boolean temp = false;

        for (Customer c : customerList) {
            if (c.phoneNumber.equals(phoneNumber)) {
                customerList.remove(c);
                serializeCustomers();
                return true;
            }
        }
        return temp;
    }

    // searches for and returns a customer based on phone number input:
    public static Customer getCustomer(String phoneNumber) {
        for (Customer c : customerList){
            if (c.getPhoneNumber().equals(phoneNumber)){
                return c;
            }
        }
        return null;
    }
}