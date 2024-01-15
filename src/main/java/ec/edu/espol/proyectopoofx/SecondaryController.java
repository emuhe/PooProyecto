package ec.edu.espol.proyectopoofx;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class  SecondaryController {

    @FXML
    private FlowPane Mazo_Jugador;
    private ArrayList<VBox> Mazo_Jugador_Sub;
    @FXML
    private int seleccionada_lado1 = 0;
    private int seleccionada_lado2 = 0;
    private VBox ficha_seleccionada = null;
    private Button Tirar;
    JuegoFX Juego_Principal;
    
    public void initialize(){
        System.out.println("a");
        Mazo_Jugador_Sub = new ArrayList<>();
        Juego_Principal = new JuegoFX();
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
         Mazo_Jugador_Sub.add(n_ficha);
         n_ficha.getChildren().addAll(imageview1,imageview2);
        System.out.println("Ficha creada!");
        n_ficha.setCursor(Cursor.HAND);
        n_ficha.setOnMouseClicked((MouseEvent t) -> {
            Mazo_Jugador.getChildren().forEach(child -> {
                child.setStyle("-fx-border-width: 0");
            });
            ficha_seleccionada = n_ficha;
            seleccionada_lado1 = lado1;
            seleccionada_lado2 = lado2;
            
            System.out.println(Integer.toString(seleccionada_lado1)+ " " + Integer.toString(seleccionada_lado2));
            n_ficha.setStyle("-fx-border-color: green;\n-fx-border-width: 5;");
            System.out.println(n_ficha);
         });
        Mazo_Jugador.getChildren().add(n_ficha);
            
         return n_ficha;
         
    }

    @FXML
    private void ClickenFlowpane(MouseEvent event) {
    }

    @FXML
    private void TirarFicha(ActionEvent event) {
        
        System.out.println("Agregando Ficha");
        System.out.println(Integer.toString(seleccionada_lado1)+ " " + Integer.toString(seleccionada_lado2));
        for(VBox hola: Mazo_Jugador_Sub){
            if (hola.equals(ficha_seleccionada)){
                int indice = Mazo_Jugador_Sub.indexOf(hola);
                Ficha ficha_seleccionada = Juego_Principal.getJugadores().get(0).getMano().get(indice);
                if(ficha_seleccionada.esComodin()){
                    if(Juego_Principal.getTablero().isEmpty()){
                        Stage dialog = new Stage();
                        dialog.initStyle(StageStyle.UTILITY);
                        GridPane panel = new GridPane();
                        Scene escena = new Scene(panel);
                        panel.add(new Label("Seleccione el Lado 1"), 0,0);
                        panel.add(new Label("Seleccione el Lado 2"),1,0);
                        HBox op1 = new HBox();
                        File opcion1_file = new File("src/Piezas_Domino/N_"+Integer.toString(1)+".png");
                        Image opcion1_imagen = new Image(opcion1_file.toURI().toString());
                        ImageView imageview1 = new ImageView(opcion1_imagen);
                        
                        
                        dialog.setAlwaysOnTop(true);
                        dialog.setScene(escena);
                        dialog.show();
                    }
                
                }
                
                

                if(false){
                Mazo_Jugador.getChildren().remove(hola);
                Mazo_Jugador_Sub.remove(hola);
                }
                System.out.println("A");
                
                break;        
                        
                }
        
        }
    }
    
    
}