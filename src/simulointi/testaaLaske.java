/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulointi;

import java.util.Scanner;

/**
 *
 * @author simo
 */
public class testaaLaske {
    static Scanner lukija = new Scanner(System.in);
    public static void main(String[] args) {
        double eka=0.0, toka;
        String luku1,luku2;
        
        Laske laske1 = new Laske();
        Laske laske2 = new Laske();        

        System.out.println("Anna kaksi lukua / laskua");
        
        System.out.print("1. lasku: ");
        luku1 =lukija.nextLine();
        eka = laske1.lueLuvut(luku1);
        //laskin.luvut.add(eka);
        
        System.out.print("2. lasku: ");
        luku2 =lukija.nextLine();
        toka = laske2.lueLuvut(luku2);
        //laskin.luvut.add(toka);
        
        System.out.printf("\n%15s%12.3f\n%15s%12.3f\n","eka = ",eka,"toka = ",toka);
        System.out.printf("%27s\n","==========================");
        System.out.printf("%15s%12.3f\n","eka + toka = ",laske1.laskeLuvut(eka, toka, '+'));
        System.out.printf("%15s%12.3f\n","eka - toka = ",laske1.laskeLuvut(eka, toka, '-'));
        System.out.printf("%15s%12.3f\n","eka * toka = ",laske1.laskeLuvut(eka, toka, '*'));
        System.out.printf("%15s%12.3f\n","eka / toka = ",laske1.laskeLuvut(eka, toka, '/'));
        System.out.printf("%27s\n","==========================");
        /*
        laskin.luvut.add(laskin.laskeLuvut(eka, toka, '+'));
        laskin.luvut.add(laskin.laskeLuvut(eka, toka, '-'));
        laskin.luvut.add(laskin.laskeLuvut(eka, toka, '*'));
        laskin.luvut.add(laskin.laskeLuvut(eka, toka, '/'));  
       */ 
        System.out.println("");
        for (int i = 0; i< laske1.luvut.size();i++){
            System.out.println(laske1.luvut.get(i));
        }
        System.out.println("");
        for (int i = 0; i< laske1.laskut.size();i++){
            System.out.println(laske1.laskut.get(i));
        }

    }
    
}
