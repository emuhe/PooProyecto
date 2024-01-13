/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.proyectopoofx;

/**
 *
 * @author Deeje
 */
public class FichaComodin extends Ficha
{
    public FichaComodin()
    {
        super(-1, -1);
    }

    //setters
    public void setLado1(int v)
    {
        this.lado1 = v;
    }
    public void setLado2(int v)
    {
        this.lado2 = v;
    }

    //toString
    @Override
    public String toString()
    {
        return "*" + super.toString() + "*";
    }
    @Override
    public boolean esComodin(){
    return true;}
}