module com.example.zoosys {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;

    opens com.example.zoosys to javafx.fxml;
    exports com.example.zoosys;

    opens com.example.zoosys.controllers to javafx.fxml;
    exports com.example.zoosys.controllers;

    opens com.example.zoosys.models to javafx.fxml;
    exports com.example.zoosys.models;
}