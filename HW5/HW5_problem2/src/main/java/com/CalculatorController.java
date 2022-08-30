package com;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class CalculatorController extends AnchorPane{

    @FXML
    private Button btnMMinus;

    @FXML
    private Button btnMPlus;

    @FXML
    private Button btnMC;
    @FXML
    private Button btnM;

    @FXML
    private Button bntMultiply;

    @FXML
    private Button btnC;

    @FXML
    private Button btnCA;

    @FXML
    private Button btnDivision;

    @FXML
    private Button btnDoubleZero;

    @FXML
    private Button btnEight;

    @FXML
    private Button btnEqual;

    @FXML
    private Button btnFive;

    @FXML
    private Button btnFour;

    @FXML
    private Button btnMinus;

    @FXML
    private Button btnNine;

    @FXML
    private Button btnOff;

    @FXML
    private Button btnOne;

    @FXML
    private Button btnPlus;

    @FXML
    private Button btnPoint;

    @FXML
    private Button btnSeven;

    @FXML
    private Button btnSix;

    @FXML
    private Button btnThree;

    @FXML
    private Button btnTwo;

    @FXML
    private Button btnZero;

    @FXML
    private TextField txtScreen;
    private double num1;
    private double num2;
    private double result;

    private double mNum;
    String operation;

    public CalculatorController() {
        FXMLLoader fxmlLoader = new FXMLLoader(
                getClass().getResource("/com/Calculator-view.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    @FXML
    void bntMultiplyOnAction() {
        operate("*");
    }

    @FXML
    void btnCAOnAction() {
        txtScreen.setText("0");
        operation = "";
    }

    @FXML
    void btnCOnAction() {
        txtScreen.setText("0");
    }

    @FXML
    void btnDivisionOnAction() {
        operate("/");
    }

    @FXML
    void btnDoubleZeroOnAction() {
        writeOnScreen("00");
    }

    @FXML
    void btnEightOnAction() {
        writeOnScreen("8");
    }

    @FXML
    void btnEqualOnAction() {
        num2 = Double.parseDouble(txtScreen.getText());
        switch (operation) {
            case "+" -> result = num1 + num2;
            case "-" -> result = num1 - num2;
            case "*" -> result = num1 * num2;
            case "/" -> result = num1 / num2;
        }
        operation = "";
        txtScreen.setText(Double.toString(result));
    }

    @FXML
    void btnFiveOnAction() {
        writeOnScreen("5");
    }

    @FXML
    void btnFourOnAction() {
        writeOnScreen("4");
    }

    @FXML
    void btnMinus() {
        operate("-");
    }

    @FXML
    void btnNineOnAction() {
        writeOnScreen("9");
    }

    @FXML
    void btnOffOnAction() {
        System.exit(0);
    }

    @FXML
    void btnOneOnAction() {
        writeOnScreen("1");
    }

    @FXML
    void btnPlusOnAction() {
        operate("+");
    }

    @FXML
    void btnPointOnAction() {
        writeOnScreen(".");
    }

    @FXML
    void btnSevenOnAction() {
        writeOnScreen("7");
    }

    @FXML
    void btnSixOnAction() {
        writeOnScreen("6");
    }

    @FXML
    void btnThreeOnAction() {
        writeOnScreen("3");
    }

    @FXML
    void btnTwoOnAction() {
        writeOnScreen("2");
    }

    @FXML
    void btnZeroOnAction() {
        writeOnScreen("0");
    }

    @FXML
    void btnMMinusOnAction() {
        result = mNum - Double.parseDouble(txtScreen.getText());
        txtScreen.setText(Double.toString(result));
    }

    @FXML
    void btnMOnAction() {
        mNum = Double.parseDouble(txtScreen.getText());
    }

    @FXML
    void btnMPlusOnAction() {
        result = mNum + Double.parseDouble(txtScreen.getText());
        txtScreen.setText(Double.toString(result));
    }

    @FXML
    void btnMCOnAction() {
        mNum = 0;
        txtScreen.setText("0");
    }

    private void writeOnScreen(String symbol) {
        String screenText = txtScreen.getText();
        if (screenText.equals("0") &&
                !symbol.equals("00") &&
                !symbol.equals(".")) {

            txtScreen.setText(symbol);
        } else {
            txtScreen.setText(screenText + symbol);
        }
    }

    private void operate(String operation) {
        this.operation = operation;
        num1 = Double.parseDouble(txtScreen.getText());
        txtScreen.setText("0");
    }

    public double getResult() {
        return result;
    }

    public void setNum1(String numString) {
        num1 = Double.parseDouble(numString);
    }

    public void setNum2(String numString) {
        num2 = Double.parseDouble(numString);
    }

    @FXML
    void initialize() {
        assert btnM != null : "fx:id=\"btnM\" was not injected: check your FXML file 'Calculator-view.fxml'.";
        assert btnMPlus != null : "fx:id=\"btnMPlus\" was not injected: check your FXML file 'Calculator-view.fxml'.";
        assert btnMC != null : "fx:id=\"btnMC\" was not injected: check your FXML file 'Calculator-view.fxml'.";
        assert btnMMinus != null : "fx:id=\"btnMMinus\" was not injected: check your FXML file 'Calculator-view.fxml'.";
        assert bntMultiply != null : "fx:id=\"bntMultiply\" was not injected: check your FXML file 'Calculator-view.fxml'.";
        assert btnC != null : "fx:id=\"btnC\" was not injected: check your FXML file 'Calculator-view.fxml'.";
        assert btnCA != null : "fx:id=\"btnCA\" was not injected: check your FXML file 'Calculator-view.fxml'.";
        assert btnDivision != null : "fx:id=\"btnDivision\" was not injected: check your FXML file 'Calculator-view.fxml'.";
        assert btnDoubleZero != null : "fx:id=\"btnDoubleZero\" was not injected: check your FXML file 'Calculator-view.fxml'.";
        assert btnEight != null : "fx:id=\"btnEight\" was not injected: check your FXML file 'Calculator-view.fxml'.";
        assert btnEqual != null : "fx:id=\"btnEqual\" was not injected: check your FXML file 'Calculator-view.fxml'.";
        assert btnFive != null : "fx:id=\"btnFive\" was not injected: check your FXML file 'Calculator-view.fxml'.";
        assert btnFour != null : "fx:id=\"btnFour\" was not injected: check your FXML file 'Calculator-view.fxml'.";
        assert btnMinus != null : "fx:id=\"btnMinus\" was not injected: check your FXML file 'Calculator-view.fxml'.";
        assert btnNine != null : "fx:id=\"btnNine\" was not injected: check your FXML file 'Calculator-view.fxml'.";
        assert btnOff != null : "fx:id=\"btnOff\" was not injected: check your FXML file 'Calculator-view.fxml'.";
        assert btnOne != null : "fx:id=\"btnOne\" was not injected: check your FXML file 'Calculator-view.fxml'.";
        assert btnPlus != null : "fx:id=\"btnPlus\" was not injected: check your FXML file 'Calculator-view.fxml'.";
        assert btnPoint != null : "fx:id=\"btnPoint\" was not injected: check your FXML file 'Calculator-view.fxml'.";
        assert btnSeven != null : "fx:id=\"btnSeven\" was not injected: check your FXML file 'Calculator-view.fxml'.";
        assert btnSix != null : "fx:id=\"btnSix\" was not injected: check your FXML file 'Calculator-view.fxml'.";
        assert btnThree != null : "fx:id=\"btnThree\" was not injected: check your FXML file 'Calculator-view.fxml'.";
        assert btnTwo != null : "fx:id=\"btnTwo\" was not injected: check your FXML file 'Calculator-view.fxml'.";
        assert btnZero != null : "fx:id=\"btnZero\" was not injected: check your FXML file 'Calculator-view.fxml'.";
        assert txtScreen != null : "fx:id=\"txtScreen\" was not injected: check your FXML file 'Calculator-view.fxml'.";
    }
}
