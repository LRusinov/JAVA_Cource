package gui;

import view.CalculatorController;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;

public class ClientCalculatorController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private CalculatorController pnlUserComponent;

    @FXML
    void initialize() {
        assert pnlUserComponent != null : "fx:id=\"pnlUserComponent\" was not injected: check your FXML file 'clientCalculator-view.fxml'.";

    }

}
