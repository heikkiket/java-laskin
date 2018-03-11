/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulointi;

/**
 *
 * @author simo
 */
public class Simulointi {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Operator miinus = new Minus();
        Operator plus = new Plus();
        
        DecimalDigit viisi = new DecimalDigit(5);
        DecimalDigit kakspuol = new DecimalDigit(2.5);
        
        System.out.println(viisi);
        
        Lauseke lasku = new Lauseke();
        
        lasku.addSymbol(viisi);
        lasku.addSymbol(plus);
        lasku.addSymbol(kakspuol);
        
        System.out.println(lasku);
    }
    
}
