
package ec.edu.espol;

import java.util.ArrayList;

public class Jugador {
    private String nombre;
    private ArrayList<Ficha> mano;

    public Jugador(String n, ArrayList<Ficha> mano){
        this.nombre = n;
        this.mano = mano;
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
