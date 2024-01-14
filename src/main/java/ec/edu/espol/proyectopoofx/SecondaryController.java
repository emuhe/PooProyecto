package ec.edu.espol.proyectopoofx;

import java.io.IOException;
import javafx.fxml.FXML;

public class SecondaryController {

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }
    @FXML
    public void initialize(){
        JuegoFX Juego_Principal = new JuegoFX();
        
    }
}