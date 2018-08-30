package Podsumowanie;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Podsumowanie {
    public static void main(String[] args) {
        /*
        -----SKTORY KLAWISZOWE-----

        alt + 1 - ukrycie okienka struktury projektu
        alt + strzalka - przleczanie pomiedy zakladkami
        alt + ins - dodanie pliku
        alt + del - cofniecie usuniecia
        ctrl + y - usuniecie lini


        //skok kursora
        ctrl + lewo/prawo - skok o cale slowo
        ctrl + gora/dow - skroll gora dol

        shift + enter - enter i skok do nowej linii
        ctrl + enter - enter ponizej zostajac w tej samej linii
        ctrl + alt + enter - enter linie wyzej, ide do tej linii

        shift + tab - usuniecie wciecia
        ctrl + del - usuniecie slowa lub wszytkich pustych znako
         i skok do liini wyzej

        //zaznaczaanie
        shit + strzalka - zaznaczenie pojedynczego znaku
        shift + ctrl + stralka - zaznaczenie wyrazu


        ctrl + spacja - podpowiedz
        ctrl + j - podpowiedzi dla klasy
        fori + tab - petla for



        -----OGOLNE-----

        Klasa - projekt/foremka
        Obiekt/instancja - produkt

        Maszyna wirtualna pomaga zarzadzac pamiecia

        Wersja programu X.Y.Z
        X-wersja
        Y-funkcjonalonsci
        Z-latki

        JVM - maszyna witrualna javy np Oracle

        JRE - maszyna wirtualna tylko dla uruchamiania programow

        JDK - zestaw narzedzi zawierajacy takze kompilator javac

        IDE (ang. Integrated Development Environment)



        -----ZMIENNE PROSTE-----
        */

        int zmiennaInt = 123;
        //zakres +/- 2,147,483,647
        int zmiennaInt2 = 123_123;
        //zapis z literalem, pokaze normalnie, ulatwia czytelnosc

        int liczba = 1234_123;//liczba z literalem - ulatwia czytelnosc
        //pokaze liczbe normalnie
        int liczba2 = -0xFF00;//w systemie szesnastkowym
        int liczba3 = 0777;//w systemie osemkowym (511)

        long liczba5 = 1232455;//nie musze pisac z koncowka L
        long liczba4 = 123L;//da informacje ze bedzie to typ long
        // mozliwe jest uzycie "l" lecz zalecane jest "L"

        float liczba6 = 123.34F;//musi byc "F" lub "f"

        double liczba7 = 213.45;//opcjonalnie z d lub D

        short liczba8 = 234;

        boolean prawdaFalsz = true;
        //zakres true/false

        String napis = "asd\n123";

        //-----
        //boxing unboxing

        //Boxing jest to przypisywanie zmiennej prostej do obiektowej
        Integer zmiennaIntegerBox = 12;

        //W przypadku typow prostych jest wykonywany automatyczny autoboxing

        int liczbaBox1 = new Integer(12);
        //operacja odwrotna czyli autounboxing
        //przypisywanie do zmiennej prostej zmiennej obiektowej


        //Zmienne finalne
        final int LICZBA_FINAL;
        LICZBA_FINAL = 12;
        /*
        liczba finalana musi miec zadeklarowana wartosc chyba ze:
         -jej przypisanie wartosci jest w konstruktorze klasy
         -jest zadeklarowana lokalnie(w metodzie)

        wartosc liczby finalnej NIE MOZNA zmienic



        -----ZMIENNA STRING-----
        */
        String jakisString = "costam";
        String jakisStringZLiczba = "costam123";
        String laczonyString = "costam123" + 123;
        String laczonyString2 = laczonyString + 345;

        String stringZInta = String.valueOf(123);

        //Standardowo String nie moze miec przypisane zmiennej int
        // lecz jesli zrobie to z konkatenacja + np x + "" to wszystko
        // zostanie przypisane do zmiennej String




        /*
        -----ZMIENNA INTEGER-----
        */
        Integer integer = 123;
        Integer integer1 = new Integer("123123");
        Integer integer2 = new Integer(12345);

        String liczbaString = "123";

        int intZeString = Integer.parseInt(liczbaString);
        Integer IntegerZeString = Integer.parseInt(liczbaString);

        Integer.valueOf(123);



        /*
        -----METODY-----

        Metoda - worek do grupujacy zestaw instrukcji. Tworzymy je
         aby zaoszczedzic pisania kodu oraz poprawic jego czytelnosc

        Metoda moze byc zwykla(odnoaszaca sie do instancji klasy) lub
         statyczna(odnoszaca sie do klasy)
         */
class Wew1{/////////////////////////////////////////////////////
        public String metodaDajacaString(int liczba){
            return String.valueOf(liczba);
        }
        public int metodaDajacaInt(String napis){
            return Integer.parseInt(napis);
        }
}////////////////////////////////////////////////////////////////

        /*
        Metody deklaruje TYLKO w klasie (nie w innych metodach)

        Metody nie powinny przyjmowac duzej ilosc argumentow ("code smell")

        Metode moge wywolac na obiekcie lub bezposrenio
         mojObiekt.mojaMetoda();
         mojaMetoda();

        W statycznej metodzie(np main) NIE MOGE odwolac sie bezposrenio
         do niestatycznej metody!!

        Metoda nie zwracajac nic void moze posiadac slowo return ale
         nie moze nic zwracac
         */
class Wew2{/////////////////////////////////////////////////////
        public void metodaNicNieZwracajaca(){
            return;
        }
}////////////////////////////////////////////////////////////////
        /*

        -----
        Przeciazenie metody (overload) jest gdy ta sama klasa
         ma kilka metod o tej samej nazwie ale przyjmujace inne
         parametry

        public void metoda(){}
        public void metoda(int a){}



        -----WPROWADZANIE DANYCH-----
        */
class Wew3{/////////////////////////////////////////////////////
        void start(){
            String imie;
            List<String> imiona = new ArrayList<>();
            Scanner wejscie = new Scanner(System.in);
            do{
                imie = wejscie.nextLine();
                if(!imie.equals("-"))
                    imiona.add(imie);

            }while (!imie.equals("-"));

            //lub w samym while
            while (true){
                imie = wejscie.nextLine();
                if(imie.equals("-"))
                    break;
                imiona.add(imie);
            }

            //iny przyklad
            while (true){
                try {
                    imie = wejscie.nextLine();
                    break;
                }
                catch (InputMismatchException e){
                    wejscie.next();
                }
            }
            if(imie.equals("Kamil")){
                throw new IllegalArgumentException("jest juz kamil!");
            }
        }
}//////////////////////////////////////////////////////////////
        /*



        -----PAKIETY-----

        Słuza do grupowania i informowania gdzie znajduje sie klasa/interfejs
        /typ wyliczeniowy/adnotacja

        Przyjato ze uzywa sie odwrotnej nazwy domenowej

        package pl.SamouczekProgramisty.Folder1;
         Plik klasy znajduje sie w folderze "Folder1" a on w folderze
         "SamouczekProgramisty" a on w "pl"

        import pl.SamouczekProgramisty.Folder1.MojaKlasa;
        importuje klase MojaKlasa z pakietu ->Folder1->
         ->SamouczekProgrmisty->pl
         Mam dostep dzieki temu takze do wszystkich jej statycznych metod



         -----KLASY-----

        Sluza do grupowania atrybutow/pol i metod

        Klasa moze miec TYLKO modyfikator public lub zaden!

        //Tworzenie instancji klasy

        Podsumowanie obiekt = new Podsumowanie();

        Aby operwac na obiekcie musze przypisac cos do jej referencji
         np wywoluja konstruktor klasy slowem new

        Slowo new wywoluje konstruktor klasy

        W nawiasie wpisuje paramtry jakie chce wyslac do konstruktora
         a ich ilosc decyduje jaki konstruktor zostanie wywolany

        -----
        Konstruktor jest to metoda ktora nazywa sie tak samo
         jak klasa i nie ma okreslonego jaki typ zwraca
         oraz nie moze nic zwracac

        public Podsumowanie(){
        }

        Standardowo kazda klasa ma swoj konstrukor bezparametrowy
         bez znaczenia czy go zadeklaruje

        Jesli zadeklaruje konstruktor z jakims parametrem to
         ten bezparametrowy zostaje usuniety

        -----
        //stworznie obiektu z wywolanie konstruktora z jedyn parametrem
        Podsumowanie obiekt = new Podsumowanie(12);

        public Podsumowanie(int a)[
        }

        -----
        Moge w jednym konstruktorze odwolac sie do innego np
         w jedno lub bez parametrowym odwolac sie do dwuparamterowego
         sluszy do tego slowo this i MUSI BYC ONO NA POCZATKU
         KODU KONSTRUKTORA!

        int a;
        public Podsumowanie(){
            this(20);
            //wysylam 1 zmienna czyli do konstruktora
            // 1 parametrowego
        }
        public Podsumowanie(int a){
            this.a = a;
        }

        -----
        //konstruktor kopiujacy
        private Podsumowanie podsumowanie;

        public Podsumowanie(Podsumowanie podsumowanie){
            this.podsumowanie = podsumowanie;
        }

        -----
        Zmienna statyczna dotyczy klasy a nie obiektu lecz moge
         na obiekcie sie do niej odwolac

class Wew4{///////////////////////////////////////////////////////
        staric int a = 10;

        main(){
            Wew4 obiekt = new Wew4();
            System.out.println(obiekt.a);
        }
}/////////////////////////////////////////////////////////////////

         -----
         W przypadku dziedziczenia moge odwolac sie z konstruktora
          podklasy do konstruktora klasy bazowej tylko zamiast
          slowa this uzywam super i musi ono byc NA POCZATKU
          konstruktora

         -----
         //metoda toString

         Kazda klasa powinna miec metode toString aby moc wyswietlic obiekt
          w System.out zamiast adresu referencji

         public String toString(){
            return "zmienna a = " + a;
         }
         //zmienna a jest intem lecz dzieki konkatenacji "+" z innym stringiem
         // wszystko zostaje przypisane do stringa
         //W innym przypadku moge uzyc metody klasy Integer.valueOf(a);




         -----DZIEDZICZENIE-----

         Samochod - nadklasa/klasa bazowa
         SUV - podklasa/klasa pochodna

         Obiekt klasy ktora dziedziczy ma dostep do wszystkich pol
          i metod klasay bazowej

         -----
         //modyfikatory
         public - dostepny wszedzie
         protected - dostepne wewnatrz obiektu, PAKIETU oraz klas pochodnych
         brak modyfikatora - dostepny tylko w pakiecie(tym samym folderze)
         private - dostepne wewnatrz obiektu, klasy pochodne nie maja dostepu

         -----
         Przesloniecie metody (override) gdy klasa pochodna ma taka
          metode z taka sama nazwe i taka sama ilosc i rodzaj parametrow

         -----
         //Slowo super

         Moge odwolac sie do takiej samej meody klasy bazowej uzywajac metody super

         void metoda(){
            super.metoda();
         }

         Moge odwolac sie do takiego samego konstruktora klasay bazowej uzywajac instrukcji
          super() i musi byc ona NA POCZATKU kody konstruktora

         public Podklasa(){
            super();
         }

         -----
         //Wywolywanie konstruktorow

         Jesli klasa dziedziczy to przy tworzenie jej instancji niewazne czy typu
          klasy bazowej czy pochodnej najpierw wywola sie konstukroe klasy bazowej!

         Instrukcja super pozwala wybrac jaki konstuktor klasy bazowej ma byc wywolany,
          standardowo jest super() niejawnie, czyli ten bezparametrowy

         Musze pamietac ze jesli zadeklaruje konstruktor z parametrami to ten
          bezparametrowy (ukryty) przestaje isniec!

         -----
         Klasy i metody z modyfikatorem final nie moze byc rozszerzana!

         -----
         //kompozycja i dziedzicznie

         W dziedizczeniu moge stworzyc polimorficznie obiekt klasy
          pochodnej w typie klasy bazowej
         Ojciec obiekt = new Dziecko();

         W kompozycji moge w klasie stworzyc zmienna/atrybut/pole typu
          innej klasy np
         class Czlowiek{
            public Zwierze zwierze;
            public Budynek b = new Budynek;
         }

         -----
         //Polimorfizm

         Tworze obiekt polimorficznie (typ rodzic - obiekt dziecko)
          aby moc w typie rodzica umiesciec inne klasy pochodne rodzica.

         Rodzic r = new Dziecko();

         Jesli stworze tak obiekt do dostep do metod DZIECKA bede mial tylko
          z rzutowaniem! do metod rodzica mam dostep normalnie

         ((Dziecko) r).metodaDziecka();

         -----
         //metoda toString

         W klasie pochodznej zwracam jej zmienne i na koncu dodaje + super.toString()
          i w klasie bazowej zwracam zmienne klasy bazowej



         -----WYJATKI + BLOK TRY CATCH-----

         Wyrzucac wyjatki moge za pomoca throw new np:
          throw new IllegalArgumentException();

         Lub throws w metodach np:
         void metodaZWyjatkiem()throws IOException{
            throw new IOException();
         }

         ----
         Wyjatki dzielimy na CHECKED I UNCHECKED i dziedzicza one po klasie
          Throwable

         Checked - musi byc obluzony np IOException

         Unchecked - nie musi np IllegalArgumentException

         Jesli wyjatek ma w swojej hierarchii TYLKO Exception/Throwable
          musi byc obsluzony, jesli cos wiecej to juz nie

         Hierarchia dziedziczenia wyjatkow:
          Throwable <- Exception <- RuntimeException <- IllegalArgumentException
         -----
         Do oblusgi kilku wyjatkow w klauzuli try/catch moge zapisac
          je w oddzielnym catch lub uzywajac |
         Dodatkowo mozna dodac blok finally ktory bedzie
          sie wykonywal zawsze
         Blok try moze byc bez catch ale musi byc finally

         try {
            throw new IllegalArgumentException();
         }
         catch (ArithmeticException ex) {}
         catch (RuntimeException ex) {}

         try{
            throw new IllegalArgumentException();
         }
         catch(ArithmeticException | RuntimeException ex){}
         finally{}



         -----STERTA + REFERENCJA + GC-----

         Gdy tworze obiekty rezerowana jest pamiec (STERTA) - HEAP SPACE
         Zmienne, które wskazują na obiekty na stercie zawierają referencje

         JVM rezrwuje pamiec RAM

         Zmienne trzymane sa na STOSIE - STACK

         Gdy zajme caly stos zostanie wyrzucony wyjatek
          java.lang.OutOfMemoryError

         Null jest typem ktory nie moze posiadac nazwy przez co nie mozna
          utworzyc zmiennej tego typu



          -----KONWERSJA I RZUTOWANIE-----

          Rzutowanie (cast) - konwersja JAWNA

          Możemy rzutować wyłącznie na typ, który znajduje się hierarchii
           dziedziczenia danego obiektu (to co jest "wyzej) inaczej wyrzuci
           wyjatek java.lang.ClassCastException

          Konwejsa niejawna gdy chce przypisac int do long i nie trace informacji
           inaczej tj grzy przekrocze zakres np long do int moze pokazac -1

          Konwersji poprzez rzutowanie moge uzcyc gdy chce np obciac reszte

          int intValue = (int) 123.123F;








         */
    }
}
