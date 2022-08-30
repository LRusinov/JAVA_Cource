module com.example.homework2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens problem2 to javafx.fxml;
    exports problem2;
}