package SamouczekProgramisty.Zadania.Interface;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        Computation computation;

        if (main.shouldMultiply()) {
            computation = new MySubtract(); // zaimplementuj brakującą klasę
        }
        else {
            computation = new MyAdd(); // zaimplementuj brakującą klasę
        }

        double argument1 = main.getArgument();
        double argument2 = main.getArgument();

        double result = computation.compute(argument1, argument2);
        System.out.println("Wynik: " + result);
    }

    private boolean shouldMultiply() {
        System.out.println("Would You like to add arguments? - press 1");
        System.out.println("Or subtract? - press 2");
        Scanner sc = new Scanner(System.in);
        int select = sc.nextInt();
        if(select == 1)
            return false;
        else
            return true;
        // tutaj zapytaj użytkownika co chce zrobić (mnożenie czy dodawanie)
    }

    private double getArgument() {
        Scanner sc = new Scanner(System.in);
        System.out.println("What is argument:");
        return sc.nextDouble();

    }

}
