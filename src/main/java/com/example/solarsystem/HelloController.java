package com.example.solarsystem;


import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

import java.util.Random;

public class HelloController {


    @FXML
    private Pane pane;

    private Circle sun;
    private Circle earth;
    private Circle moon;

    private  Circle mars;

    private double earthRotate = 0.0;
    private double moonRotate = 0.0;

    private double marsRotate = 0.0;


    @FXML
    private void initialize() {
        // Create circles for the sun, earth, and moon
        sun = createCircle(0, 0, 50, Color.YELLOW);
        earth = createCircle(0, 0, 20, Color.BLUE);
        moon = createCircle(0, 0, 10, Color.GRAY);
        mars = createCircle(0, 0, 15, Color.ORANGE);

        // Add the circles to the pane
        pane.getChildren().addAll(sun, earth, moon, mars);

        // Add a listener to reposition the planets when the pane's size changes
        pane.widthProperty().addListener((observable, oldValue, newValue) -> {
            double centerX = newValue.doubleValue() / 2;
            sun.setCenterX(centerX);
            earth.setCenterX(centerX);
            moon.setCenterX(centerX);
            mars.setCenterX(centerX);
        });

        pane.heightProperty().addListener((observable, oldValue, newValue) -> {
            double centerY = newValue.doubleValue() / 2;
            sun.setCenterY(centerY);
            earth.setCenterY(centerY);
            moon.setCenterY(centerY);
            mars.setCenterY(centerY);
        });

        // Animation timeline
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0.02), event -> {
            // Update the positions and rotations
            updateEarthPosition();
            updateMoonPosition();
            updateEarthRotation();
            updateMoonRotation();
            updateMarsPosition();
            updateMarsRotation();
        }));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }



    private Circle createCircle(double centerX, double centerY, double radius, Color color) {
        Circle circle = new Circle(centerX, centerY, radius);
        circle.setFill(color);
        return circle;
    }

    private void updateMarsPosition() {
        double marsX = sun.getCenterX() + 250.0 * Math.cos(Math.toRadians(marsRotate));
        double marsY = sun.getCenterY() + 250.0 * Math.sin(Math.toRadians(marsRotate));

        mars.setCenterX(marsX);
        mars.setCenterY(marsY);
    }
    private void updateEarthPosition() {
        double earthX = sun.getCenterX() + 150.0 * Math.cos(Math.toRadians(earthRotate));
        double earthY = sun.getCenterY() + 100.0 * Math.sin(Math.toRadians(earthRotate));
        earth.setCenterX(earthX);
        earth.setCenterY(earthY);
    }

    private void updateMoonPosition() {
        double moonX = earth.getCenterX() + 50.0 * Math.cos(Math.toRadians(moonRotate));
        double moonY = earth.getCenterY() + 30.0 * Math.sin(Math.toRadians(moonRotate));
        moon.setCenterX(moonX);
        moon.setCenterY(moonY);
    }

    private  void updateMarsRotation() {
        marsRotate += 1.0;
        mars.setRotate(marsRotate);
    }

    private void updateEarthRotation() {
        earthRotate += 1.0;
        earth.setRotate(earthRotate);
    }

    private void updateMoonRotation() {
        moonRotate += 5.0;
        moon.setRotate(moonRotate);
    }
}
