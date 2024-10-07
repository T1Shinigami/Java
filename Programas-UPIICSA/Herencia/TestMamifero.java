package Herencia;
public class TestMamifero{
    public static void main(String[] args) {
        Humano h = new Humano(9, "ciudad", "aria");
        Delfin d = new Delfin(10, "mar", false);
        System.out.println(h);
        System.out.println(d);
    }
}

class Mamifero{
    protected int gestacion;
    protected String habitad;
    
    public Mamifero(){}
    public Mamifero(int i1, String s1){
        gestacion=i1;
        habitad=s1;
    }

    @Override
    public String toString(){
        return String.format("");
    }
}

class Humano extends Mamifero{
    protected String raza;

    public Humano(int gestacion, String habitad, String r){
        super(gestacion, habitad);
        raza=r;
    }
    @Override
    public String toString() {
        return String.format("Mamifero{ HUMANO[ raza: %s], gestacion: %d, habitad: %s }", raza, gestacion, habitad);
    }
}

class Delfin extends Mamifero{
    protected boolean usarSonar;
    
    public Delfin(int gestacion, String habitad, boolean s){
        super(gestacion, habitad);
        usarSonar=s;
    }

    @Override
    public String toString(){
        if(usarSonar==true){
            return String.format("Mamifero{DELFIN[ SI usa sonar], gestacion: %d, habitad: %s }", gestacion, habitad);
        }
        else{
            return String.format("Mamifero{DELFIN[ NO usa sonar], gestacion: %d, habitad: %s }", gestacion, habitad);
        }
        
    }
}