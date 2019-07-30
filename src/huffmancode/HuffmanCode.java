/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huffmancode;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author Rogencio
 */
public class HuffmanCode extends Application {
    private static Scene scene;
    
    @Override
    public void start(Stage primaryStage) {
        HuffmanPane stv= new HuffmanPane();        
        
        scene = new Scene(new Group(), 850, 650);
        scene.setRoot(stv.getRoot());
        
        Image image= new Image("/Recursos/algorithm.png");
        primaryStage.getIcons().add(image);
        
        primaryStage.setTitle("HuffmanCode");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
