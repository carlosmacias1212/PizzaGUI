package controllers.pizzagui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import list.JsonController;
import management.Staff;

import java.io.IOException;

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
        Staff newStaff = new Staff("Albert", "Villalobos", "lobos", "200408625");
        JsonController json = new JsonController();
        try {
            json.serializeAStaffList(newStaff);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //launch();
    }
}