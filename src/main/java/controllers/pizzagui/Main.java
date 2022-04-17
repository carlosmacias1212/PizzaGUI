package controllers.pizzagui;

import com.google.gson.Gson;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import list.JsonController;
import management.Staff;
import static list.JsonController.*;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Login-View.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1200, 800);
        stage.setTitle("PieHackers Pizza Restaurant!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        try {
            orderList = deserializeAnOrderList("Order.json");
         staffList = deserializeAStaffList("Staff.json");
        } catch (IOException e) {
            e.printStackTrace();
        }
        launch();
    }
}