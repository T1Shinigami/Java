package Encapsulamiento;
/*Clase "Rectángulo"
Atributos: longitud, ancho.
Crea un constructor que reciba ambos valores.
Usa encapsulamiento para controlar que longitud y ancho sean valores positivos.
Implementa métodos para calcular el área y modificar los valores. */

//Autor: Samperio Ávalos José Ángel

public class TestRectangulo {
    public static void main(String[] args) {
        Rectangulo r = new Rectangulo(10, 4);
        System.out.println(r);
        r.calcularArea();
        r.setLongitud(5);
        r.setAncho(2);
        System.out.println(r);
        r.calcularArea();
    }
}

class Rectangulo{
    private double longitud;
    private double ancho;

    public void setLongitud(double value){
        if(value<1){
            longitud=0;
        }
        else{
            longitud=value;
        }
    }

    public double getLongitud(){
        return longitud;
    }

    public void setAncho(double value){
        if(value<1){
            ancho=0;
        }
        else{
            ancho=value;
        }
    }

    public Double getAncho(){
        return ancho;
    }

    public void calcularArea(){
        System.out.printf("Area del rectangulo: %.2f"+"\n\n", longitud*ancho);
    }

    public Rectangulo(){}
    public Rectangulo(double a1, double a2){
        setLongitud(a1);
        setAncho(a2);
    }

    @Override
    public String toString(){
        return String.format("Longitud: %.2f cm"+"\n"+"Ancho: %.2f cm", longitud, ancho);
    }
}