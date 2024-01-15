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
public class JuegoFX {
    private ArrayList<Ficha> Tablero_Juego;
    public static String NombreJ1 = "";
    public static String NombreJ2 = "";
    public static boolean tipoj2 = false;
    private ArrayList<Jugador> Jugadores;
    public JuegoFX(){
        System.out.println("Creado");
        Jugadores = new ArrayList<Jugador>();
        Jugadores.add(new Jugador(NombreJ1,Utilitaria.crearManoJugador(),true));
        Jugadores.add(new Jugador(NombreJ2,Utilitaria.crearManoJugador(),tipoj2));
        Tablero_Juego = new ArrayList<Ficha>();
        
    }
    private int Valor_Inicial(){
    return Tablero_Juego.get(0).lado1; 
            }
    private int Valor_Final(){
        return Tablero_Juego.get(Tablero_Juego.size()-1).lado2;
    }
    private ArrayList<Ficha> getTablero(){
    return Tablero_Juego;
    }

    public ArrayList<Jugador> getJugadores() {
        return Jugadores;
    }
    
    public boolean AgregarFicha(Ficha ficha){
        if(Tablero_Juego.isEmpty()){
            Tablero_Juego.add(ficha);
        }
        
        else if(ficha.getLado1() == this.Valor_Final()){
            Tablero_Juego.add(ficha);
            return true;
        }
        else if (ficha.getLado2() == this.Valor_Inicial()){
            Tablero_Juego.add(0,ficha);
            return true;
        }
     return false;
    }
    
    
    
}
