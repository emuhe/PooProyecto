/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.proyectopoofx;

import java.io.File;
import java.util.ArrayList;
import javafx.scene.image.Image;

/**
 *
 * @author Deeje
 */
public class ImagenesDomino {
    private ArrayList<Image> Cara;
    public ImagenesDomino(){
        Cara = new ArrayList<>();
        File file;
        Image image;
        for(int i = 1;i<7;i++){
            file = new File("src/Piezas_Domino/N_"+Integer.toString(i)+".png");
            image = new Image(file.toURI().toString());
            Cara.add(image);
        }
        file = new File("src/Piezas_Domino/N_-1.png");
        image = new Image(file.toURI().toString());
            Cara.add(image);
        System.out.println(Cara.size());
    }
    
    public Image getCara(int indice){        
        if(indice == -1){
            indice = 6;
        }
        
        return Cara.get(indice);
    }
    public int indice_actual(Image imagen_actual){
        return Cara.indexOf(imagen_actual);
    }
    
    //??????????
    //Perdon mister por esto :(
    public int indice_a_num(int indice){
        indice += 1;
        return indice;
    }
    
    public int num_a_indice(int num){
        if(num == -1 )
            return 6;
        else{
        return num-1;
        }
    }
    
        
    
}

//File opcion1_file = new File("src/Piezas_Domino/N_"+Integer.toString(1)+".png");
//                        Image opcion1_imagen = new Image(opcion1_file.toURI().toString());