package Encapsulamiento;
/* Atributos: marca, modelo, año, kilometraje.
 Crea un constructor que inicialice todos los atributos.
 Implementa getters y setters para controlar el acceso a kilometraje (encapsulamiento).
 Añade un método para incrementar el kilometraje tras un viaje */

 //Autor: Samperio Avalos Jose Angel

public class TestCoche {
    public static void main(String[] args) {
        Coche c =new Coche("Lamborghini", "Diablo", 2013, 123);
        System.out.println(c);
        c.incrementarKilometraje(50);
        System.out.printf("\nEl kilometraje ha incrementado tras su viaje, el nuevo valor es: %.2f", c.getKilometraje());
    }
}

class Coche{
    private String marca;
    private String modelo;
    private int anio;
    private double kilometraje;


    public void setMarca(String value){
        marca=value;
    }
    

    public String getMarca(){
        return marca;
    }


    public void setModelo(String value){
        modelo=value;
    }


    public String getModelo(){
        return modelo;
    }


    public void setAnio(int value){
        if(value <= 0){
            anio=0;
        }
        else{
            anio=value;
        }  
    }


    public int getAnio(){
        return anio;
    }


    public void setKilometraje(double value){
        if(value <= 0){
            kilometraje=0;
        }
        else{
            kilometraje=value;
        }  
    }


    public double getKilometraje(){
        return kilometraje;
    }


    public Coche(){}

    public Coche(String a1, String a2, int a3, double a4){
        setMarca(a1);
        setModelo(a2);
        setAnio(a3);
        setKilometraje(a4);
    }

    @Override

    public String toString(){
        return String.format("Marca: %s"+"\n"+"Modelo: %s"+"\n"+"Anio: %d"+"\n"+"Kilometraje: %.2f km", marca, modelo, anio, kilometraje);
    }

    public void incrementarKilometraje(double incremento){
        kilometraje=kilometraje+incremento;
    }
}
