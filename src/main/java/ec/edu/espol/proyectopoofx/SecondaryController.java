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
        Jugador jugador_principal = new Jugador("",Utilitaria.crearManoJugador());
        System.out.println(Jugador.NombreJ1);
    }
}