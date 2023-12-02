package ec.edu.espol;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Juego juego = new Juego();
        System.out.println("Bienvenido a Domino!\nVas a jugar con alguien (1) o con la maquina (0)?");
        String tipoJuego = scanner.nextLine();
        System.out.println("Ingresa el nombre del primer jugador");
        String j1 = scanner.nextLine();
        juego.agregarJugador(j1);
        if(tipoJuego.equals("1")) {
            System.out.println("Ingresa el nombre del segundo jugador");
            String j2 = scanner.nextLine();
            juego.agregarJugador(j2);
            boolean continuar;
            do {
                continuar = juego.Turno(0, scanner);
                System.out.println("La linea de juego es: ");
                juego.mostrarLinea();
                if(continuar) {
                    juego.Turno(1, scanner);
                    System.out.println("La linea de juego es: ");
                    juego.mostrarLinea();
                }

            } while (continuar);
        }
        else{
            boolean continuar;
            do {
                juego.agregarJugador("Maquina");
                continuar = juego.Turno(0, scanner);
                if(continuar) {
                    continuar = juego.Turno(1);
                    System.out.println("La linea de juego es: ");
                    juego.mostrarLinea();
                }

            } while (continuar);
        }
        System.out.println("\nSe acabo el juego!");


    }
}
