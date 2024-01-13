package ec.edu.espol.proyectopoofx;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

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
    private void switchToSecondary() throws IOException {
        String tipoJugador = OpcionesdeJugador.getValue();
        boolean name_exists = false;
        boolean tipe_exists = false;
        String j1 = J1_name.getText();
        System.out.println(j1);
        System.out.println(tipoJugador);
        
        if(!j1.equals("") || check_namej1.isSelected()){
            name_exists = true;
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
        System.out.println("FASFSAD");
        if(check_namej1.isVisible()){
            check_namej1.setVisible(false);
            check_namej1.setSelected(false);
        }
        
    }
    
}