package list;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import customer_info.Customer;
import management.Manager;
import management.Order;
import management.Staff;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class JsonController <T>{

    // list instantiation for system:
    public static List<Order> orderList = new ArrayList<>();
    public static List<Customer> customerList = new ArrayList<>();
    public static List<Staff> staffList = new ArrayList<>();

    // JSON variable/controller creation:
    public static String orderJSON;
    public static String customerJSON;
    public static String staffJSON;

    public JsonController() {
    }

    // serializes an object into GSON:
    public void serializeAList(T object) throws IOException {
        String jsonToUpdate = jsonFileToUpdate(object);

        Gson gson = new Gson();

        List<T> updatedListToBeSer;
        updatedListToBeSer = deserializeAList(jsonToUpdate);

        updatedListToBeSer.add(object);

        String JSON = gson.toJson(updatedListToBeSer);

        try{
            FileWriter file = new FileWriter(jsonToUpdate);
            file.write(JSON);
            file.flush();

        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    // deserializes a string from GSON:
    public ArrayList<T> deserializeAList(String file) throws IOException {

        // converts json file to a string to be deserialized:
        String readInJson = convertJsonIntoString(file);

        Type genericListType = new TypeToken<ArrayList<T>>(){}.getType();

        // returns deserialized object:
        return new Gson().fromJson(readInJson, genericListType);
    }

    // deserializes a string (from order list) from GSON:
    public static ArrayList<Order> deserializeAnOrderList(String file) throws IOException {

        // converts JSON file to a string to be deserialized:
        String readInJson = convertJsonIntoString(file);

        Type orderListType = new TypeToken<ArrayList<Order>>(){}.getType();

        // returns the deserialized object:
        return new Gson().fromJson(readInJson, orderListType);
    }

    // deserializes Customer.json and updates the class list:
    public static ArrayList<Customer> deserializeACustomerList(String file) throws IOException {
        Gson gson = new Gson();

         // converts JSON file to a string to be deserialized:
         String readInJson = convertJsonIntoString(file);

         Type customerListType = new TypeToken<ArrayList<Customer>>(){}.getType();

        customerList = gson.fromJson(readInJson, customerListType);

        // returns deserialized object:
        return gson.fromJson(readInJson, customerListType);
    }

    public static ArrayList<Staff> deserializeAStaffList(String file) throws IOException {

        // convert JSON file to a string to be deserialized
         String readInJson = convertJsonIntoString(file);

         Type staffListType = new TypeToken<ArrayList<Staff>>(){}.getType();

        // returns deserialized object
        return new Gson().fromJson(readInJson, staffListType);
    }

    // converts JSON file into a string:
    public static String convertJsonIntoString(String file) throws IOException {
        File newFile = new File(file);
        if(newFile.createNewFile()) {
            System.out.println(newFile.getName() + " has been created.");

            try {
                FileWriter fileWriter = new FileWriter(file);
                fileWriter.write("[]");
                fileWriter.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        // returns the converted JSON file as a string:
        return new String(Files.readAllBytes(Paths.get(file)));
    }

    // returns respective JSON file based on input:
    public String jsonFileToUpdate(T object){
        if (object.getClass() == Order.class) {
            return "Order.json";
        }
        else if (object.getClass() == Customer.class){
            return "Customer.json";
        }
        else if (object.getClass() == Staff.class || object.getClass() == Manager.class) {
            return "Staff.json";
        }
        return "";
    }

    // serializes an order list into JSON:
    public static void serializeAnOrderList(Order order) throws IOException {
        Gson gson = new Gson();

        List<Order> updatedListToBeSerialized;
        updatedListToBeSerialized = deserializeAnOrderList("Order.json");

        updatedListToBeSerialized.add(order);

        String orderJSON = gson.toJson(updatedListToBeSerialized);

        try{
            FileWriter file = new FileWriter("Order.json");
            file.write(orderJSON);
            file.flush();

        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    // serializes a customer list into JSON (overloaded method):
    public static void serializeACustomerList(Customer customer) throws IOException {
        Gson gson = new Gson();

        List<Customer> updatedListToBeSer;
        updatedListToBeSer = deserializeACustomerList("Customer.json");

        updatedListToBeSer.add(customer);

        String custJSON = gson.toJson(updatedListToBeSer);

        try{
            FileWriter file = new FileWriter("Customer.json");
            file.write(custJSON);
            file.flush();

        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    // serializes a customer list into JSON:
    public static void serializeACustomerList() throws IOException {
        Gson gson = new Gson();

        String custJSON = gson.toJson(customerList);

        try{
            FileWriter file = new FileWriter("Customer.json");
            file.write(custJSON);
            file.flush();

        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    // serializes a staff list into JSON (overloaded method):
    public static void serializeAStaffList(Staff staff) throws IOException {
        Gson gson = new Gson();

        List<Staff> updatedListToBeSerialized;
        updatedListToBeSerialized = deserializeAStaffList("Staff.json");

        updatedListToBeSerialized.add(staff);

        String staffJSON = gson.toJson(updatedListToBeSerialized);

        try{
            FileWriter file = new FileWriter("Staff.json");
            file.write(staffJSON);
            file.flush();

        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    // serializes a staff list into JSON:
    public static void serializeAStaffList() throws IOException {
        Gson gson = new Gson();

        String staffJSON = gson.toJson(staffList);

        try{
            FileWriter file = new FileWriter("Staff.json");
            file.write(staffJSON);
            file.flush();

        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    // searches through staffList and returns the specified staff:
    // the search will return null if the specified user is not found:
    public static Staff searchAndReturn(String userName){
        for (Staff staff : staffList) {
            if(staff.employeeID.equals(userName))
            {
                return staff;
            }
        }
        return null;
    }
}