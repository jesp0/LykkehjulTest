package com.example.lykkehjul;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.VPos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class LykkeHjulTest extends Application {
    public Arc kakestykke;
    public Text hjultall;
    public Group lykkehjul;
    public final int BREDDE = 700;
    public final int HØYDE = 500;
    public final int ANT_BITER = 34;
    public double rotasjon = 79.5;
    Animation animation;
    public double hjulspinn = 0.0;
    @Override
    public void start(Stage stage) throws IOException {

        Pane hovedpane = new Pane();
        //Circle test = new Circle(BREDDE/2,HØYDE/2,200, Color.BLUE);
        //hovedpane.getChildren().add(test);
        double startAngle = 0;
        double length = 10.58823529411765;
        int radius = 200;
        boolean rød = true;
        lykkehjul = new Group();

        // Takk ChatGPT
        double startAngle2 = 0; // in radians
        double extentAngle = Math.toRadians(10.58823529411765); // in radians

        for(int i=0; i<ANT_BITER; i++) {
            kakestykke = new Arc(BREDDE / 2, HØYDE / 2, radius, radius, startAngle, length);
            kakestykke.setType(ArcType.ROUND);
            if(rød){
                kakestykke.setFill(Color.DARKRED);
                rød = false;
            } else if(!rød){
                kakestykke.setFill(Color.RED);
                rød = true;
            }
            lykkehjul.getChildren().add(kakestykke);

            //hjultall = new Text(kakestykke.getCenterX() + radius * Math.cos(startAngle + length),
            //        kakestykke.getCenterY() + radius * Math.sin(startAngle + length), "" + i);


            // Takk ChatGPT
            double angle = startAngle2 + i * extentAngle;

            // Den her må sikkert deles opp i 4 sektorer (+x +y / +x -y /osv)
            int x = (int)(BREDDE/2 + radius * Math.cos(angle));
            int y = (int)(HØYDE/2 + radius * Math.sin(angle));

            hjultall = new Text(x,y,""+i);

            hjultall.setTextOrigin(VPos.CENTER);
            hjultall.setFill(Color.WHITE);
            hjultall.setStroke(Color.BLACK);
            hjultall.setFont(new Font(20));
            lykkehjul.getChildren().add(hjultall);
            rotasjon += 10.58823529411765;
            hjultall.setRotate(rotasjon);

            /*
            System.out.println(i + "---------- INFO ----------" + "\n"
                                + "getRadiusX - " + kakestykke.getRadiusX() + "\n"
                                + "getRadiusY - " + kakestykke.getRadiusY() + "\n"
                                + "getCenterX - " + kakestykke.getCenterX() + "\n"
                                + "getLength - " + kakestykke.getLength() + "\n"
                                + "getStartAngle - " + kakestykke.getStartAngle() + "\n");
*/
            //kakestykke.setFill(Color.GRAY);
            //kakestykke.setStroke(Color.BLUE);
            //hovedpane.getChildren().add(kakestykke);
            startAngle -= 10.58823529411765;
        }
        hovedpane.getChildren().add(lykkehjul);

        hjulAnimasjon();

        Scene scene = new Scene(hovedpane, BREDDE, HØYDE);
        scene.setOnMouseClicked(e -> spinnHjul());
        scene.setOnKeyPressed(e -> stoppHjul());

        stage.setTitle("Lykkehjul");
        stage.setScene(scene);
        stage.show();
    }

    public void spinnHjul(){
        animation.play();
    }

    public void hjulAnimasjon(){
        animation = new Timeline(
                new KeyFrame(Duration.millis(15), e -> lykkehjul.setRotate(hjulspinn+=1.0)));
        animation.setCycleCount(Timeline.INDEFINITE);
        //animation.play();
    }

    public void stoppHjul(){
        //if(hjulspinn==0.0)
            animation.stop();
        //else
        //    hjulspinn-=0.1;
    }

    public static void main(String[] args) {
        launch();
    }
}