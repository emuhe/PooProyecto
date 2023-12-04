package ec.edu.espol;

import java.util.ArrayList;
import java.util.Scanner;

public class Juego {
    private ArrayList<Ficha> lineajuego;
    private ArrayList<Jugador> jugadores;
    public Juego(){
        lineajuego = new ArrayList<>();
        jugadores = new ArrayList<>();
    }
    public void agregarJugador(String nombre){

        Jugador nuevoJugador = new Jugador(nombre,Utilitaria.crearManoJugador());
        jugadores.add(nuevoJugador);
    }
    public int obtenerValorInicio(){
        return lineajuego.get(0).getLado1();
    }
    public int obtenerValorFinal(){
        return lineajuego.get(lineajuego.size() - 1).getLado2();
    }
    public void mostrarLinea(){
        for(int i = 0; i < lineajuego.size();i++){
            System.out.print(lineajuego.get(i).toString());
            if(i < lineajuego.size() -1){
                System.out.print(" - ");
            }

        }
    }
    public boolean agregarFichaLinea(Ficha f, Jugador j){
        Scanner scanner = new Scanner(System.in);
        if(f instanceof FichaComodin fc){
            int valor1;
            int valor2;
            if(lineajuego.isEmpty()) { //Si la linea esta vacia, pide que ingresen lado1 y lado2
                System.out.println("Es un comodin! Ingrese el numero del primer lado: ");
                valor1 = scanner.nextInt();
                fc.setLado1(valor1);
                System.out.println("Ingrese el numero del segundo lado: ");
                valor2 = scanner.nextInt();
                fc.setLado2(valor2);
            }
            else{ //Si la linea no esta vacia, se pide que decidan ingresar al inicio o final de la linea
                System.out.println("Seleccione a que lado quiere agregar:");
                String posicion = scanner.nextLine();
                if(posicion.equals("Inicio")){ //Se agrega al inicio
                    System.out.println("Ingrese el valor del lado 1:");
                    valor1 = scanner.nextInt();
                    fc.setLado1(valor1);
                    fc.setLado2(obtenerValorInicio());
                    lineajuego.add(0,fc);
                }
                else{ //Se agrega al final
                    System.out.println("Ingrese el valor del lado 2:");
                    valor2 = scanner.nextInt();
                    fc.setLado2(valor2);
                    fc.setLado1(obtenerValorFinal());
                    lineajuego.add(fc);
                }
            }
        }
        else{
            if(lineajuego.isEmpty()){
                lineajuego.add(f);
            }
            else {
                if (f.getLado1() == obtenerValorFinal()) {
                    lineajuego.add(f);
                } else if (f.getLado2() == obtenerValorInicio()) {
                    lineajuego.add(0,f);
                } else {
                    return false;
                }
            }
        }
        j.removerFicha(f);
        return true;
    }
    public boolean Turno(int i_jugador,Scanner scanner){
        System.out.println("\nTurno de " + jugadores.get(i_jugador).getNombre());
        jugadores.get(i_jugador).imprimirMano();
        System.out.print("\nSeleccione la ficha (Seleccione entre el 0 y el " + (jugadores.get(i_jugador).getMano().size()-1)+ "): ");
        int ind = scanner.nextInt();
        boolean obt = agregarFichaLinea(jugadores.get(i_jugador).getFicha(ind),jugadores.get(i_jugador));
        if(obt) System.out.println("Se agrego la ficha!");
        else {
            System.out.println("No se agrego! Perdio! :(");
            return false;
        }
        return true;
    }
    public boolean Turno(int i_jugador){
        for(Ficha ficha:jugadores.get(i_jugador).getMano()){
            if (ficha.getLado1() == obtenerValorFinal() || ficha.getLado2() == obtenerValorInicio()) {
                System.out.println(ficha);
                return agregarFichaLinea(ficha, jugadores.get(i_jugador));
            }
            else if(ficha instanceof FichaComodin fichanueva){
                int num1 = (int) (Math.floor(Math.random() * 2) + 1);
                   int num2 = (int) (Math.floor(Math.random() * 6) + 1);

                if(num1 == 1){
                       fichanueva.setLado1(num2);
                       fichanueva.setLado2(obtenerValorInicio());
                       lineajuego.addFirst(fichanueva);
                       jugadores.get(i_jugador).removerFicha(fichanueva);
                       System.out.println(fichanueva.toString());
                   }
                else{
                    fichanueva.setLado2(num2);
                    fichanueva.setLado1(obtenerValorFinal());
                    lineajuego.add(fichanueva);
                    jugadores.get(i_jugador).removerFicha(fichanueva);
                }
                return true;
            }
            }
        return false;
        }
}
