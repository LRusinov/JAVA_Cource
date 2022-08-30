package problem1;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.TextStyle;
import java.util.Locale;

public class Calendar extends Application {
    TextInputDialog inputDialog = new TextInputDialog();
    Alert warningAlert = new Alert(Alert.AlertType.WARNING);

    public boolean input_validation(String str) {
        if (str.length() != 7 || str.charAt(2) != '-' ||
                str.charAt(0) < '0' || str.charAt(0) > '9' ||
                str.charAt(1) < '0' || str.charAt(1) > '9' ||
                str.charAt(3) < '0' || str.charAt(3) > '9' ||
                str.charAt(4) < '0' || str.charAt(4) > '9' ||
                str.charAt(5) < '0' || str.charAt(5) > '9' ||
                str.charAt(6) < '0' || str.charAt(6) > '9') {
            Alert_display();
            return false;
        }
        return true;
    }

    public boolean month_validation(int month) {
        if (month < 1 || month > 12) {
            Alert_display();
            return false;
        }
        return true;
    }

    public void Alert_display() {
        warningAlert.setTitle("Input Error");
        warningAlert.setHeaderText("Invalid input!");
        warningAlert.showAndWait();
    }

    public void start(Stage stage) {
        inputDialog.setHeaderText(""); //setting the dialog content
        inputDialog.setTitle("Set calendar");
        inputDialog.setContentText("Enter month and year (format: mm-yyyy)");
        final Button cancel = (Button) inputDialog.getDialogPane().lookupButton(ButtonType.CANCEL);//implementing the
        cancel.addEventFilter(ActionEvent.ACTION, event ->          //Cancel button
                System.exit(0));


        String input = inputDialog.showAndWait().get();//getting the input from the dialog
        while (!input_validation(input)) { //validating the input (if its in correct format)
            inputDialog.getEditor().clear(); //clearing the input box
            input = inputDialog.showAndWait().get();
        }

        int month = Integer.parseInt(input, 0, 2, 10);//extracting the number of the month and
        int year = Integer.parseInt(input, 3, 7, 10);// year from the input

        while (!month_validation(month)) { //validating the month
            inputDialog.getEditor().clear(); //clearing the input box
            input = inputDialog.showAndWait().get();
            month = Integer.parseInt(input, 0, 2, 10);
            year = Integer.parseInt(input, 3, 7, 10);
        }

        GridPane gridPane = new GridPane(); //Creating container
        gridPane.setHgap(10); //setting the space between the columns
        gridPane.setPadding(new Insets(55, 55, 0, 55));// setting the padding of the calendar


        YearMonth date;
        date = YearMonth.of(year, month);

        int dayOfWeek = date.atDay(1).getDayOfWeek().getValue();//getting the day of week of the 1st day of
        int counter = 0;                                                   //the entered month
        int monthLength = date.lengthOfMonth();

        String[] str = {"MON", "TUE", "WED", "THR", "FRI", "SAT", "SUN"};//setting array of strings with days of week
        Text[] daysOfWeek = new Text[7];
        for (int i = 0; i < 7; i++) { //adding the days of week in the calendar
            daysOfWeek[i] = new Text(str[i]);
            daysOfWeek[i].setFont(Font.font(daysOfWeek[i].getFont().getName(), FontWeight.BOLD, 12));
            gridPane.add(daysOfWeek[i], i, 0);
        }

        Text[] numOfDays = new Text[31];//setting array fot the numbers of the month
        for (int i = 0; i < monthLength; i++) {  //adding the numbers to the array
            numOfDays[i] = new Text(Integer.toString(i + 1));
            numOfDays[i].setFont(Font.font(numOfDays[i].getFont().getName(), FontWeight.BOLD, 12));
        }

        if (YearMonth.now().getYear() == year && YearMonth.now().getMonthValue() == month) { //checking if the entered
            numOfDays[LocalDate.now().getDayOfMonth()-1].setFill(Color.RED);               //month is the current month
        }                                                               //so that we can mark the current date in red
        for (int i = dayOfWeek - 1; i < 7; i++) { //filling the first line of the calendar with numbers
            gridPane.add(numOfDays[counter], i, 1);
            counter++;
        }
        for (int i = 2; i < 7; i++) {  //filling the rest of the calendar with numbers
            for (int j = 0; j < 7; j++) {
                gridPane.add(numOfDays[counter], j, i);
                counter++;
                if (counter > monthLength - 1) break;// checking if we reached the end of the month
            }
            if (counter > monthLength - 1) break;// checking if we reached the end of the month
        }

        Group group = new Group();
        group.getChildren().add(gridPane);
        Scene scene = new Scene(group, 350, 250);
        stage.setTitle("Calendar for " +
                date.getMonth().getDisplayName(TextStyle.FULL, new Locale("en")).toUpperCase(Locale.ROOT)
                + " " + year);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}