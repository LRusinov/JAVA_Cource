package view;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class RegistrationFormController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnRegistration;

    @FXML
    private Label lblEmail;

    @FXML
    private Label lblPassword;

    @FXML
    private Label lblPhoneNumber;

    @FXML
    private Label lblUsername;

    @FXML
    private PasswordField pswConfirmPassword;

    @FXML
    private PasswordField pswPassword;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtPhoneNumber;

    @FXML
    private TextField txtUsername;

    @FXML
    void btnRegistrationOnAction(ActionEvent event) {
        lblUsername.setText("");
        lblPhoneNumber.setText("");
        lblEmail.setText("");
        lblPassword.setText("");

        if (!txtUsername.getText().matches("[a-zA-Z]{2,}")) {
            lblUsername.setText("Invalid Username!");
        }
        if (!txtPhoneNumber.getText().matches("\\(\\d{4}\\)\\(\\d{7}\\)")) {
            lblPhoneNumber.setText("Invalid Phone number!");
        }
        if (!txtEmail.getText().matches("([\\w-]+\\.?)+@[-\\w]+\\.[a-zA-z]{2,4}")) {
            lblEmail.setText("Invalid Email!");
        }
        if (pswPassword.getText() == null || pswPassword.getText().equals("")) {
            lblPassword.setText("No password is added!");
        } else if (!pswPassword.getText().equals(pswConfirmPassword.getText())) {
            lblPassword.setText("Confirm password is different");
        }
        if (lblUsername.getText().equals("") &&
                lblPhoneNumber.getText().equals("") &&
                lblEmail.getText().equals("") &&
                lblPassword.getText().equals("")) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Successful registration!");
            alert.setHeaderText("You registered an account successfully");
            alert.showAndWait();
            Platform.exit();
        }
    }


    @FXML
    void initialize() {
        assert btnRegistration != null : "fx:id=\"btnRegistration\" was not injected: check your FXML file 'registration-view.fxml'.";
        assert lblEmail != null : "fx:id=\"lblEmail\" was not injected: check your FXML file 'registration-view.fxml'.";
        assert lblPassword != null : "fx:id=\"lblPassword\" was not injected: check your FXML file 'registration-view.fxml'.";
        assert lblPhoneNumber != null : "fx:id=\"lblPhoneNumber\" was not injected: check your FXML file 'registration-view.fxml'.";
        assert lblUsername != null : "fx:id=\"lblUsername\" was not injected: check your FXML file 'registration-view.fxml'.";
        assert pswConfirmPassword != null : "fx:id=\"pswConfirmPassword\" was not injected: check your FXML file 'registration-view.fxml'.";
        assert pswPassword != null : "fx:id=\"pswPassword\" was not injected: check your FXML file 'registration-view.fxml'.";
        assert txtEmail != null : "fx:id=\"txtEmail\" was not injected: check your FXML file 'registration-view.fxml'.";
        assert txtPhoneNumber != null : "fx:id=\"txtPhoneNumber\" was not injected: check your FXML file 'registration-view.fxml'.";
        assert txtUsername != null : "fx:id=\"txtUsername\" was not injected: check your FXML file 'registration-view.fxml'.";

    }

}

