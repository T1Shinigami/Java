package Encapsulamiento;
/*Clase "Vehiculo"
Atributos: marca, modelo, velocidadMaxima.
Crea un constructor que inicialice todos los atributos.
Usa métodos para consultar la velocidad máxima y modificarla, verificando que no exceda ciertos
límites (encapsulamiento).
Añade un método para acelerar el vehículo, incrementando la velocidad hasta el máximo permitido. 

Auto mas rapido registrado: Bugatti Chiron Super Sport 300+ - 490,48 km/h
https://periodismodelmotor.com/los-35-coches-mas-rapidos-del-mundo/346491/
*/

//Autor: Samperio Ávalos José Ángel

public class TestVehiculo {
    public static void main(String[] args) {
        Vehiculo v = new Vehiculo("Lamborghini ", "Sesto elemento", 350);
        System.out.println(v);
        System.out.printf("Una consulta de la velocidad maxima: %d km"+"\n", v.getVelocidadMaxima());
        v.setVelocidadMaxima(110);
        System.out.printf("La velocidad maxima ha cambiado a %d"+"\n", v.getVelocidadMaxima());
        v.acelerarAlMaximo();
    }
}

class Vehiculo{
    private String marca;
    private String modelo;
    private int velocidadMaxima;

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

    public void setVelocidadMaxima(int value){
        if(value<1){
            velocidadMaxima=0;
        }
        else if(value>491){
            velocidadMaxima=0;
        }
        else{
            velocidadMaxima=value;
        }
    }

    public int getVelocidadMaxima(){
        return velocidadMaxima;
    }

    public void acelerarAlMaximo(){
        double velocidadActual=0;

        for(int i=0; i<velocidadMaxima; i++){
            velocidadActual=velocidadActual+1;
            if(velocidadActual==(velocidadMaxima/3)){
                System.out.printf("El auto acelera, ha alcanzado los %.2f km/h"+"\n", velocidadActual);
            }
            else if(velocidadActual==(velocidadMaxima/3)*2){
                System.out.printf("El auto acelera aun mas, ha alcanzado los %.2f km/h"+"\n", velocidadActual);
            }
            else if(velocidadActual==velocidadMaxima){
                System.out.printf("El auto alcanzo la aceleracion maxima! %.2f km/h", velocidadActual);
            }
        }
    }

    public Vehiculo(){}
    public Vehiculo(String a1, String a2, int a3){
        setMarca(a1);
        setModelo(a2);
        setVelocidadMaxima(a3);
    }

    @Override
    public String toString(){
        return String.format("Marca: %s"+"\n"+"Modelo: %s"+"\n"+"Velocidad maxima: %d"+"\n", marca, modelo, velocidadMaxima);
    }
}
