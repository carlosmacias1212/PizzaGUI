package controllers.pizzagui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import static list.JsonController.*;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Login-View.fxml"));
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Login-View.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 900, 600);
        stage.setTitle("PieHackers Pizza Restaurant!");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) throws IOException {

        deserializeStaff();
        deserializeCustomers();
        deserializeOrders();

        launch();


    }
}