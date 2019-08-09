/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huffmancode;

import java.io.File;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 *
 * @author Rogencio
 */
public class Comprimir extends Compresion{
    
    public Comprimir() {
        root= new BorderPane();
        BackgroundFill fondo = new BackgroundFill(Color.BISQUE, new CornerRadii(1),
                new Insets(0.0, 0.0, 0.0, 0.0));
        root.setBackground(new Background(fondo)); 
        contenido();
        cerrarVentana();
    }
    
    
    private void contenido(){
        GridPane gp = new GridPane();
        
        inicializarContenido();
        
        gp.add(openButton, 0, 0);
        gp.add(txt_file, 0, 1);
        gp.add(accion, 0, 2);
        gp.add(salir, 0, 3);
        gp.setHgap(10);
        gp.setVgap(10);
        openButton.setOnAction(e -> {
            File selectedFile = fileChooser.showOpenDialog(null);
            select_File(selectedFile, txt_file);
        });
        configureFileChooser(fileChooser);
        
        gp.setPadding(new Insets(10, 10, 10, 10));
        gp.setAlignment(Pos.CENTER);
        root.setCenter(gp);
    }
    
    /**
     * Inicializa los botones y elementos.
     */
    private void inicializarContenido(){ 
        openButton = new Button("Selecciona el archivo a comprimir: ");
        fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        salir= new Button("Salir");
        txt_file = new TextField();
        txt_file.setEditable(false);
        accion = new Button("Comprimir");
    }
    
    private void select_File(File selectedFile, TextField txt_file){
        if(selectedFile!=null)
            txt_file.setText(selectedFile.getAbsolutePath());
    }
    
    /**
     * Restriccion de sólo abrir archivos .txt
     * @param fileChooser Elemento FileChooser
     */
    private void configureFileChooser(final FileChooser fileChooser) {                        
        fileChooser.getExtensionFilters().addAll(
            new FileChooser.ExtensionFilter("TXT Files", "*.txt")
        );
    }
    
    @Override
    public void mostrarVentana(){
        stageForm = new Stage();
        Scene scene = new Scene(getRoot(), 450, 150);
        stageForm.setTitle("Comprimir");
        stageForm.setScene(scene);
        stageForm.show();       
    }
    
    private void cerrarVentana(){
        salir.setOnMouseClicked(e->{
            stageForm.close();
        });
    }
    
}
