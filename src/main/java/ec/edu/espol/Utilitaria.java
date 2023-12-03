package ec.edu.espol;

import java.util.ArrayList;


public class Utilitaria {
        public static ArrayList<Ficha> crearManoJugador(){
        ArrayList<Ficha> fichas = new ArrayList<>();
        for(int i = 0; i < 5; i++){
            int num1 = (int) (Math.floor(Math.random() * 6) + 1);
            int num2 = (int) (Math.floor(Math.random() * 6) + 1);
            Ficha ficha = new Ficha(num1,num2);
            fichas.add(ficha);
        }
        fichas.add(new FichaComodin());
        return fichas; //Genera la mano del jugador
    }

}
