package Herencia;
import java.util.Scanner;

public class TestOtroAlgo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double calificaciones[] = new double[10];

        // Ingreso de calificaciones
        for (int i = 0; i < 10; i++) {
            System.out.printf("Ingrese la calificación %d: ", i + 1);
            calificaciones[i] = sc.nextDouble();
            //nextLine para string
        }

        // Inicialización de objetos Alumno
        Alumno[] alumnos = new Alumno[]{
            new Alumno("Ranma", "Herrera", 1012, calificaciones[0]),
            new Alumno("Jazmin", "Gomez", 9865, calificaciones[1]),
            new Alumno("Yuji", "Itadori", 8847, calificaciones[2]),
            new Alumno("Emiliano", "Morales", 7165, calificaciones[3]),
            new Alumno("Izuku", "Ruiz", 6551, calificaciones[4]),
            new Alumno("Juan", "Garcia", 5655, calificaciones[5]),
            new Alumno("Goku", "Castillo", 4564, calificaciones[6]),
            new Alumno("Maria", "Delgado", 3654, calificaciones[7]),
            new Alumno("Teemo", "Romero", 4432, calificaciones[8]),
            new Alumno("Pedro", "Torres", 3213, calificaciones[9]),
        };

        double aprovechamientoG = 0;
        int contadorAprobados = 0;
        int contadorReprobados = 0;
        double caliMin = 10;
        double caliMax = 0;

        for (int i = 0; i < 10; i++) {
            aprovechamientoG = aprovechamientoG + alumnos[i].getcalificacion();
            if (alumnos[i].getcalificacion() < 6) {
                contadorReprobados++;
            }
            contadorAprobados = 10 - contadorReprobados;

            if (alumnos[i].getcalificacion() < caliMin) {
                caliMin = alumnos[i].getcalificacion();
            }

            if (alumnos[i].getcalificacion() > caliMax) {
                caliMax = alumnos[i].getcalificacion();
            }
        }

        aprovechamientoG = aprovechamientoG / 10;
        int porcentajeA = contadorAprobados * 100 / 10;
        int porcentajeR = 100 - porcentajeA;

        System.out.printf("\nAprovechamiento general: %.2f", aprovechamientoG);
        System.out.printf("\nPorcentaje de aprobación: %d%%", porcentajeA);
        System.out.printf("\nPorcentaje de reprobados: %d%%", porcentajeR);
        System.out.printf("\nCalificación mínima: %.2f", caliMin);
        System.out.printf("\nCalificación máxima: %.2f", caliMax);

        for (int i = 0; i < 10; i++) {
            if (alumnos[i].getcalificacion() == caliMin) {
                System.out.println("\nAlumno con la peor calificación: " + alumnos[i]);
            }
            if (alumnos[i].getcalificacion() == caliMax) {
                System.out.println("\nAlumno con la mejor calificación: " + alumnos[i]);
            }
        }
        sc.close();
    }
}

class Alumno {
    protected String nombre;
    protected String apellidos;
    protected int boleta;
    protected double calificacion;

    public void setNombre(String value) {
        nombre = value;
    }

    public String getNombre() {
        return nombre;
    }

    public void setcalificacion(double value) {
        if (value >= 0) {
            calificacion = value;
        } else {
            calificacion = 0;
        }
    }

    public double getcalificacion() {
        return calificacion;
    }

    public void setApellidos(String value) {
        apellidos = value;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setboleta(int value) {
        if (value >= 0) {
            boleta = value;
        } else {
            boleta = 0;
        }
    }

    public int getboleta() {
        return boleta;
    }

    public Alumno() {
    }

    // Constructor sobrecargado
    public Alumno(String n, String a, int b, double c) {
        setNombre(n);
        setApellidos(a);
        setboleta(b);
        setcalificacion(c);
    }

    @Override
    public String toString() {
        return String.format("Boleta: %d, Nombre: %s, Apellidos: %s, Calificación: %.2f",
                boleta, nombre, apellidos, calificacion);
    }
}
