/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huffmancode;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 *
 * @author Rogencio
 */
public class HuffmanPane {
    private BorderPane root;
    private Button btn_comprimir;
    private Button btn_descomprimir;
    private Label lbl_titulo;

    public HuffmanPane() {
        
        root = new BorderPane();   
        BackgroundFill fondo = new BackgroundFill(Color.LIGHTBLUE, new CornerRadii(1),
                new Insets(0.0, 0.0, 0.0, 0.0));
        root.setBackground(new Background(fondo));
        inicializar();
        encabezado();
    }
    
    private void inicializar(){
        Image image = new Image(getClass().getResourceAsStream("/Recursos/decodificar.png"));
        ImageView view = new ImageView(image);
        btn_comprimir = new Button("COMPRIMIR",view);
        btn_comprimir.setOnAction(e->{
            Comprimir comp= new Comprimir();
            comp.mostrarVentana();
        }); 
        Image image2 = new Image(getClass().getResourceAsStream("/Recursos/codificar.png"));
        ImageView view2 = new ImageView(image2);
        btn_descomprimir = new Button("DESCOMPRIMIR",view2);
        btn_descomprimir.setOnAction(e->{
            Descomprimir desc= new Descomprimir();
            desc.mostrarVentana();
        }); 
    }
    
    private void encabezado(){        
        HBox hb = new HBox();
        VBox vb = new VBox();
        lbl_titulo= new Label("Código de Huffman");
        lbl_titulo.setFont(Font.font("Georgia",FontWeight.BOLD,30));
        hb.setAlignment(Pos.CENTER);
        hb.setSpacing(10);
        hb.setPadding(new Insets(15, 10, 10, 10));
        hb.getChildren().addAll(btn_comprimir,btn_descomprimir);
        vb.getChildren().addAll(lbl_titulo,hb);
        vb.setPadding(new Insets(15, 10, 10, 10));
        root.setTop(vb);
    }

    public BorderPane getRoot() {
        return root;
    }
    
    
    
    
}
