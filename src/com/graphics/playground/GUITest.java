package com.graphics.playground;

import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import javax.imageio.stream.FileImageInputStream;
import javax.imageio.stream.ImageInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOError;
import java.io.InputStream;
import java.util.ArrayList;

public class GUITest extends Application {

    private Image image;

    public static void main(String[] args) {
//      A static method which creates an instance of the app, then calls init(), start(), and stop() when code
//      execution is finished.
        launch(args);
    }

//    The start() method is derived from the abstract class Application. This is the entry point called by launch() where the JavaFX code
//    will be written.
    @Override
    public void start(Stage primaryStage)
    {
        Polygon triangle = new Polygon();
        triangle.getPoints().addAll(new Double[]{
                100.0,50.0,
                150.0,200.0,
                50.0,200.0
        });
        triangle.setFill(Color.GRAY);

        RotateTransition rotateTransition = new RotateTransition();
        rotateTransition.setDuration(Duration.millis(10000));
        rotateTransition.setNode(triangle);
        rotateTransition.setByAngle(360);
        rotateTransition.setCycleCount(5);
        rotateTransition.setAutoReverse(true);
        rotateTransition.play();

        ScaleTransition scaleTransition = new ScaleTransition();
        scaleTransition.setDuration(Duration.millis(5000));
        scaleTransition.setNode(triangle);
        scaleTransition.setByX(-.5);
        scaleTransition.setByY(-.5);
        scaleTransition.setCycleCount(10);
        scaleTransition.setAutoReverse(true);
        scaleTransition.play();

        TranslateTransition translateTransition = new TranslateTransition();
        translateTransition.setDuration(Duration.millis(10000));
        translateTransition.setNode(triangle);
        translateTransition.setByX(300);
        translateTransition.setCycleCount(5);
        translateTransition.setAutoReverse(true);
        translateTransition.play();



        Group group = new Group();
        ObservableList list = group.getChildren();
        list.add(getImage());
        list.add(triangle);

        Scene scene = new Scene(group, 600, 300);

        //scene.setFill(Color.W);

        primaryStage.setTitle("Line");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public void setImage()
    {

       try{
           this.image = new Image(GUITest.class.getResourceAsStream("sprite/StoneFloorTexture.png"));

       }catch(Exception e)
       {
           System.out.println("file was not found.");
       }


    }
    public ImageView getImage()
    {
        this.setImage();

        ImageView imageView = new ImageView(image);

        imageView.setX(50);
        imageView.setY(25);
        imageView.setFitHeight(300);
        imageView.setFitWidth(300);
        imageView.setPreserveRatio(true);

        return imageView;

    }

//    The init() method is derived from the abstract class Application. This is called by launch() before start().
    @Override
    public void init()
    {

    }

//    The stop() method is derived from the abstract class Application. This is where we will define how we exit the
//    application, launch() calls this when all of the code is finished by default. To override this when the end of the
//    code has been reached, we must call the setImplicitExit(false) method and set this to false. We may also exit the
//    application at any time by using Platform.exit() or System.exit(0).
    @Override
    public void stop()
    {

    }
}
