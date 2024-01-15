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
    public int Valor_Inicial(){
    return Tablero_Juego.get(0).lado1; 
            }
    public int Valor_Final(){
        return Tablero_Juego.get(Tablero_Juego.size()-1).lado2;
    }
    public ArrayList<Ficha> getTablero(){
    return Tablero_Juego;
    }

    public ArrayList<Jugador> getJugadores() {
        return Jugadores;
    }
    
    public int AgregarFicha(Ficha ficha){
        if(Tablero_Juego.isEmpty()){
            Tablero_Juego.add(ficha);
            return 1;
        }
        else{
            if(ficha.getLado1() == this.Valor_Final()){
                Tablero_Juego.add(ficha);
                return 1;
            }
            else if (ficha.getLado2() == this.Valor_Inicial()){
                Tablero_Juego.add(0,ficha);
                return 0;
            }
        }
     return -1;
    }
    public int AgregarFicha(Ficha ficha, int lado){
        switch(lado){
            case 0:
                System.out.println(Tablero_Juego);
                Tablero_Juego.add(0,ficha);
                break;
                
            case 1:
                System.out.println(Tablero_Juego);
                Tablero_Juego.add(ficha);
                break;
        }
        return lado;
    }
    
    
    
}
