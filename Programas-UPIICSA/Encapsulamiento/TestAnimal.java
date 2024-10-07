package Encapsulamiento;
/*Clase "Animal"
 Atributos: especie, edad, peso.
 Crea un constructor que inicialice todos los atributos.
 Usa encapsulamiento para que la edad no pueda ser menor que 0 y el peso solo pueda ser positivo.
 Añade un método para mostrar información del animal*/

 //Autor: Samperio Ávalos José Ángel

public class TestAnimal{
    public static void main(String[] args){
        Animal a = new Animal("Jirafa", 5, 800);
        System.out.println(a);
        Animal b = new Animal("No identificado", -5, -4);
        System.out.println(b);
    }
}

class Animal{
    private String especie;
    private int edad;
    private double peso;

    public void setEspecie(String value){
        especie=value;
    }

    public String getEspecie(){
        return especie;
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

    public void setPeso(double value){
        if(peso<1){
            peso=1;
        }
        else{
            peso=value;
        }
    }

    public double getPeso(){
        return peso;
    }

    public Animal(){}

    public Animal(String a1, int a2, double a3){
            setEspecie(a1);
            setEdad(a2);
            setPeso(a3);
    }

    @Override
    public String toString(){
        return String.format("Especie: %s"+"\n"+"Edad: %d anios"+"\n"+"Peso: %.2f kg"+"\n", especie, edad, peso);
    }
}