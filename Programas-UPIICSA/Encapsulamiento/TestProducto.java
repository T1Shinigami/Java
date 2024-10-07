package Encapsulamiento;
/*Atributos: nombre, precio, stock.
Crea un constructor que inicialice todos los atributos.
Usa métodos para consultar el precio, aumentar o disminuir el stock y modificar el precio si el stock
cae por debajo de cierto límite. */

//Autor: Samperio Ávalos José Ángel

public class TestProducto{
    public static void main(String[] args) {
        Producto p = new Producto("Mochila", 500, 12);
        System.out.println(p);
        System.out.printf("Precio del producto: $%.2f"+"\n",p.getPrecio());
        p.aumentarStock(1);
        p.disminuirStock(2, 12, 400);
    }
}

class Producto{
    private String nombre;
    private double precio;
    private int stock;

    public void setNombre(String value){
        nombre=value;
    }

    public String getNombre(){
        return nombre;
    }

    public void setPrecio(double value){   
        if(value<1){
            precio=0;
        }
        else{
            precio=value;
        }
    }

    public double getPrecio(){
        return precio;
    }

    public void setStock(int value){
        if(value<1){
            stock=0;
        }
        else{
            stock=value;
        }
    }

    public int getStock(){
        return stock;
    }

    public void aumentarStock(int value){
        if(value>0){
            stock=stock+value;
        }
        System.out.printf("Aumentando el stock, nuevo valor del stock: %d"+"\n", stock);
    }

    public void disminuirStock(int value, int limite, double nuevo){
        if(value>0){
            stock=stock-value;
            System.out.printf("Disminuyendo el stock, nuevo valor del stock: %d"+"\n", stock);
        }
        if(stock<limite){
            this.setPrecio(nuevo);
            System.out.printf("El valor del stock ha caido debajo del limite, valor del nuevo stock: %d"+"\n"+"Nuevo precio: %.2f", stock, nuevo);
        }
        
    }

    public Producto(){}

    public Producto(String a1, double a2, int a3){
        setNombre(a1);
        setPrecio(a2);
        setStock(a3);
    }

    @Override
    public String toString(){
        return String.format("Nombre del producto: %s"+"\n"+"Precio: $%.2f"+"\n"+"Stock: %d"+"\n", nombre, precio, stock);
    }
}