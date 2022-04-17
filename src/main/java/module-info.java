module controllers.pizzagui {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.google.gson;

    opens controllers.pizzagui to javafx.fxml;
    exports controllers.pizzagui;
    exports management;
    opens management to javafx.fxml;
}