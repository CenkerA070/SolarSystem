package com.example.solarsystem;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.util.Duration;

public class HelloController {

    @FXML
    private Pane pane;

    private Circle sun;
    private Circle earth;
    private Circle moon;
    private Circle mars;
    private Circle mercury;
    private Circle venus;
    private Circle jupiter;
    private Circle saturn;
    private Shape saturnRing;



    private Ellipse saturnOrbit;
    private Ellipse earthOrbit;
    private Ellipse venusOrbit;
    private Ellipse marsOrbit;
    private Ellipse mercuryOrbit;
    private Ellipse jupiterOrbit;


    private double earthRotate = 0.0;
    private double moonRotate = 0.0;
    private double marsRotate = 0.0;
    private double mercuryRotate = 0.0;
    private double venusRotate = 0.0;
    private double jupiterRotate = 0.0;
    private  double saturnRotate = 0.0;

    @FXML
    private void initialize() {
        // Create circles
        sun = createCircle(0, 0, 75, Color.YELLOW);
        earth = createCircle(0, 0, 20, Color.LIGHTBLUE);
        moon = createCircle(0, 0, 10, Color.GRAY);
        mars = createCircle(0, 0, 15, Color.RED);
        mercury = createCircle(0, 0, 18, Color.ORANGE);
        venus = createCircle(0, 0, 20, Color.ORANGERED);
        jupiter = createCircle(0, 0, 40, Color.SANDYBROWN);
        saturn = createCircle(0, 0, 35, Color.SADDLEBROWN);



        // Create ellipses for the orbits
        earthOrbit = createOrbitEllipse(sun.getCenterX(), sun.getCenterY(), 240);
        marsOrbit = createOrbitEllipse(sun.getCenterX(), sun.getCenterY(), 310);
        mercuryOrbit = createOrbitEllipse(sun.getCenterX(), sun.getCenterY(), 130);
        venusOrbit = createOrbitEllipse(sun.getCenterX(), sun.getCenterY(), 170);
        jupiterOrbit = createOrbitEllipse(sun.getCenterX(), sun.getCenterY(), 380);
        saturnOrbit = createOrbitEllipse(sun.getCenterX(), sun.getCenterY(), 450);



        // Add the circles and ellipses to the pane
        pane.getChildren().addAll(sun, venus, earth, moon, mars, mercury, jupiter, saturn, saturnOrbit, jupiterOrbit, venusOrbit, earthOrbit, marsOrbit, mercuryOrbit);



        // Add a listener to reposition the planets when the pane's size changes
        pane.widthProperty().addListener((observable, oldValue, newValue) -> {
            double centerX = newValue.doubleValue() / 2;
            sun.setCenterX(centerX);
            earth.setCenterX(centerX);
            moon.setCenterX(centerX);
            mars.setCenterX(centerX);
            mercury.setCenterX(centerX);
            venus.setCenterX(centerX);
            jupiter.setCenterX(centerX);
            saturn.setCenterX(centerX);
            updateOrbitEllipses(centerX, sun.getCenterY());
        });

        pane.heightProperty().addListener((observable, oldValue, newValue) -> {
            double centerY = newValue.doubleValue() / 2;
            sun.setCenterY(centerY);
            earth.setCenterY(centerY);
            moon.setCenterY(centerY);
            mars.setCenterY(centerY);
            mercury.setCenterY(centerY);
            venus.setCenterY(centerY);
            jupiter.setCenterY(centerY);
            saturn.setCenterY(centerY);
            updateOrbitEllipses(sun.getCenterX(), centerY);
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
            updateMercuryPosition();
            updateMercuryRotation();
            updateVenusPosition();
            updateVenusRotation();
            updateJupiterPosition();
            updateJupiterRotation();
            updateSaturnPosition();
            updateSaturnRotation();
        }));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }




    private Circle createCircle(double centerX, double centerY, double radius, Color color) {
        Circle circle = new Circle(centerX, centerY, radius);
        circle.setFill(color);
        return circle;
    }

    private Ellipse createOrbitEllipse(double centerX, double centerY, double radius) {
        Ellipse ellipse = new Ellipse(centerX, centerY, radius, radius);
        ellipse.setStroke(Color.WHITE);
        ellipse.setFill(Color.TRANSPARENT);
        return ellipse;
    }

    private void updateOrbitEllipses(double centerX, double centerY) {
        earthOrbit.setCenterX(centerX);
        earthOrbit.setCenterY(centerY);
        marsOrbit.setCenterX(centerX);
        marsOrbit.setCenterY(centerY);
        mercuryOrbit.setCenterX(centerX);
        mercuryOrbit.setCenterY(centerY);
        venusOrbit.setCenterX(centerX);
        venusOrbit.setCenterY(centerY);
        jupiterOrbit.setCenterY(centerY);
        jupiterOrbit.setCenterX(centerX);
        saturnOrbit.setCenterX(centerX);
        saturnOrbit.setCenterY(centerY);
    }

    private void updateSaturnPosition() {
        double saturnX = sun.getCenterX() + 450.0 * Math.cos(Math.toRadians(saturnRotate));
        double saturnY = sun.getCenterY() + 450.0 * Math.sin(Math.toRadians(saturnRotate));
        saturn.setCenterX(saturnX);
        saturn.setCenterY(saturnY);
    }





    private void updateVenusPosition() {
        double venusX = sun.getCenterX() + 170.0 * Math.cos(Math.toRadians(venusRotate));
        double venusY = sun.getCenterY() + 170.0 * Math.sin(Math.toRadians(venusRotate));
        venus.setCenterX(venusX);
        venus.setCenterY(venusY);
    }

    private void updateJupiterPosition() {
        double jupiterX = sun.getCenterX() + 380.0 * Math.cos(Math.toRadians(jupiterRotate));
        double jupiterY = sun.getCenterY() + 380.0 * Math.sin(Math.toRadians(jupiterRotate));
        jupiter.setCenterX(jupiterX);
        jupiter.setCenterY(jupiterY);
    }


    private void updateMarsPosition() {
        double marsX = sun.getCenterX() + 310.0 * Math.cos(Math.toRadians(marsRotate));
        double marsY = sun.getCenterY() + 310.0 * Math.sin(Math.toRadians(marsRotate));
        mars.setCenterX(marsX);
        mars.setCenterY(marsY);
    }

    private void updateMercuryPosition() {
        double mercuryX = sun.getCenterX() + 130.0 * Math.cos(Math.toRadians(mercuryRotate));
        double mercuryY = sun.getCenterY() + 130.0 * Math.sin(Math.toRadians(mercuryRotate));
        mercury.setCenterX(mercuryX);
        mercury.setCenterY(mercuryY);
    }

    private void updateEarthPosition() {
        double earthX = sun.getCenterX() + 240.0 * Math.cos(Math.toRadians(earthRotate));
        double earthY = sun.getCenterY() + 240.0 * Math.sin(Math.toRadians(earthRotate));
        earth.setCenterX(earthX);
        earth.setCenterY(earthY);
    }

    private void updateMoonPosition() {
        double moonX = earth.getCenterX() + 40.0 * Math.cos(Math.toRadians(moonRotate));
        double moonY = earth.getCenterY() + 40.0 * Math.sin(Math.toRadians(moonRotate));
        moon.setCenterX(moonX);
        moon.setCenterY(moonY);
    }

    private void updateMarsRotation() {
        marsRotate += 0.8;
        mars.setRotate(marsRotate);
    }

    private void updateVenusRotation() {
        venusRotate += 1.17;
        venus.setRotate(venusRotate);
    }

    private void updateEarthRotation() {
        earthRotate += 1.0;
        earth.setRotate(earthRotate);
    }

    private void updateMoonRotation() {
        moonRotate += 1.5;
        moon.setRotate(moonRotate);
    }

    private void updateMercuryRotation() {
        mercuryRotate += 1.6;
        mercury.setRotate(mercuryRotate);
    }

    private void updateJupiterRotation() {
        jupiterRotate += 0.43;
        jupiter.setRotate(jupiterRotate);
    }

    private void updateSaturnRotation() {
        saturnRotate += 0.37;
        saturn.setRotate(saturnRotate);
    }


}
