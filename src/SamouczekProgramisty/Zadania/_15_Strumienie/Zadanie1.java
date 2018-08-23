package SamouczekProgramisty.Zadania._15_Strumienie;

import SamouczekProgramisty.Zadania._13_Lambda.Zadanie2;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.IntSupplier;
import java.util.function.ToIntFunction;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Zadanie1 {

    public int getZmienna() {
        return zmienna;
    }

    public int zmienna;

    public Zadanie1(int zmienna) {
        this.zmienna = zmienna;
    }

    public static void main(String[] args) {

        double highestRanking = 0;
        BoardGame bestGame = null;
        for (BoardGame game : BoardGame.GAMES) {
            if (game.name.contains("a")) {
                if (game.rating > highestRanking) {
                    highestRanking = game.rating;
                    bestGame = game;
                }
            }
        }
        System.out.println(bestGame.name);

        //


        BoardGame najlepszaGra =  BoardGame.GAMES.stream()
                .filter(x -> x.name.contains("a"))
                .max(Comparator.comparingDouble(x -> x.rating)).get();
        System.out.println("najlepsza gra: "+ najlepszaGra.name);


        List<Zadanie1> testList = Arrays.asList(new Zadanie1(70), new Zadanie1(20), new Zadanie1(90));

        Zadanie1 numbersStream = testList.stream()
                .max(Comparator.comparingInt(x -> x.zmienna)).get();
        //to działa
        //metoda .max na strumieniu przyjmuje Comparator na ktorym wywoluje metode
        // statyczna comparingInt ktora przyjmuje interface funkcyjny ToIntFunction<T>
        // z meotda int applyAsInt(T value)
        //zmienna numbersStream zawiera teraz tylko jeden element listy i jest nim najwieksza
        // wartosc pola int zmienna
        System.out.println("numbersStream : "+ numbersStream.zmienna);

        testList.stream()
                .max(Comparator.comparingInt(x ->x.zmienna)).get();

        System.out.println("SORT:");
        List<Zadanie1> strumienSort = testList.stream()
                .sorted(Comparator.comparingInt(Zadanie1::getZmienna))
                .collect(toList());
        strumienSort.stream()
                .map(x -> x.zmienna)
                .forEach(System.out::println);

        System.out.println("Sort2:");
        //testList.stream().map(x -> x.zmienna).forEach(System.out::println);


//        Stream<Zadanie1> numbersStream2 = testList.stream()
//                .filter(x -> x.zmienna/10 == 9)
//                .max(Comparator.comparingInt(x -> x.zmienna)).get();
        //to nie dziala

        ToIntFunction<KlasaZLiczba> dajLiczbeKlasy = KlasaZLiczba::getX;
        KlasaZLiczba ob = new KlasaZLiczba(10);
        System.out.println("to liczba z obiektu : "+dajLiczbeKlasy.applyAsInt(ob));

        IntSupplier dajLiczbeObiektu = ob::getX;
        System.out.println("to liczba z obiektu : "+dajLiczbeObiektu.getAsInt());


        System.out.println("Test listy obiektowej");
        List<Zadanie1> listaLiczb = Arrays.asList(new Zadanie1(2), new Zadanie1(1), new Zadanie1(3));
        Stream<Zadanie1> stream = listaLiczb.stream()
                .peek(x -> x.zmienna+=1);
        Stream<Integer> stream1 = stream.map(x -> x.zmienna);
        stream1.forEach(System.out::println);


        System.out.println("Test listy prstej");
        List<Integer> listaProstaLiczba = Arrays.asList(2,5,7,1,9);
        Stream<Integer> streamX = listaProstaLiczba.stream()
                .filter(x -> x<9)
                .sorted();
        Stream<String> streamX2 = streamX
                .map(x -> x.toString());
        streamX2.forEach(System.out::println);


        System.out.println("Test lsty z obiektamy innej klasy:");
        List<KlasaZLiczba> klasaZLiczbaList = new ArrayList<>();
        klasaZLiczbaList.add(new KlasaZLiczba(3));
        klasaZLiczbaList.add(new KlasaZLiczba(2));
        klasaZLiczbaList.add(new KlasaZLiczba(5));
        klasaZLiczbaList.add(new KlasaZLiczba(1));

        List<KlasaZLiczba> strumien = klasaZLiczbaList.stream()
                .filter(x -> x.getX()>2)
                .sorted(Comparator.comparing(KlasaZLiczba::getX).reversed())
                .collect(toList());
        strumien.forEach(x -> System.out.println(x.getX()));
        //-----------------------------------------------------------------------
        ////////////////////////////////////////////
        List<Integer> listNumbers = new ArrayList<>();
        listNumbers.add(3);
        listNumbers.add(1);
        listNumbers.add(5);
        listNumbers.add(9);

        List<KlasaZLiczba> listObject = new ArrayList<>();
        listObject.add(new KlasaZLiczba(33));
        listObject.add(new KlasaZLiczba(11));
        listObject.add(new KlasaZLiczba(55));
        listObject.add(new KlasaZLiczba(99));
        ////////////////////////////////////////////
        /*Operacja na Strem*/
        System.out.println("\n"+"OPERACJE NA STREAM 1:");
        Stream<Integer> integerStream = listNumbers.stream()
                .filter(x -> x>2)
                .sorted();
        integerStream.forEach(System.out::println);

        System.out.println("\n"+"OPERACJE NA STREAM 2:");
        Stream<KlasaZLiczba> klasaZLiczbaStream = listObject.stream()
                .filter(x -> x.getX()>22)
                .sorted(Comparator.comparing(KlasaZLiczba::getX));
        klasaZLiczbaStream.forEach(x -> System.out.println(x.getX()));

        /*Operacje bezposrenio na liscie*/
        System.out.println("\n"+"OPERACJE bezposrenio na liscie 1:");
        listNumbers.stream()
                .filter(x -> x>2)
                .sorted()
                .forEach(System.out::println);




    }
}


class BoardGame {

    public final String name;
    public final double rating;
    public final BigDecimal price;
    public final int minPlayers;
    public final int maxPlayers;

    public BoardGame(String name, double rating, BigDecimal price, int minPlayers, int maxPlayers) {
        this.name = name;
        this.rating = rating;
        this.price = price;
        this.minPlayers = minPlayers;
        this.maxPlayers = maxPlayers;
    }
    public static final List<BoardGame> GAMES = Arrays.asList(
            new BoardGame("Terraforming Mars", 8.38, new BigDecimal("123.49"), 1, 5),
            new BoardGame("Codenames", 7.82, new BigDecimal("64.95"), 2, 8),
            new BoardGame("Puerto Rico", 8.07, new BigDecimal("149.99"), 2, 5),
            new BoardGame("Terra Mystica", 8.26, new BigDecimal("252.99"), 2, 5),
            new BoardGame("Scythe", 8.3, new BigDecimal("314.95"), 1, 5),
            new BoardGame("Power Grid", 7.92, new BigDecimal("145"), 2, 6),
            new BoardGame("7 Wonders Duel", 8.15, new BigDecimal("109.95"), 2, 2),
            new BoardGame("Dominion: Intrigue", 7.77, new BigDecimal("159.95"), 2, 4),
            new BoardGame("Patchwork", 7.77, new BigDecimal("75"), 2, 2),
            new BoardGame("The Castles of Burgundy", 8.12, new BigDecimal("129.95"), 2, 4)
    );
}

class KlasaZLiczba{
    private int x;

    public int getX() {
        return x;
    }

    public KlasaZLiczba(int x) {
        this.x = x;
    }
}