/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import TDA.Util;
import java.io.File;
import java.util.HashMap;
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
import Modelo.HuffmanBT;

/**
 *
 * @author Rogencio
 */
public class Descomprimir extends Compresion{    
    private Button btn_compress;
    private TextField txt_compress;
    MensajeControlador mnsjContrl= new MensajeControlador();
    
    public Descomprimir() {
        root= new BorderPane();
        BackgroundFill fondo = new BackgroundFill(Color.AQUAMARINE, new CornerRadii(1),
                new Insets(0.0, 0.0, 0.0, 0.0));
        root.setBackground(new Background(fondo)); 
        contenido();
        cerrarVentana();
    }
    
    private void contenido(){
        GridPane gp = new GridPane();
        
        inicializar();
        
        gp.add(openButton, 0, 0);
        gp.add(txt_file, 0, 1);
        gp.add(btn_compress, 0, 2);
        gp.add(txt_compress, 0, 3);
        gp.add(accion, 0, 4);
        gp.add(salir, 0, 5);
        gp.setHgap(10);
        gp.setVgap(10);
        openButton.setOnAction(e -> {
            File selectedFile = fileChooser.showOpenDialog(null);
            select_File(selectedFile, txt_file);
        });
        btn_compress.setOnAction(e -> {
            File selectedFile = fileChooser.showOpenDialog(null);
            select_File(selectedFile, txt_compress);
        });
        configureFileChooser(fileChooser);
        
        gp.setPadding(new Insets(10, 10, 10, 10));
        gp.setAlignment(Pos.CENTER);
        root.setCenter(gp);
    }
    
    /**
     * Inicializa los botones y elementos.
     */
    private void inicializar(){
        openButton = new Button("Selecciona el archivo a descomprimir: ");
        btn_compress = new Button("Selecciona el archivo compress: ");
        fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        salir= new Button("Salir");
        txt_file = new TextField();
        txt_file.setEditable(false);        
        txt_compress= new TextField();
        txt_compress.setEditable(false);
        accion = new Button("Descomprimir");
        accionButton(txt_file, txt_compress);
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
    
    private void select_File(File selectedFile, TextField txt_file){
           if(selectedFile!=null)
               txt_file.setText(selectedFile.getAbsolutePath());
       }
    private void accionButton(TextField txt_file, TextField txt_file2){
        accion.setOnAction(e->{
            if(txt_file.getText().equals("") || txt_file2.getText().equals(""))
                mnsjContrl.mensajeTextFieldVacio();
            else{
                generarHuffmanDescomprimir(txt_file, txt_compress);
                mnsjContrl.mensajeCompresionCorrecto("Descomprimir Realizado");
                txt_file.setText("");
                txt_compress.setText("");
            }
                
        });
    }
    
    private void generarHuffmanDescomprimir(TextField txt_field, TextField txt_compress){
        String file = txt_field.getText();
        String leerHexaText= Util.leerTexto(file);
        String hexaBinario= Util.hexadecimalBinario(leerHexaText);
        HashMap<String,String> leerMapa = Util.leerMapa(txt_compress.getText());        
        String decodificado = HuffmanBT.decodificar(hexaBinario, leerMapa);
        System.out.println("TEXTO ORIGINAL"+decodificado);
        Util.guardarDecodificado(file, decodificado);
        
    }
    
    @Override
    public void mostrarVentana(){
        stageForm = new Stage();
        Scene scene = new Scene(getRoot(), 450, 250);
        stageForm.setTitle("Descomprimir");
        stageForm.setScene(scene);
        stageForm.show();       
    }
    
    private void cerrarVentana(){
        salir.setOnMouseClicked(e->{
            stageForm.close();
        });
    }
    
}
