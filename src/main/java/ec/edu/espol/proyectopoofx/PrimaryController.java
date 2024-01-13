package ec.edu.espol.proyectopoofx;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class PrimaryController {

    @FXML
    private Button primaryButton;
    @FXML
    private ComboBox<String> OpcionesdeJugador;
    @FXML
    private ImageView Imagen_principal_logo;

    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
    public void initialize(){
        OpcionesdeJugador.getItems().removeAll(OpcionesdeJugador.getItems());
        OpcionesdeJugador.getItems().addAll("Computadora", "Jugador");
        File file = new File("src/Domino_Icon.jpeg");
        Image image = new Image(file.toURI().toString());
        Imagen_principal_logo.setImage(image);
    }
}