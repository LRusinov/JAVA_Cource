package problem2;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class Spiral extends Application {
    @Override
    public void start(Stage stage) {
        Group group = new Group();
        Scene scene = new Scene(group, 300, 300);

        double height = scene.getHeight();
        double width = scene.getWidth();
        int spaceCounter = 25;  //counting the needed empty space from the scene
        double xStart = width - spaceCounter;
        double yStart = spaceCounter;
        double xEnd = spaceCounter;
        double yEnd = spaceCounter;

        while (xStart != width / 2 && yStart != height / 2 || xEnd != width / 2 && yEnd != height / 2) { // when reach the center

            Line topLine = new Line(xStart, yStart, xEnd, yEnd);//drawing top line
            topLine.setStroke(Color.RED);
            group.getChildren().add(topLine);
            xStart = spaceCounter;
            yStart = height - spaceCounter;

            Line leftLine = new Line(xEnd, yEnd, xStart, yStart);//drawing left line
            leftLine.setStroke(Color.RED);
            group.getChildren().add(leftLine);
            yEnd = yStart;
            spaceCounter += 25;
            xEnd = width - spaceCounter;

            Line bottomLine = new Line(xStart, yStart, xEnd, yEnd);//drawing bottom line
            bottomLine.setStroke(Color.RED);
            group.getChildren().add(bottomLine);
            xStart = xEnd;
            yStart = spaceCounter;

            Line rightLine = new Line(xEnd, yEnd, xStart, yStart);//drawing right line
            rightLine.setStroke(Color.RED);
            group.getChildren().add(rightLine);
            xEnd = spaceCounter;
            yEnd = yStart;
        }

        stage.setTitle("Draw square shaped spiral");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}