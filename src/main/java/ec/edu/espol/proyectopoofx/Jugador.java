/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.proyectopoofx;

/**
 *
 * @author Deeje
 */
import java.util.ArrayList;

public class Jugador {
    private String nombre;
    private ArrayList<Ficha> mano;
    private boolean Jreal;

    public Jugador(String n, ArrayList<Ficha> mano, boolean tipoj){
        this.nombre = n;
        this.mano = mano;
        Jreal = tipoj;
    }
    
    public Ficha getFicha(int indice){
        if(indice < mano.size()) {
            return mano.get(indice);
        }
        else{
            return null;
        }
    }
    
    public void removerFicha(Ficha f){
        mano.remove(f);
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public void imprimirMano(){
        for(int i = 0; i < mano.size();i++){
            System.out.print(mano.get(i).toString());
            if(i < mano.size() - 1){
                System.out.print(" - ");
            }
        }
    }
    
    public ArrayList<Ficha> getMano(){
        return mano;
    }
}