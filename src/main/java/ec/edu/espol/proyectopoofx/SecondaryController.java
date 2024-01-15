package ec.edu.espol.proyectopoofx;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Cursor;
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
    private ImagenesDomino imagenes;
    
    public void initialize(){
        imagenes = new ImagenesDomino();
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
        for(VBox vbox: fichas_VBOX){
    //Mazo_Jugador.getChildren().add(vbox);
        }
    }


    private VBox Generar_ficha(Ficha ficha){
         VBox n_ficha = new VBox();
         int lado1 = ficha.getLado1();
         int lado2 = ficha.getLado2();
         ImageView imageview1 = new ImageView(imagenes.getCara(imagenes.num_a_indice(lado1)));
         ImageView imageview2 = new ImageView(imagenes.getCara(imagenes.num_a_indice(lado2)));
         imageview2.setRotate(180);
         
         n_ficha.setId("#Ficha"+Integer.toString(Mazo_Jugador_Sub.size()));
         Mazo_Jugador_Sub.add(n_ficha);
         n_ficha.getChildren().addAll(imageview1,imageview2);
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
        
        System.out.println(Integer.toString(seleccionada_lado1)+ " " + Integer.toString(seleccionada_lado2));
        for(VBox hola: Mazo_Jugador_Sub){
            if (hola.equals(ficha_seleccionada)){
                int indice = Mazo_Jugador_Sub.indexOf(hola);
                Ficha ficha_seleccionada = Juego_Principal.getJugadores().get(0).getMano().get(indice);
                //CASO ESPECIFICO CUANDO EL JUGADOR INICIA CON COMODIN
                if(ficha_seleccionada.esComodin() && ficha_seleccionada.getLado1() == -1 && ficha_seleccionada.getLado2() == -1){
                    if(Juego_Principal.getTablero().isEmpty()){
                        Stage dialog = new Stage();
                        dialog.initStyle(StageStyle.UTILITY);
                        GridPane panel = new GridPane();
                        panel.setHgap(10);
                        panel.setVgap(10);
                        panel.setMinWidth(300);
                        panel.setMinHeight(200);
                        Scene escena = new Scene(panel);
                        panel.add(new Label("Seleccione el Lado 1"), 0,0);
                        panel.add(new Label("Seleccione el Lado 2"),1,0);
                        
                        //CREANDO PARA ESCOGER DEL PRIMER LADO DE LA FICHA
                        
                        HBox op1 = new HBox();
                        int indice_imagen_1 = 0;
                        ImageView op1_image = new ImageView(imagenes.getCara(indice_imagen_1));
                        Button izquierda_op1 = new Button("<");
                        Button derecha_op1 = new Button(">");
                        op1.getChildren().addAll(izquierda_op1,op1_image,derecha_op1);
                        izquierda_op1.setOnAction((ActionEvent a) -> {
                            final int indice_actual = imagenes.indice_actual(op1_image.getImage());
                            if (indice_actual != 0){
                            op1_image.setImage(imagenes.getCara(indice_actual-1));
                            }
                            
                        });
                        
                        derecha_op1.setOnAction((ActionEvent a) -> {
                            final int indice_actual = imagenes.indice_actual(op1_image.getImage());
                            if (indice_actual != 5){
                            op1_image.setImage(imagenes.getCara(indice_actual + 1 ));
                            }
                            
                        });
                                                
                        //CREANDO PARA ESCOGER DEL SEGUNDO  LADO DE LA FICHA
                        
                        HBox op2 = new HBox();
                        int indice_imagen_2 = 0;
                        ImageView op2_image = new ImageView(imagenes.getCara(indice_imagen_2));
                        Button izquierda_op2 = new Button("<");
                        Button derecha_op2 = new Button(">");
                        op2.getChildren().addAll(izquierda_op2,op2_image,derecha_op2);
                        izquierda_op2.setOnAction((ActionEvent a) -> {
                            final int indice_actual = imagenes.indice_actual(op2_image.getImage());
                            if (indice_actual != 0){
                            op2_image.setImage(imagenes.getCara(indice_actual - 1 ));
                            }
                            
                        });
                        
                        derecha_op2.setOnAction((ActionEvent a) -> {
                            final int indice_actual = imagenes.indice_actual(op2_image.getImage());
                            if (indice_actual != 5){
                            op2_image.setImage(imagenes.getCara(indice_actual + 1 ));
                            }
                            
                        });
                        
                        panel.add(op1,0,1);
                        panel.add(op2,1,1);
                        
                        Button confirmado = new Button();
                        confirmado.setText("Aceptar");
                        
                        confirmado.setOnAction((ActionEvent a) -> {
                            final int mod_lado1 = imagenes.indice_actual(op1_image.getImage());
                            final int mod_lado2 = imagenes.indice_actual(op2_image.getImage());
                            
                            FichaComodin Juan_Pedro =(FichaComodin) Juego_Principal.getJugadores().get(0).getFicha(Juego_Principal.getJugadores().get(0).getMano().size()-1);
                            Juan_Pedro.setLado1(mod_lado1);
                            Juan_Pedro.setLado2(mod_lado2);
                            
                            dialog.close();
                            TirarFicha(new ActionEvent());
                        });
                        
                        
                        panel.add(confirmado,1,2);
                        dialog.setAlwaysOnTop(true);
                        dialog.setScene(escena);
                        dialog.show();
                    }
                
                }
                
                

                else{
                
                if(Juego_Principal.AgregarFicha(ficha_seleccionada)){
                
                Mazo_Jugador.getChildren().remove(hola);
                Mazo_Jugador_Sub.remove(hola);
                System.out.println("Eliminado");
                Juego_Principal.getJugadores().get(0).getMano().remove(ficha_seleccionada);
                }
                }
                
                break;        
                        
                }
        
        }
    }
    
    
}
