package _1_Obiekty;

public class Obiekty_1 {

    public static void main(String[] args) {
        //----KLASY METODY I OBIEKTY-----
        /*
        metody i pola static sa zwiazane z klasa a nie jej obiektem
        Obiekt jest naturalna reprezentacja klasy, przechowuje informacje
         o zmiennych oraz mozemy sie do nich odwolac, mozemy za pomoca
         obiektow wywolac metody jej klasy

        */
        System.out.println("-1-");
        Punkt punkt1 = new Punkt();
        punkt1.wspX = 10;
        punkt1.wspY = 20;
        System.out.println("Wspolrzedne punktu to: "+punkt1.wspX+" "+punkt1.wspY);

        System.out.println("\n"+"-2-"); //wlasciwy sposob dostepu do pol (zapis odczyt)
        Punkt punkt2 = new Punkt();
        punkt2.ustawX(10);
        punkt2.ustawY(20);
        System.out.println("Wspolrzedne punktu to: "+punkt2.dajX()+" "+punkt2.wspY);

        System.out.println("\n"+"-3-");
        int[][] punkty = new int[3][2];
        punkty[0][0] = 1;
        punkty[0][1] = 5;
        punkty[1][0] = 2;
        punkty[1][1] = 6;
        punkty[2][0] = 3;
        punkty[2][1] = 7;
        Punkt[] punktyKlasy = new Punkt[3];

        for(int i = 0; i < punkty.length; i++){
            punktyKlasy[i]=new Punkt();
            punktyKlasy[i].ustawX(punkty[i][0]);
            punktyKlasy[i].ustawY(punkty[i][1]);
        }
        int i = 0;
        for(Punkt x : punktyKlasy){
            System.out.println("Punkt "+i+" x: "+x.dajX()+" y: "+x.dajY());
            i++;
        }

        //--------------------METODY-------------------------------

        System.out.println("\n"+"METODY");

        //Przeciazanie metod - mozemy nazwyac metody tak samo jesli przyjmuja
        // inne typy zmiennych (to co zwracaja NIE MA ZNACZENIA!)

        System.out.println("-1-");
        Punkt punkt3 = new Punkt();
        punkt3.ustawX(15);
        punkt3.ustawY(3);
        System.out.println("Klasa.odejmujLiczby(x,y) : "+Punkt.odejmujLiczby(10,7));
        //przekazuje tutaj zmienne poprzez WARTOSC !
        //zmienne proste utworzone w metodzie znikaja po jej zakonczeniu
        //wywoluje metode za pomoca klasy poniwaz jest STATYCZNA

        System.out.println("\n"+"-2-");
        System.out.println("KLASA.sumujXY(obiekt.akcesorX(), obiekt.ackesorY())) : "+
                Punkt.odejmujLiczby(punkt3.dajX(),punkt3.dajY()));
        //tutaj wykorzystje pobranie wartosci z akcesorow i wysalnie ich do metody


        System.out.println("\n"+"-3-");
        System.out.println("obiekt.sumujXY(oiekt)) : "+punkt3.sumujXY(punkt3));
        /*
        teraz korzystam z metody przyjmujacej obiekt na ktorym wewnatrz
         metody korzysta z akcesorow
        Motoda bez sensu poniewaz moge uzyc slowka this. i odniesc sie
         do pol obiektu na ktorym wywolywana jest metoda !


        WYSYLAM REFERENCJE ! - jest to KOPIA adresu obieku, jesli zmienie wartosci
         pol obiektu w metodzie ktora na nim operuje - zmiany pozostana
        Referencja przyjeta przez metode moze zostac zmieniona przez co nie bedzie
         wskazywala juz na ten sam obiekt ktory wyslalismy lecz mozemy to zablokowac
         przyjmujac zmienna obiektu final! int sumujXY(final Punkt pkt)
        */

        //test referencji
        System.out.println("\n"+"-4-");
        Punkt punkt4 = new Punkt();
        punkt4.ustawX(77);
        Punkt.zwiekszX(punkt4);
        System.out.println(punkt4.dajX());

        System.out.println("\n"+"-5-");
        System.out.println("obiekt.sumujXY() : "+punkt3.sumujXY());//wykorzystam zmienne w obiekcie
        //metoda nie przyjmuje wartosci tylko zwraca sume pol obiektu
        // majac do nich dostep dzieki wywolaniu jej na konktetnym obiekcie
        // z ustalonymi polami, wykorzystje this.
        //metoda moze nazywac sie tak sama jak inna jesli przyjmuje inna ilosc paramtrow
        // lub inny ich rodzaj


        //-------------------Konstruktory------------------------

        System.out.println("\n"+"Konstruktory");
        /*
        Konstruktor nie okresla zwracanego typu, nazwa identyczna jak nazwa klasy
        Sluzy glownie do nadanie wartosci pol podczas tworzenia obiektu
         moga one wykonywac operacje jak i wywolywac metody

        W pierwszej kolejnosci wywolywany jest konstruktor bezparamtrowy klasy
         nadrzednej ! tzn w kazdym konstrukotrze (niewazne z jaka iloscia param.)
         na poczatku jest niejawna instukcja super();
                                                                          !
        Dobra praktyka jest tworznie konstrukotra bezparamtrowego z nadanymi wartosciami
         aby w przypadku proby dostania sie do nich nie otrzymac wyjatku
         NullPointerException !

        Moge tworzyc tablice obiektow:
        Punkt2[] pkt = new Punkt2[2];
        Punkt2[0] = new Punkt2(10,20);
        Punkt2[1] = new Punkt2(22,33);
        */

        Punkt2 pkt1 = new Punkt2(11,22); //slowo new wywoluje konstuktor
        /*
        Strworzylem konstruktor przyjmajacy 2 parametry i ustawiacy wartosc
         pol obiektu.
        w przypadku obiektu bez paramtrow Punkt2 pkt1 = new Punkt2(); musze
         stworzyc takze konstruktor bezparametrowy poniewaz ten z parametrami
         automatycznie usuwa ten standardowy (niewidoczny) tworzeony automatycznie
         przez klase
        */

        Punkt2 pkt2 = new Punkt2(pkt1);//wykorszytuje konstruktor kopiujacy ktory
        // przyjmuje inny obiekt i korzysta z jego pol do przypisania pol nowemu
        // obiektowi Punkt2(Punkt2 pkt){this.x = pkt.x; this.y = pkt.y;}
        System.out.println("-1-");
        System.out.println(pkt2.x + " " + pkt2.y);


    }
}

class Punkt{
    int wspX;
    int wspY;
    void ustawX(int x){
        this.wspX = x;
    }
    void ustawY(int y){
        this.wspY = y;
    }
    int dajX(){
        return wspX;
    }
    int dajY(){
        return wspY;
    }

    static int odejmujLiczby(int x, int y){ //metoda statyczne - moge ja wywolac
        // z uzyciem nazwy klasy Punkt.odejmujLiczby(liczba1, liczba2);
        return x-y;
    }

    int sumujXY(){
        return this.wspX + this.wspY; //korzystam ze zmiennych obiektu
        //na ktorym zostaje wywolana metoda
    }
    int sumujXY(Punkt pkt){ //z wykorzystaniem obiektu
        return pkt.dajX()+pkt.dajY();
        //uzywam akcesrow na obiekcie na ktorym zostala wywolana metoda
    }

    static void zwiekszX(Punkt pkt){
        pkt.ustawX(pkt.dajX()+1);
    }
}

class Punkt2{
    int x;
    int y;
    Punkt2(){
        this.x = 0;
        this.y = 0;
    } //konstruktor domyslny bezparamtrowy
    //jest on generowany automatycznie i usuwany jesli dodamy wlasny
    // z parametrami

    Punkt2(int x, int y){
        this.x = x;
        this.y = y;
    }

    Punkt2(Punkt2 pkt){//konstruktor kopiujacy
        this.x = pkt.x;
        this.y = pkt.y;
    }
}
