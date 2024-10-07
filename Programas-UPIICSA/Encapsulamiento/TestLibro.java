package Encapsulamiento;
/*Atributos: titulo, autor, numeroPaginas.
Crea un constructor para inicializar estos atributos.
Usa métodos para consultar el título y el autor.
Implementa encapsulamiento para controlar la modificación del número de páginas solo si el valor
es mayor que cero. */

//Autor: Samperio Ávalos José Ángel

public class TestLibro{
    public static void main(String[] args) {
        Libro l = new Libro("El libro de Bill", "Bill", 212);
        System.out.println(l);
        System.out.printf("\nConsultando titulo del libro: %s", l.getTitulo());
        System.out.printf("\nConsultando nombre del autor: %s", l.getAutor());
        l.setNumeroPaginas(-240);
        System.out.printf("\nNuevo numero de paginas: %d", l.getNumeroPaginas());;
    }
}

class Libro{
    private String titulo;
    private String autor;
    private int numeroPaginas;


    public void setTitulo(String value){
        titulo=value;
    }

    public String getTitulo(){
        return titulo;
    }

    public void setAutor(String value){
        autor=value;
    }

    public String getAutor(){
        return autor;
    }

    public void setNumeroPaginas(int value){
        if(value>0){
            numeroPaginas=value;
        }
    }

    public int getNumeroPaginas(){
        return numeroPaginas;
    }

    public Libro(){}

    public Libro(String a1, String a2, int a3){
        setTitulo(a1);
        setAutor(a2);
        setNumeroPaginas(a3);
    }

    @Override

    public String toString(){
        return String.format("Titulo: %s"+"\n"+"Autor: %s"+"\n"+"Numero de paginas: %d\n", titulo, autor, numeroPaginas);
    }
}