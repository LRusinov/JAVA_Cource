package gui;

import java.util.Arrays;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import providers.CipherGenerator;
import providers.Result;
import providers.Wrapper;

public class GeneratorController {

    @FXML
    private Button btnGenerateChars;

    @FXML
    private Button btnQuit;

    @FXML
    private Button btnRandomSubset;

    @FXML
    private TextField txtSeed;

    @FXML
    private TextField txtSize;

    @FXML
    void btnGenerateCharsOnAction() {
        Wrapper wrapper = new Wrapper(Integer.parseInt(txtSize.getText()));
        Result result = CipherGenerator.countDistinct(wrapper.makeFixedRandom(), Integer.parseInt(txtSeed.getText()));

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Generate random sequence A-Z");
        alert.setHeaderText("Count distinct characters out of " + txtSize.getText());
        alert.setContentText("Chars: " + Arrays.toString(result.getChars()) + "\nResult: " + result.getData());
        alert.showAndWait();
    }

    @FXML
    void btnQuitOnAction() {
        System.exit(0);
    }

    @FXML
    void btnRandomSubsetOnAction() {
        Wrapper wrapper = new Wrapper(Integer.parseInt(txtSize.getText()));
        Result result = CipherGenerator.countDistinct(wrapper.makeFixedSelection(), 0);

        Alert alertRandom = new Alert(Alert.AlertType.INFORMATION);
        alertRandom.setTitle("Random subsequence of letter A-Z");
        alertRandom.setHeaderText("Count distinct characters out of " + txtSize.getText());
        alertRandom.setContentText("Chars: " + Arrays.toString(result.getChars()) + "\n" + "Result: " + result.getData());
        alertRandom.showAndWait();
    }

    @FXML
    void initialize() {
        assert btnGenerateChars != null : "fx:id=\"btnGenerateChars\" was not injected: check your FXML file 'generator-view.fxml'.";
        assert btnQuit != null : "fx:id=\"btnQuit\" was not injected: check your FXML file 'generator-view.fxml'.";
        assert btnRandomSubset != null : "fx:id=\"btnRandomSubset\" was not injected: check your FXML file 'generator-view.fxml'.";
        assert txtSeed != null : "fx:id=\"txtSeed\" was not injected: check your FXML file 'generator-view.fxml'.";
        assert txtSize != null : "fx:id=\"txtSize\" was not injected: check your FXML file 'generator-view.fxml'.";

    }

}
