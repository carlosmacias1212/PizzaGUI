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
    public static List<Order> orderList = new ArrayList<>();
    public static List<Customer> customerList = new ArrayList<>();
    public static List<Staff> staffList = new ArrayList<>();
    public static String orderJSON;
    public static String customerJSON;
    public static String staffJSON;

    public JsonController() {

    }

//    public static void serializeAnOrderList(Order order) throws IOException {
//        Gson gson = new Gson();
//
//
//        List<Order> updatedListToBeSerialized;
//        updatedListToBeSerialized = deserializeAnOrderList();
//
//        updatedListToBeSerialized.add(order);
//
//        String orderJSON = gson.toJson(updatedListToBeSerialized);
//
//        try{
//            FileWriter file = new FileWriter("Order.json");
//            file.write(orderJSON);
//            file.flush();
//
//        }catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static void serializeAnOrderList() throws IOException {
//        Gson gson = new Gson();
//
//        String orderJSON = gson.toJson(orderList);
//
//        try{
//            FileWriter file = new FileWriter("Order.json");
//            file.write(orderJSON);
//            file.flush();
//
//        }catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static void serializeACustomerList(Customer customer) throws IOException {
//        Gson gson = new Gson();
//
//        List<Customer> updatedListToBeSer;
//        updatedListToBeSer = deserializeACustomerList();
//
//        updatedListToBeSer.add(customer);
//
//        String custJSON = gson.toJson(updatedListToBeSer);
//
//        try{
//            FileWriter file = new FileWriter("Customer.json");
//            file.write(custJSON);
//            file.flush();
//
//        }catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static void serializeACustomerList() throws IOException {
//        Gson gson = new Gson();
//
//        String custJSON = gson.toJson(customerList);
//
//        try{
//            FileWriter file = new FileWriter("Customer.json");
//            file.write(custJSON);
//            file.flush();
//
//        }catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static void serializeAStaffList(Staff staff) throws IOException {
//        Gson gson = new Gson();
//
//        List<Staff> updatedListToBeSerialized;
//        updatedListToBeSerialized = deserializeAStaffList();
//
//        updatedListToBeSerialized.add(staff);
//
//        String staffJSON = gson.toJson(updatedListToBeSerialized);
//
//        try{
//            FileWriter file = new FileWriter("Staff.json");
//            file.write(staffJSON);
//            file.flush();
//
//        }catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static void serializeAStaffList() throws IOException {
//        Gson gson = new Gson();
//
//        String staffJSON = gson.toJson(staffList);
//
//        try{
//            FileWriter file = new FileWriter("Staff.json");
//            file.write(staffJSON);
//            file.flush();
//
//        }catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static ArrayList<Order> deserializeAnOrderList() throws IOException {
//        // get name/location of json file from the user and store it in a string - DONE IN MAIN
//
//        String file = "Order.json";
//
//        File newFile = new File(file);
//        if(newFile.createNewFile()) {
//            System.out.println(newFile.getName() + " has been created.");
//
//            try {
//                FileWriter fileWriter = new FileWriter(file);
//                fileWriter.write("[]");
//                fileWriter.flush();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//
//        String readInJson = new String(Files.readAllBytes(Paths.get(file)));
//
//////        we must evaluate the type of the list of orders using a typeToken before we use Gson().fromJson
////        Type orderListType = new TypeToken<ArrayList<Order>>(){}.getType();
////
//////        returns deserialized object
////        return new Gson().fromJson(readInJson, orderListType);
//
//        TypeToken<ArrayList<Order>> typeToken = new TypeToken<ArrayList<Order>>(){};
//        return new Gson().fromJson(readInJson, typeToken.getType());
//    }
//
//    //    deserializes Customer.json and updates the class list
//    public static ArrayList<Customer> deserializeACustomerList() throws IOException {
//        String file = "Customer.json";
//
//        File newFile = new File(file);
//        if(newFile.createNewFile()) {
//            System.out.println(newFile.getName() + " has been created.");
//
//            try {
//                FileWriter fileWriter = new FileWriter(file);
//                fileWriter.write("[]");
//                fileWriter.flush();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//
//        String readInJson = new String(Files.readAllBytes(Paths.get(file)));
//
////        we must evaluate the type of the list of orders using a typeToken before we use Gson().fromJson
//        Type customerListType = new TypeToken<ArrayList<Customer>>(){}.getType();
//
////        returns deserialized object
//        return new Gson().fromJson(readInJson, customerListType);
//    }
//
//    public static ArrayList<Staff> deserializeAStaffList() throws IOException {
//        String file = "Staff.json";
//
//        File newFile = new File(file);
//        if(newFile.createNewFile()) {
//            System.out.println(newFile.getName() + " has been created.");
//
//            try {
//                FileWriter fileWriter = new FileWriter(file);
//                fileWriter.write("[]");
//                fileWriter.flush();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//
//        String readInJson = new String(Files.readAllBytes(Paths.get(file)));
//
////        we must evaluate the type of the list of orders using a typeToken before we use Gson().fromJson
////        Type staffListType = new TypeToken<ArrayList<Staff>>(){}.getType();
//
//        //        returns deserialized object
////        return new Gson().fromJson(readInJson, staffListType);
//
//        TypeToken<ArrayList<Staff>> typeToken = new TypeToken<ArrayList<Staff>>(){};
//        return new Gson().fromJson(readInJson, typeToken.getType());
//
//    }
//
//    public static String convertJsonIntoString(String file) throws IOException {
//
//        return new String(Files.readAllBytes(Paths.get(file)));
//    }
//
//    public String jsonFileToUpdate(T object) {
//        if (object.getClass() == Order.class) {
//            return "management.Order.json";
//        } else if (object.getClass() == Customer.class) {
//            return "Customer.json";
//        } else if (object.getClass() == Staff.class || object.getClass() == Manager.class) {
//            return "Staff.json";
//        }
//        return "";
//    }

    public static Staff searchAndReturn(String userName){
        for (Staff staff: staffList) {
            if(staff.employeeID.equals(userName))
            {
                return staff;
            }
        }
        return null;
    }

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

}
