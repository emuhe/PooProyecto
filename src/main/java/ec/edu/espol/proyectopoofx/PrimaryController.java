package ec.edu.espol.proyectopoofx;

import java.io.File;
import java.io.IOException;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
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
    private ImageView Imagen_principal_logo;
    @FXML
    private Label mensaje_error;
    @FXML
    private TextField J1_name;
    @FXML
    private CheckBox check_namej1;

    @FXML
    private void switchToSecondary() throws IOException, InterruptedException {
        
        boolean name_exists = false;
        boolean tipe_exists = true;
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
        if(name_exists && tipe_exists){
            JuegoFX.NombreJ1 = j1;
            JuegoFX.tipoj2 = Utilitaria.convertir("Computadora");
            App.setRoot("secondary");
        }
    }
    public void initialize(){
        check_namej1.setVisible(false);
        File file = new File("src/Domino_Icon.jpeg");
        Image image = new Image(file.toURI().toString());
        Imagen_principal_logo.setImage(image);
        Imagen_principal_logo.setFitHeight(256);
        Imagen_principal_logo.setFitWidth(256);
    }

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
