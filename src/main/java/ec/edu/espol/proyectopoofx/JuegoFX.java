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
            if (!ficha.esComodin() || (ficha.getLado1()!= -1 && ficha.getLado2() != -1)){
            Tablero_Juego.add(ficha);
            return 1;
            }
            else{
            return -1;
            }
        }
        else{
            if(ficha.esComodin() && ficha.getLado1() != -1 && ficha.getLado2() != -1){
                return 3;
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
    public void AgregarFicha(Ficha ficha, boolean vaInicio){
        if(vaInicio){
            Tablero_Juego.add(0,ficha);
        }
        else{
            Tablero_Juego.add(ficha);    
        }
        
    }
    public void mostrarLinea(){
        for(int i = 0; i < Tablero_Juego.size();i++){
            System.out.print(Tablero_Juego.get(i).toString());
            if(i < Tablero_Juego.size() -1){
                System.out.print(" - ");
            }

        }
        System.out.print("\n");
    }
    
    public Ficha AgregarPC_Inicio(){
        for(Ficha ficha: Jugadores.get(1).getMano()){
            if(ficha.lado2 == this.Valor_Inicial()){
                Tablero_Juego.add(0,ficha);
                System.out.println("Agregado al Inicio!");
                return ficha;
                
              
            }
        }
        return null;
    }
    public Ficha AgregarPC_Final(){
        for(Ficha ficha: Jugadores.get(1).getMano()){
            if(ficha.lado1 == this.Valor_Final()){
                Tablero_Juego.add(ficha);
                System.out.println("Agregado al Final!");
                return ficha;
                
                
              
            }
        }
        return null;
    }
    public Ficha AgregarPC_Comodin(){
        for(Ficha ficha: Jugadores.get(1).getMano()){
            if(ficha.esComodin()){
                FichaComodin comodin_pc = (FichaComodin) ficha;
                int num2 = (int) (Math.floor(Math.random() * 6) + 1);
                switch((int) (Math.floor(Math.random() * 2) + 1)){
                    case 1:
                        comodin_pc.setLado1(num2);
                        comodin_pc.setLado2(this.Valor_Inicial());
                        comodin_pc.vaInicio = true;
                        Tablero_Juego.add(0,comodin_pc);
                    case 2:
                        comodin_pc.setLado2(num2);
                        comodin_pc.setLado1(this.Valor_Final());
                        comodin_pc.vaInicio = false;
                        Tablero_Juego.add(comodin_pc);
                    
            }   
                
                return ficha;
            }
                
              
            }
        return null;
    }
    
    
}
