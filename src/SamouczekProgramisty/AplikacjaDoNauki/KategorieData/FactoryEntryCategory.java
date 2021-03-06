package SamouczekProgramisty.AplikacjaDoNauki.KategorieData;

import java.util.*;

public class FactoryEntryCategory {
    List<String> listaCzytajacaPyanie = new ArrayList<>();
    List<String> listaCzytajacaOdpowiedz = new ArrayList<>();
    Scanner wejscie = new Scanner(System.in);

    int liczbaZadanKategorii;
    int nrZadania;
    Random nrZadaniaGenerator = new Random();

    String wejscieWyjscie;

    public void entryMenu(Map<Integer, List> baza) {
        while (true){
            try {

                liczbaZadanKategorii = (baza.keySet().size())/2;

                nrZadania = (nrZadaniaGenerator.nextInt(liczbaZadanKategorii))+1;

                System.out.println("\n"+"---------------------------------------------");
                System.out.println("\n"+"Wylosowalem zadanie : "+nrZadania + "\n");

                listaCzytajacaPyanie = baza.get((nrZadania*2)-1);


                for (int i = 0; i<listaCzytajacaPyanie.size(); i++){
                    System.out.println(listaCzytajacaPyanie.get(i));
                }

                System.out.println("\n" + "Wcisnij \"a\" zeby poznac odpowiedz");
                System.out.println("Lub \"e\" by wrocic do menu");
                System.out.println("Lub dowolny znak by wylosowac kolejne pytanie");
                wejscieWyjscie = wejscie.nextLine();
                if(wejscieWyjscie.equals("e")){
                    break;
                }
                else if(wejscieWyjscie.equals("a")){
                    System.out.println();
                    listaCzytajacaOdpowiedz = baza.get(nrZadania*2);
                    for(int i=0; i<listaCzytajacaOdpowiedz.size(); i++){
                        System.out.println(listaCzytajacaOdpowiedz.get(i));
                    }
                }

            }catch (InputMismatchException e){
                wejscie.next();
            }
        }




    }
}
