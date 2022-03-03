//Programmet er langt fra færdigt. Kan kun kryptere én char
//Derudover mangler der dekrypteringsdelen
//TODO Ret bug ved at ASCII-værdi overstiger 29
//TODO Ret bug vedr. Æ, Ø, Å


package com.company;

import java.util.Scanner;

public class Main {
    int converter = 64; //Konverterer ASCII-værdi A=1, B=2, osv.

    Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        Main obj = new Main();


        System.out.println("\nVelkommen til Enigma-krypteringsmaskinen\n"); //TODO evt baggrundsfarve
        System.out.print("Indtast én af følgende muligheder:\n\nTast 1 for at kryptere \nTast 2 for at " +
            "dekryptere \nTast 0 for quit\nIndtast dit valg --> ");

        obj.menu();

    }

    public void menu() {
        Main obj = new Main();
        int valg = input.nextInt();

        if (valg == 1) {
            obj.bogstavTilTal();
        }

    }


    public int test(int ascii) {
        Main obj = new Main();


        System.out.println("Vælg nu antal shifts -->");
        int antalShift = input.nextInt();

        int asciiKryp = ascii + antalShift;

        if (asciiKryp > 29) {
            int temp1 = asciiKryp % ascii;
            int temp2 = 29 - ascii;
            asciiKryp = temp1 - temp2 - 1;
            return asciiKryp;

        }


        obj.charKryp(asciiKryp);

        return asciiKryp;

    }

    public char charKryp(int asciiKryp) {

        int temp = asciiKryp + 64;

        char nytChar = (char) temp;

        System.out.println("Det krypterede bogstav er dermed " + nytChar);

        return nytChar;
    }


    public int bogstavTilTal() {
        Main obj = new Main();
        System.out.println("Du har valgt at kryptere\n");
        System.out.println("Indtast det ord du vil kryptere -->");

        String bogstav = input.nextLine();

        char ch = bogstav.charAt(0);

        if (ch == 'Æ') {
            return 27;
        } else if (ch == 'Ø') {
            return 28;
        } else if (ch == 'Å') {
            return 29;
        } else if (ch == ' ') {
            return 0;
        }

        int ascii = ch - converter;


        obj.test(ascii);

        return ascii;

    }

    public char talTilBogstav(int tal) {
        int converter = 64; //Konverterer ASCII-værdi 1=A, 2=B, osv.
        if (tal == 26) {
            return 'Æ';
        } else if (tal == 27) {
            return 'Ø';
        } else if (tal == 28) {
            return 'Å';
        } else if (tal == 0) {
            return ' ';
        }

        int bogstav = tal + converter;
        char ch = (char) bogstav;
        return ch;
    }

}
