/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import javafx.scene.control.Alert;

/**
 *
 * @author Rogencio
 */
public class MensajeControlador {
    public void mensajeCompresionCorrecto(String mensaje){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Creado");
            alert.setHeaderText(null);
            alert.setContentText(mensaje);
            alert.showAndWait();
    }
    
    public void mensajeTextFieldVacio(){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Seleccione el/los archivos a leer ");
            alert.showAndWait();
    }
}
