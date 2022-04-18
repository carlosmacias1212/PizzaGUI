module controllers.pizzagui {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.google.gson;

    opens controllers.pizzagui to javafx.fxml, com.google.gson;
    exports controllers.pizzagui;

    exports management;
    opens management to javafx.fxml, com.google.gson;

    exports customer_info;
    opens customer_info to javafx.fxml, com.google.gson;

    exports food;
    opens food to javafx.fxml, com.google.gson;

    exports list;
    opens list to javafx.fxml, com.google.gson;
}