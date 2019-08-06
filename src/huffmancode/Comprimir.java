/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huffmancode;

import java.io.File;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 *
 * @author Rogencio
 */
public class Comprimir {
    private BorderPane root;
    private Button salir;
    private Label titulo;
    private Stage stageForm;
    private FileChooser fileChooser = new FileChooser();
    private final Button openButton = new Button("Open a file txt...");
    
    public Comprimir() {
        root= new BorderPane();
        BackgroundFill fondo = new BackgroundFill(Color.BISQUE, new CornerRadii(1),
                new Insets(0.0, 0.0, 0.0, 0.0));
        root.setBackground(new Background(fondo)); 
        contenido();
        cerrarVentana();
    }
    private void contenido(){
        VBox vb= new VBox();
        titulo= new Label("Selecciona archivo a comprimir ");        
        openButton.setOnAction(e -> {
            File selectedFile = fileChooser.showOpenDialog(stageForm);
        });
        
        salir= new Button("Salir");
        vb.setAlignment(Pos.CENTER);
        vb.setSpacing(10);
        vb.getChildren().addAll(titulo,openButton,salir);
        root.setCenter(vb);
    }
    
    public void mostrarVentana(){
        stageForm = new Stage();
        Scene scene = new Scene(getRoot(), 250, 150);
        stageForm.setTitle("Comprimir");
        stageForm.setScene(scene);
        stageForm.show();       
    }
    
    private void cerrarVentana(){
        salir.setOnMouseClicked(e->{
            stageForm.close();
        });
    }

    public BorderPane getRoot() {
        return root;
    }
}
