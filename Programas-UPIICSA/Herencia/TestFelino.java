package Herencia;
public class TestFelino{
    public static void main(String[] args){
        Gatito tom=new Gatito("Gris", "Russian Blue");
        System.out.println(tom);
        System.out.println(tom.maullar());
    }
}

class Felino{
    protected String color;
    protected String raza;

    public void setColor(String value){
        color=value;
    }

    public void setRaza(String raza){
        this.raza=raza;
    }
    
    //Constructor sobrecargado
    public Felino(String s1, String s2){
        setColor(s1);
        setRaza(s2);
    }

    protected String maullar(){
        return "El felino maulla";
    }

    @Override
    public String toString(){
        return String.format("Felino[Color: %s, Raza: %s]", color, raza);
    }
}

//extends implica herencia
class Gato extends Felino{
    //Un constructor de una clase derivada manda a llamar al constructor default de su padre por defecto salvo que se indique lo contrario
    public Gato(String color, String raza){
        //El super hace que al invocar el constructor de su padre seleccione el sobrecargado en lugar del constructor default
        super(color, raza);
        System.out.println("Se crea un felino domestico...");
    }
}

//extends implica herencia
class Gatito extends Gato{
    public Gatito(String color, String raza){
        super(color, raza);
        System.out.println("Se creo un tierno gatito...");
    }
}