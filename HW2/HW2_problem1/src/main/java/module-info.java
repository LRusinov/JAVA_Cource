module com.example.hw2_problem1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens problem1 to javafx.fxml;
    exports problem1;
}