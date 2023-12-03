package ec.edu.espol;

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
}