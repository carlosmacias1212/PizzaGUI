package controllers.pizzagui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import list.JsonController;
import management.Staff;

import java.io.IOException;

import static list.JsonController.deserializeAStaffList;
import static list.JsonController.staffList;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Login-View.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 900, 600);
        stage.setTitle("PieHackers Pizza Restaurant!");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        try {
            //orderList = deserializeAnOrderList("Order.json");
            Staff newStaff = new Staff("Albert", "Villalobos", "200408625", "lobos");
            JsonController json = new JsonController();
            json.serializeAList(newStaff);
         staffList = deserializeAStaffList("Staff.json");
        } catch (IOException e) {
            e.printStackTrace();
        }
        launch();

        //push to raybranch
    }
}