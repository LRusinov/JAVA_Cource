module com.example.hw5_problem2 {
    requires java.desktop;
    requires java.net.http;
    requires jdk.jsobject;
    requires jdk.xml.dom;
    requires java.xml;
    requires javafx.base;
    requires javafx.controls;
    requires javafx.graphics;
    requires javafx.fxml;

    opens com to javafx.fxml;
    exports com;
}