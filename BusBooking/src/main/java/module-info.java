module com.mycompany.busbooking {
    
    requires javafx.base;
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    
    requires java.base;
    requires mysql.connector.java;
    requires java.sql;

    opens com.mycompany.busbooking to javafx.fxml;
    exports com.mycompany.busbooking;
}
