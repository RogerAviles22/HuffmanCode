/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 *
 * @author Rogencio
 */
public abstract class Compresion {
    protected BorderPane root;
    protected Button salir;
    protected Stage stageForm;
    protected FileChooser fileChooser;
    protected Button openButton;
    protected TextField txt_file;
    protected Button accion;
    
    abstract void mostrarVentana();
    
    public BorderPane getRoot() {
        return root;
    }
    
}
