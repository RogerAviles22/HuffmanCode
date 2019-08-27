/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.application.Platform;
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
        
        scene = new Scene(new Group(), 600, 200);
        scene.setRoot(stv.getRoot());
        
        Image image= new Image("/Recursos/algorithm.png");
        primaryStage.getIcons().add(image);
        
        primaryStage.setTitle("HuffmanCoding");
        primaryStage.setScene(scene);
        primaryStage.setOnCloseRequest(e -> Platform.exit());
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
