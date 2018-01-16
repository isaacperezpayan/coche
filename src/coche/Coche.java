/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coche;

import java.io.File;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

/**
 *
 * @author isaac
 */
public class Coche extends Application {
    short cocheCenterX=300;
    short cocheCenterY=360;
    byte velocidadcochey=3;
    byte velocidadcochex=3;
    @Override
    public void start(Stage primaryStage) {
        
        
        Pane root = new Pane();    
        Scene scene = new Scene(root, 600, 400);
        scene.setFill(Color.GRAY);
        primaryStage.setTitle("Coche");
        primaryStage.setScene(scene);
        primaryStage.show();
        Line line2 = new Line();
        line2.setStartX(400.0f);
        line2.setStartY(0.0f);
        line2.setEndX(400.0f);
        line2.setEndY(400.0f);
        line2.setStroke(Color.YELLOW);
        line2.setStrokeWidth(20);
        root.getChildren().add(line2);
 
        Line line1 = new Line();
        line1.setStartX(200.0f);
        line1.setStartY(0.0f);
        line1.setEndX(200.0f);
        line1.setEndY(400.0f);
        line1.setStroke(Color.YELLOW);
        line1.setStrokeWidth(20);
        root.getChildren().add(line1);
        // Cargamos la imagen
        // El archivo debe estar en la carpeta del proyecto
        File file = new File("cocheb.png");
        Image img = new Image(file.toURI().toString());
        ImageView imageView = new ImageView(img);
        imageView.setX(cocheCenterX);
        imageView.setY(cocheCenterY);
        File file2 = new File("senal.png");
        Image img2 = new Image(file2.toURI().toString());
        ImageView imageView2 = new ImageView(img2);
        imageView2.setX(cocheCenterX+120);
        imageView2.setY(cocheCenterY-200);
        root.getChildren().add(imageView);
        root.getChildren().add(imageView2);
        AnimationTimer movimiento;
        movimiento = new AnimationTimer() {
            public void handle(long now) {
                imageView.setX(cocheCenterX);
                cocheCenterX+= velocidadcochex;
                if (cocheCenterX >= 360){
                    velocidadcochex = -3;
                }
                if (cocheCenterX <= 200){
                    velocidadcochex = 3;
                }
                imageView.setY(cocheCenterY);
                cocheCenterY+= velocidadcochey;
                if (cocheCenterY >= 360){
                    velocidadcochey = -3;
                }
                if (cocheCenterY <= 0){
                    velocidadcochey = 3;
                }
            };
        
       };
       movimiento.start();
 }    
        // simple displays ImageView the image as is
         
        
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
                
