module com.example.java_project {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.java_project to javafx.fxml;
    exports com.example.java_project;
}