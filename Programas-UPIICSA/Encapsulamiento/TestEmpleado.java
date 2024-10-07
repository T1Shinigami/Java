package Encapsulamiento;
/*Atributos: nombre, sueldoBase, horasExtras.
Crea un constructor que inicialice nombre y sueldoBase.
Implementa métodos para calcular el sueldo total, considerando que las horas extras se pagan a
una tasa mayor. */

/*"Las horas extras se deben pagar al doble de las horas regulares"
   Si tu empresa requiere que trabajes más de esas nueve horas extra, debe pagarte el triple por hora trabajada 
   Fuente: https://www.elfinanciero.com.mx/mis-finanzas/2023/04/30/como-se-deben-pagar-las-horas-extras-en-mexico-esto-dice-la-ley/   */

//Autor: Samperio Ávalos José Ángel

public class TestEmpleado{
    public static void main(String[] args){
        Empleado e = new Empleado("Goku", 12000);
        System.out.println(e);
        e.sethorasExtras(5);
        e.sueldoTotal();
    }
}

class Empleado{
    private String nombre;
    private double sueldoBase;
    private int horasExtras;

    public void setNombre(String value){
        nombre=value;
    }

    public String getNombre(){
        return nombre;
    }

    public void setsueldoBase(double value){   
        if(value<1){
            sueldoBase=0;
        }
        else{
            sueldoBase=value;
        }
    }

    public double getSueldoBase(){
        return sueldoBase;
    }

    public void sethorasExtras(int value){
        if(value<1){
            horasExtras=0;
        }
        else{
            horasExtras=value;
        }
    }

    public int gethorasExtras(){
        return horasExtras;
    }

    public void sueldoTotal(){
        double sueldoTotal;
        if(horasExtras<1){
            sueldoTotal=sueldoBase;
        }
        else{
            if(horasExtras<10){
                sueldoTotal=sueldoBase+((((sueldoBase/30)/8)*2)*horasExtras);
            }
            else{
                sueldoTotal=sueldoBase+((((sueldoBase/30)/8)*2)*9)+((((sueldoBase/30)/8)*3)*(horasExtras-9));
            }
        }
        System.out.printf("\nEl sueldo total es de: %.2f", sueldoTotal);
    }

    public Empleado(){}
    public Empleado(String a1, double a2){
        setNombre(a1);
        setsueldoBase(a2);
    }

    @Override
    public String toString(){
        return String.format("Nombre del empleado: %s"+"\n"+"Sueldo base: %.2f"+"\n", nombre, sueldoBase);
    }
}