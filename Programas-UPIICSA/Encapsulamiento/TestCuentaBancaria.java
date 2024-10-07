package Encapsulamiento;
/*Atributos: titular, saldo.
Usa un constructor para inicializar titular y saldo en cero.
Implementa métodos para depositar y retirar dinero, verificando que no se retire más del saldo
disponible (uso de encapsulamiento para controlar el saldo). */

//Autor: Samperio Ávalos José Ángel

public class TestCuentaBancaria{
    public static void main(String[] args) {
        CuentaBancaria cb = new CuentaBancaria("Mark Elliot Zuckerberg");
        System.out.println(cb);
        cb.depositar(12000);
        cb.retirar(2000);
        cb.retirar(10001);
    }
}

class CuentaBancaria{
    private String titular;
    private double saldo;

    public void setTitular(String value){
        titular = value;
    }
    
    public String getTitular(){
        return titular;
    }

    public void setSaldo(double value){
        if(value<1){
            saldo=0;
        }
        else{
            saldo=value;
        }
    }

    public double getSaldo(){
        return saldo;
    }

    public void depositar(double value){
        saldo=saldo+value;
        System.out.printf("Deposito realizado de $%.2f, nuevo saldo: $%.2f"+"\n", value, saldo);
    }

    public void retirar(double value){
        if((saldo-value)>=0){
            saldo=saldo-value;
            System.out.printf("Retirando $%.2f, nuevo saldo: $%.2f"+"\n", value, saldo);
        }
        else{
            System.out.printf("Retirando $%.2f..."+"\n"+"No cuenta con saldo suficiente para realizar ese retiro, se mantiene con $%.2f de saldo"+"\n", value, saldo);
        }
    }

    public CuentaBancaria(){}

    public CuentaBancaria(String a1){
        setTitular(a1);
        setSaldo(-10);
    }

    @Override
    public String toString(){
        return String.format("Titular: %s"+"\n"+"Saldo: $%.2f"+"\n", titular, saldo);
    }
}