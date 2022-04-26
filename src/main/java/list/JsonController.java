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
import java.io.Reader;

public class JsonController <T>{
    // list instantiation for orders, customers, staff:
    public static List<Order> orderList = new ArrayList<>();
    public static List<Customer> customerList = new ArrayList<>();
    public static List<Staff> staffList = new ArrayList<>();

    // JSON controller variables/attributes:
    public static String orderJSON;
    public static String customerJSON;
    public static String staffJSON;

    public JsonController() {
    }

    // searches and returns a staff based on userName:
    public static Staff searchAndReturn(String userName){
        for (Staff staff: staffList) {
            if(staff.employeeID.equals(userName))
            {
                return staff;
            }
        }
        return null;
    }

    // deserializes customer order(s):
    public static void deserializeOrders() throws IOException {

        String file = "Orders.json";

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

        try {
            // creates Gson instance:
            Gson gson = new Gson();

            // creates a reader:
            Reader reader = Files.newBufferedReader(Paths.get("Orders.json"));

            // converts JSON array to list of users:
            orderList = new Gson().fromJson(reader, new TypeToken<List<Order>>() {}.getType());
            if(orderList == null) {
                orderList = new ArrayList<>();
            }
            // closes reader:
            reader.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // deserializes customers within the system:
    public static void deserializeCustomers() throws IOException {

        String file = "Customers.json";

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

        try {
            // creates Gson instance:
            Gson gson = new Gson();

            // creates a reader:
            Reader reader = Files.newBufferedReader(Paths.get("Customers.json"));

            // converts JSON array to list of users:
            customerList = new Gson().fromJson(reader, new TypeToken<List<Customer>>() {}.getType());
            if (customerList == null) {
                customerList = new ArrayList<>();
            }

            // closes reader:
            reader.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // deserializes staff within the system:
    public static void deserializeStaff() throws IOException {

        String file = "Staff.json";

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

        try {
            // creates Gson instance:
            Gson gson = new Gson();

            // creates a reader:
            Reader reader = Files.newBufferedReader(Paths.get("Staff.json"));

            // converts JSON array to list of users:
            staffList = new Gson().fromJson(reader, new TypeToken<List<Staff>>() {}.getType());

            if (staffList == null) {
                staffList = new ArrayList<>();
            }
            // closes reader:
            reader.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // serializes customers within the system:
    public static void serializeCustomers(){

        Gson gson = new Gson();

        String customerToJson = gson.toJson(customerList);

        try{
            FileWriter file = new FileWriter("Customers.json");
            file.write(customerToJson);
            file.close();

        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    // serializes staff within the system:
    public static void serializeStaff(){

        Gson gson = new Gson();

        String customerToJson = gson.toJson(staffList);

        try{
            FileWriter file = new FileWriter("Staff.json");
            file.write(customerToJson);
            file.close();

        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    // serializes customer orders:
    public static void serializeOrders(){

        Gson gson = new Gson();

        String customerToJson = gson.toJson(orderList);

        try{
            FileWriter file = new FileWriter("Orders.json");
            file.write(customerToJson);
            file.close();

        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}