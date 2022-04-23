package list;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import customer_info.Customer;
import management.Order;
import management.Staff;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class JsonController {
    public static List<Order> orderList = new ArrayList<>();
    public static List<Customer> customerList = new ArrayList<>();
    public static List<Staff> staffList = new ArrayList<>();


    public static void deserializeOrders() {

        try {
            // create Gson instance
            Gson gson = new Gson();

            // create a reader
            Reader reader = Files.newBufferedReader(Paths.get("Orders.json"));

            // convert JSON array to list of users
            orderList = new Gson().fromJson(reader, new TypeToken<List<Order>>() {}.getType());
            if(orderList == null) {
                orderList = new ArrayList<>();
            }
            // close reader
            reader.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public static void deserializeCustomers() {

        try {
            // create Gson instance
            Gson gson = new Gson();

            // create a reader
            Reader reader = Files.newBufferedReader(Paths.get("Customers.json"));

            // convert JSON array to list of users
            customerList = new Gson().fromJson(reader, new TypeToken<List<Customer>>() {}.getType());
            if (customerList == null) {
                customerList = new ArrayList<>();
            }

            // close reader
            reader.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public static void deserializeStaff() {


        try {
            // create Gson instance
            Gson gson = new Gson();

            // create a reader
            Reader reader = Files.newBufferedReader(Paths.get("Staff.json"));

            // convert JSON array to list of users
            staffList = new Gson().fromJson(reader, new TypeToken<List<Staff>>() {}.getType());
            if (staffList == null) {
                staffList = new ArrayList<>();
            }
            // close reader
            reader.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }


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

        return;


    }

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

        return;


    }

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

        return;



    }

    public static Staff searchAndReturn(String userName){
        for (Staff staff: staffList) {
            if(staff.employeeID.equals(userName))
            {
                return staff;
            }
        }
        return null;
    }


}
