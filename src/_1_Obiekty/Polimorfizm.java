package _1_Obiekty;

import java.util.List;

public class Polimorfizm {
    public static void main(String[] args) {
        //Przyklad:
        String s1 = new String("napis1");
        Object o1 = new String("napis2");

        X[]tab = new X[2];
        tab[0] = new X1();
        tab[1] = new X2();

        for(X x : tab){
            x.zrobCos();
        }


        //---------2---------
        A obiekt = new B(); //przpisuje obiekt B do referecji typu A
        obiekt.x();//metoda wspolna
        //obiekt.y(); blad poniewaz refencja wskazyje na klase w ktorej
        // nie ma tej metody, mozna wykorzystac rzutowanie
        ((B)obiekt).y();


        //------Klasy abstrakcyjne----------
        /*
        -moga zawierac metody abstrakcyjne
        -moga zawierac stale (public static final)
        -moga zawierac swoje metody
        */
    }
}
interface X{
    public void zrobCos();
}
class X1 implements X{
    @Override
    public void zrobCos() {
        System.out.println("X1");
    }
}
class X2 implements X{
    @Override
    public void zrobCos() {
        System.out.println("X2");
    }
}
class XListy {
    public void doSomething1(List<String> list) {
        //Dzieki zastosowaniu List a nie ArrayList mam zabezpeczenie gdybym chcial
        // wyslac do niej ArrayList lub LinkedList
    }
}
//---------2---------
interface A{
    public void x();
}
class B implements A{
    @Override
    public void x() {

    }
    public void y(){

    }
}