package ec.edu.espol.proyectopoofx;

import java.util.ArrayList;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

public class  SecondaryController {

    @FXML
    private FlowPane Mazo_Jugador;
    private ArrayList<HBox> Tablero;
    private ArrayList<VBox> Mazo_Jugador_Sub;
    private int seleccionada_lado1 = 0;
    private int seleccionada_lado2 = 0;
    private VBox ficha_seleccionada = null;
    @FXML
    private Button Tirar;
    JuegoFX Juego_Principal;
    private ImagenesDomino imagenes;
    private int N_Turno;
    @FXML
    private HBox Tablero_Juego;
    @FXML
    private ScrollPane Panel_scroll;
    @FXML
    private Label Fichas_restantes;
    @FXML
    private GridPane Menu_player;
    @FXML
    private BorderPane Panel_padre;
    @FXML
    private Button Boton_rendirse;
    @FXML
    private Label cantidad_pc;
    
    public void initialize(){
        N_Turno = 0;
        Panel_scroll.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        Tablero = new ArrayList<>();
        imagenes = new ImagenesDomino();
        Mazo_Jugador_Sub = new ArrayList<>();
        Juego_Principal = new JuegoFX();
        Generar_mazo_player1(Juego_Principal.getJugadores().get(0).getMano());
        Ronda();
    }
    private void Generar_mazo_player1(ArrayList<Ficha> Fichas_Jugador_1){
        ArrayList<VBox>fichas_VBOX = new ArrayList<>();
        
        for(Ficha fichita: Fichas_Jugador_1){
            System.out.println(fichita);
            fichas_VBOX.add(Generar_ficha(fichita));
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
            n_ficha.setStyle("-fx-border-color: green;\n-fx-border-width: 5;");
         });
        Mazo_Jugador.getChildren().add(n_ficha);
            
         return n_ficha;
         
    }


    @FXML
    private void TirarFicha(ActionEvent event) {
        
        for(VBox hola: Mazo_Jugador_Sub){
            if (hola.equals(ficha_seleccionada)){
                int indice = Mazo_Jugador_Sub.indexOf(hola);
                Ficha ficha_seleccionada = Juego_Principal.getJugadores().get(0).getMano().get(indice);
                if(ficha_seleccionada.esComodin() && ficha_seleccionada.getLado1() == -1 && ficha_seleccionada.getLado2() == -1){
                    //CASO ESPECIFICO CUANDO EL JUGADOR INICIA CON COMODIN
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
                            Juan_Pedro.setLado1(imagenes.indice_a_num(mod_lado1));
                            Juan_Pedro.setLado2(imagenes.indice_a_num(mod_lado2));
                            
                            dialog.close();
                            TirarFicha(new ActionEvent());
                        });
                        
                        
                        panel.add(confirmado,1,2);
                        dialog.setAlwaysOnTop(true);
                        dialog.setScene(escena);
                        dialog.show();
                    }
                    //CASO CUANDO EL JUGADOR TIRA EL COMODIN
                    else{
                        Stage dialog = new Stage();
                        dialog.initStyle(StageStyle.UTILITY);
                        GridPane panel = new GridPane();
                        panel.setHgap(10);
                        panel.setVgap(10);
                        panel.setMinWidth(200);
                        panel.setMinHeight(200);
                        Scene escena = new Scene(panel);
                        panel.add(new Label("Seleccione el Lado libre"), 0,0);
                        
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
                        
                        HBox escoger_lado = new HBox();
                        ToggleGroup tg = new ToggleGroup();
                        RadioButton izquierda = new RadioButton("Izquierda");
                        RadioButton derecha = new RadioButton("Derecha");
                        izquierda.setToggleGroup(tg);
                        derecha.setToggleGroup(tg);
                        izquierda.setSelected(true);
                        escoger_lado.getChildren().addAll(izquierda,derecha);
                        panel.add(escoger_lado,0,2);
                        panel.add(op1,0,1);
                        Button confirmado = new Button();
                        confirmado.setText("Aceptar");
                        confirmado.setOnAction((ActionEvent a) -> {
                            final int mod_lado1 = imagenes.indice_actual(op1_image.getImage());
                            FichaComodin Juan_Pedro =(FichaComodin) Juego_Principal.getJugadores().get(0).getFicha(Juego_Principal.getJugadores().get(0).getMano().size()-1);
                            
                            switch(((RadioButton) tg.getSelectedToggle()).getText()){
                                case "Izquierda":
                                    Juan_Pedro.setLado1(imagenes.indice_a_num(mod_lado1));
                                    Juan_Pedro.setLado2(Juego_Principal.Valor_Inicial());
                                    Juan_Pedro.vaInicio = true;
                                    break;
                                    
                                case "Derecha":
                                    Juan_Pedro.setLado2(imagenes.indice_a_num(mod_lado1));
                                    Juan_Pedro.setLado1(Juego_Principal.Valor_Final());
                                    Juan_Pedro.vaInicio = false;
                                    break;
                            }
                            dialog.close();
                            TirarFicha(new ActionEvent());
                        });
                        panel.add(confirmado,0,3);
                        dialog.setAlwaysOnTop(true);
                        dialog.setScene(escena);
                        dialog.show();
                        
                    }
                }

                System.out.println(ficha_seleccionada);
                
                switch(Juego_Principal.AgregarFicha(ficha_seleccionada))
                {
                    case 1:
                        Generar_ficha_juego(ficha_seleccionada,0);
                        Mazo_Jugador.getChildren().remove(hola);
                        Mazo_Jugador_Sub.remove(hola);
                        Juego_Principal.getJugadores().get(0).getMano().remove(ficha_seleccionada);
                        break;

                    case 0:
                        Generar_ficha_juego(ficha_seleccionada,1);
                        Mazo_Jugador.getChildren().remove(hola);
                        Mazo_Jugador_Sub.remove(hola);
                        Juego_Principal.getJugadores().get(0).getMano().remove(ficha_seleccionada);
                        break;

                    case -1:
                        System.out.println("Nada");
                        break;
                    case 3:
                        
                        final int posicion;
                        final int idk;
                        if(((FichaComodin) ficha_seleccionada).vaInicio){
                            posicion = 0;
                            idk = 1;
                           
                        }
                        else {posicion = 1;
                            idk = 0;
                        }
                        Juego_Principal.AgregarFicha(ficha_seleccionada, posicion);
                        Generar_ficha_juego(ficha_seleccionada,idk);
                        Mazo_Jugador.getChildren().remove(hola);
                        Mazo_Jugador_Sub.remove(hola);
                        Juego_Principal.getJugadores().get(0).getMano().remove(ficha_seleccionada);
                        break;

                }
                
                System.out.println("-------------------------");
                Juego_Principal.mostrarLinea();
                
                
                break;        
                        
                }
        
        }
    }
    
    private void Generar_ficha_juego(Ficha ficha,int ladotocanteficha){
        HBox Ficha_mazo = new HBox();
         int lado1 = ficha.getLado1();
         int lado2 = ficha.getLado2();
         ImageView imageview1 = new ImageView(imagenes.getCara(imagenes.num_a_indice(lado1)));
         ImageView imageview2 = new ImageView(imagenes.getCara(imagenes.num_a_indice(lado2)));
         imageview1.setRotate(270);
         imageview1.setFitWidth(90);
         imageview2.setRotate(90);
         imageview2.setFitWidth(90);
         
         if(ladotocanteficha == 0){
         Ficha_mazo.getChildren().addAll(imageview1,imageview2);
         Tablero.add(Ficha_mazo);
         }
         else{
         Ficha_mazo.getChildren().addAll(imageview1,imageview2);
         Tablero.add(0,Ficha_mazo);
         }
         Tablero_Juego.getChildren().clear();
         Tablero_Juego.getChildren().addAll(Tablero);
         Tablero_Juego.requestLayout();
         Panel_scroll.autosize();
         Fichas_restantes.setText(Integer.toString(Juego_Principal.getJugadores().get(0).getMano().size())+"/6");
         N_Turno++;
         Ronda();
         
    }
    
    private void Ronda(){
        if (N_Turno % 2 == 0){
        Menu_player.setDisable(false);
        }
        else{
        Menu_player.setDisable(true);
        int ladotocante_pc = 1;
        Ficha ficha_pc = Juego_Principal.AgregarPC_Inicio();
        
        PauseTransition delay = new PauseTransition(Duration.seconds(2));
        
        if (ficha_pc == null){
            ficha_pc = Juego_Principal.AgregarPC_Final();
            if(ficha_pc == null){
                ficha_pc = Juego_Principal.AgregarPC_Comodin();
                if(ficha_pc == null){
                  App.close();
                }
                else{
                    System.out.println("LA PC USA COMODIN!");
                    if(((FichaComodin) ficha_pc).vaInicio){
                        ladotocante_pc = 1;
                    }
                    else{
                        ladotocante_pc = 0;
                    }
                }
            }
            else{
            ladotocante_pc = 0;}
        }
        else{
            ladotocante_pc = 1;
        }
        final Ficha hola = ficha_pc;
        final int orwua = ladotocante_pc;
        delay.setOnFinished(event -> {
        Juego_Principal.getJugadores().get(1).getMano().remove(hola);
        cantidad_pc.setText(Integer.toString(Juego_Principal.getJugadores().get(1).getMano().size())+"/6 CARTAS");
        Generar_ficha_juego(hola,orwua);
        });
        
        delay.play();

        }
    }

    @FXML
    private void Gallina(ActionEvent event) {
        App.close();
    }
    
    
    
}
