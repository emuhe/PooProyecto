package ec.edu.espol.proyectopoofx;

import java.io.File;
import java.io.IOException;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;

public class PrimaryController {

    @FXML
    private Button primaryButton;
    @FXML
    private ComboBox<String> OpcionesdeJugador;
    @FXML
    private ImageView Imagen_principal_logo;
    @FXML
    private Label mensaje_error;
    @FXML
    private TextField J1_name;
    @FXML
    private CheckBox check_namej1;

    @FXML
    private void switchToSecondary() throws IOException, InterruptedException {
        String tipoJugador = OpcionesdeJugador.getValue();
        
        boolean name_exists = false;
        boolean tipe_exists = false;
        String j1 = J1_name.getText();        
        if(!j1.equals("") || check_namej1.isSelected()){
            name_exists = true;
            if (check_namej1.isSelected()){
                j1 = "Jugador 1";
            }
        }
        else{
            check_namej1.setVisible(true);       
        }
        if(tipoJugador == null){
            mensaje_error.setText("Escoja alguien para jugar");
        }
        else{
            tipe_exists = true;
        }
        if(name_exists && tipe_exists){
            Jugador.NombreJ1 = j1;
            App.setRoot("secondary");
        }
    }
    public void initialize(){
        check_namej1.setVisible(false);
        OpcionesdeJugador.getItems().removeAll(OpcionesdeJugador.getItems());
        OpcionesdeJugador.getItems().addAll("Computadora", "Jugador");
        File file = new File("src/Domino_Icon.jpeg");
        Image image = new Image(file.toURI().toString());
        Imagen_principal_logo.setImage(image);
    }

    @FXML
    private void actualizara(MouseEvent event) {
        mensaje_error.setText("");
    }

    @FXML
    private void actualizartext_box(KeyEvent event) {
        if(check_namej1.isVisible()){
            check_namej1.setVisible(false);
            check_namej1.setSelected(false);
        }
        
    }
    
}