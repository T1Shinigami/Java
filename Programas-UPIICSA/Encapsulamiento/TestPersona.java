package Encapsulamiento;
/*Clase "Persona"
Atributos: nombre, edad, rfc.
Usa constructores para inicializar los valores.
Implementa métodos para mostrar y modificar los atributos usando encapsulamiento.*/

public class TestPersona{
    public static void main(String[] args){
        Persona p = new Persona("Juan Carlos Martínez Pérez", 16, "MAPE780514H23");
        System.out.println(p);
        p.setNombre("Juan Carlos Lopez Hernandez");
        p.setEdad(18);
        p.setRfc("LOHJ901023HDFRZN03");
        System.out.printf("Nombre: %s"+"\n", p.getNombre());
        System.out.printf("Edad: %d"+"\n", p.getEdad());
        System.out.printf("RFC: %s"+"\n", p.getRfc());
    }
}


class Persona{
    //Atributos
    private String nombre;
    private int edad;
    private String rfc;


    //getters y setters (encapsulamiento)
    public void setNombre(String value){
        nombre=value;
    }


    public String getNombre(){
        return nombre;
    }


    public void setEdad(int value){
        if(value<=0){
            edad=0;
        }
        else{
            edad=value;
        }
    }


    public int getEdad(){
        return edad;
    }


    public void setRfc(String value){
        rfc=value;
    }


    public String getRfc(){
        return rfc;
    }
    

    //ctor default
    public Persona(){}


    //ctor sobrecargado
    public Persona(String a1, int a2, String a3){
        setNombre(a1);
        setEdad(a2);
        setRfc(a3);
    }

    
    @Override
    public String toString(){
        return String.format("Nombre: %s"+"\n"+"Edad: %d"+"\n"+"RFC: %s"+"\n", nombre, edad, rfc);
    }
}