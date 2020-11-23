module com.mycompany.busreservation {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.busreservation to javafx.fxml;
    exports com.mycompany.busreservation;
}
