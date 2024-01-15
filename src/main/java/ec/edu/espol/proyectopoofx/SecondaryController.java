package ec.edu.espol.proyectopoofx;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class  SecondaryController {

    @FXML
    private FlowPane Mazo_Jugador;
    private ArrayList<VBox> Mazo_Jugador_Sub;
    @FXML
    private Button Tirar;

    public void initialize(){
        System.out.println("a");
        Mazo_Jugador_Sub = new ArrayList<>();
        JuegoFX Juego_Principal = new JuegoFX();
        Generar_mazo_player1(Juego_Principal.getJugadores().get(0).getMano());
    }
    private void Generar_mazo_player1(ArrayList<Ficha> Fichas_Jugador_1){
        ArrayList<VBox>fichas_VBOX = new ArrayList<>();
        
        for(Ficha fichita: Fichas_Jugador_1){
            System.out.println(fichita);
            fichas_VBOX.add(Generar_ficha(fichita));
        }
        System.out.println("Fichas generadas");
        for(VBox vbox: fichas_VBOX){
    //Mazo_Jugador.getChildren().add(vbox);
        }
    }


    private VBox Generar_ficha(Ficha ficha){
         VBox n_ficha = new VBox();
         int lado1 = ficha.getLado1();
         int lado2 = ficha.getLado2();
         File file1 = new File("src/Piezas_Domino/N_"+Integer.toString(lado1)+".png");
         Image imageL1 = new Image(file1.toURI().toString());
         ImageView imageview1 = new ImageView(imageL1);
         File file2 = new File("src/Piezas_Domino/N_"+Integer.toString(lado2)+".png");
         Image imageL2 = new Image(file2.toURI().toString());
         ImageView imageview2 = new ImageView(imageL2);
         imageview2.setRotate(180);
         n_ficha.setId("#Ficha"+Integer.toString(Mazo_Jugador_Sub.size()));
         n_ficha.getChildren().addAll(imageview1,imageview2);
        System.out.println("Ficha creada!");
        n_ficha.setCursor(Cursor.HAND);
        n_ficha.setOnMouseClicked((MouseEvent t) -> {
            Mazo_Jugador.getChildren().forEach(child -> {
                child.setStyle("-fx-border-width: 0");
            });
            n_ficha.setStyle("-fx-border-color: green;\n-fx-border-width: 5;");         
            
            
            System.out.println("Hola: " + Integer.toString(lado1) + " - "+Integer.toString(lado2));
         });
        Mazo_Jugador.getChildren().add(n_ficha);
            
         return n_ficha;
         
    }

    @FXML
    private void ClickenFlowpane(MouseEvent event) {
    }

    @FXML
    private void TirarFicha(ActionEvent event) {
    }
    
    
}