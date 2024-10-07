package Encapsulamiento;
/*Clase "Círculo"
Atributos: radio.
Crea un constructor que inicialice el valor de radio.
Usa encapsulamiento para que el radio no sea negativo.
Implementa un método para calcular el área y modificar el valor del radio. */

//Autor: Samperio Ávalos José Ángel

public class TestCirculo {
    public static void main(String[] args) {
        Circulo c = new Circulo(4);
        System.out.println(c);
        c.calcularArea();
        c.setRadio(1);
        System.out.printf("Nuevo radio del circulo: %.2f cm"+"\n"+"Area del circulo: %.2f"+"\n", c.getRadio(), c.calcularArea());
    }
}

class Circulo{
    private double radio;

    public void setRadio(double value){
        if(value<1){
            radio=0;
        }
        else{
            radio=value;
        }
    }

    public double getRadio(){
        return radio;
    }

    public double calcularArea(){
        double pi=3.1416;
        return pi*radio*radio;
    }

    public Circulo(){}
    public Circulo(double a1){
        setRadio(a1);
    }

    @Override
    public String toString(){
        return String.format("Radio del circulo: %.2f cm"+"\n"+"Area del circulo: %.2f cm"+"\n", radio, calcularArea());
    }
}
