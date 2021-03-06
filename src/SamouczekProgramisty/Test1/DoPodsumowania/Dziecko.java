package SamouczekProgramisty.Test1.DoPodsumowania;

public class Dziecko extends Ojciec {

    int a;
    static int zmiennaStatic = 10;

    @Override
    public String toString() {
        return "zmiinna a = "+a + super.toString();
    }

    void metoda(int a){
        super.metoda(10);
    }

    void metodaDziecka(){
        System.out.println("metoda dziecka");
    }

    public Dziecko() {
        //System.out.println();
        System.out.println("dziecko");

    }
    public Dziecko(int a){

        System.out.println("dziecko z param");
        this.a = a;
    }



    public static void main(String[] args) {
        Dziecko d = new Dziecko(2);
        Ojciec o = new Dziecko(2);
        Ojciec ojciec = new Ojciec();

        System.out.println(d.a);
        System.out.println(d.x);

        d.metodaOjca();
        o.metodaOjca();

        d.metodaDziecka();
        ((Dziecko) o).metodaDziecka();

        System.out.println(o);

        System.out.println("----------------");
        System.out.println(d.zmiennaStatic);
        Dziecko.zmiennaStatic = 20;
        System.out.println(d.zmiennaStatic);

    }
}
