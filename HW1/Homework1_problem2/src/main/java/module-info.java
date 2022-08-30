module com.example.homework1_problem2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.homework1_problem2 to javafx.fxml;
    exports com.example.homework1_problem2;
}