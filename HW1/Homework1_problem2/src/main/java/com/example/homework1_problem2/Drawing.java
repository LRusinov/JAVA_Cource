package com.example.homework1_problem2;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;


public class Drawing extends Application {
    @Override
    public void start(Stage stage) {
        Group group = new Group();
        Scene scene = new Scene(group, 450, 450);

        double height = scene.getHeight();

        double startX = 0;
        double startY = 0;
        double endX = 0;
        double endY = height;

        while (startY < height) { //drawing bottom left corner
            Line line = new Line(startX, startY, endX, endY);
            line.setStroke(Color.DARKORANGE);
            group.getChildren().add(line);
            startY += 20;
            endX += 20;
        }

        //startX=0  startY=height endX=height endY=height
        while (startX < height) { //drawing bottom right corner
            Line line = new Line(startX, startY, endX, endY);
            line.setStroke(Color.DARKORANGE);
            group.getChildren().add(line);
            startX += 20;
            endY -= 20;
        }

        //startX=height  startY=height endX=height endY=0
        while (endX > 0) {  //drawing top right corner
            Line line = new Line(startX, startY, endX, endY);
            line.setStroke(Color.DARKORANGE);
            group.getChildren().add(line);
            startY -= 20;
            endX -= 20;
        }

        //startX=height  startY=0 endX=0 endY=0
        while (endY < height) { //drawing top left corner
            Line line = new Line(startX, startY, endX, endY);
            line.setStroke(Color.DARKORANGE);
            group.getChildren().add(line);
            startX -= 20;
            endY += 20;
        }

        stage.setTitle("Canvas demo");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}