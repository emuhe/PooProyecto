/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.proyectopoofx;

import java.util.ArrayList;

/**
 *
 * @author Deeje
 */
public class Utilitaria {
    
    
        public static ArrayList<Ficha> crearManoJugador(){
        ArrayList<Ficha> fichas = new ArrayList<>();
        for(int i = 0; i < 5; i++){
            int num1 = (int) (Math.floor(Math.random() * 6) + 1);
            int num2 = (int) (Math.floor(Math.random() * 6) + 1);
            Ficha ficha = new Ficha(num1,num2);
            fichas.add(ficha);
        }
        Ficha fcomodin = new FichaComodin();
        fichas.add(new FichaComodin());
        return fichas; //Genera la mano del jugador
    }
        public static boolean convertir(String tipoJ){
        return tipoJ.equals("Jugador");
        }

}