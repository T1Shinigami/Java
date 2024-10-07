package Herencia;
public class TestPersona {
    public static void main(String[] args) {
        Alumno a = new Alumno();
        Profesor p = new Profesor(10008000);
        System.out.println(a);
        System.out.println(p);
    }
}

class Persona{
    protected String nombre;
    protected int edad;

    public void setNombre(String value){
        nombre=value;
    }

    public void setEdad(int value){
        edad=value;
    }

    public Persona(){}

    public Persona(String s1, int e1){
        setNombre(s1);
        setEdad(e1);
    }

    @Override
    public String toString(){
        return String.format("");
    }
}

class Alumno extends Persona{
    String boleta;

    public Alumno(){
        System.out.println("Se crea alumno");
    }

    @Override
    public String toString(){
        return String.format("");
    }
}

class Profesor extends Persona{
    int numEmpleado;

    public Profesor(int numEmpleado){
        this.numEmpleado=numEmpleado;
    }
    @Override
    public String toString(){
        return String.format("Se crea profesor de edad %d con clave %d", edad, numEmpleado);
    }
}
