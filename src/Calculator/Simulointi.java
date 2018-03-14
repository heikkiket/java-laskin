/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Calculator;

/**
 *
 * @author simo
 */
public class Simulointi {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Operator miinus = new Minus();
        Operator plus = new Plus();
        Operator kerto = new Times();
        Operator jako = new Division();
        Operator potenssiin = new Pow();
        Operator sulkuauki = new OpenParenthesis();
        Operator sulkukiinni = new CloseParenthesis();
        
        
        DecimalDigit kolme = new DecimalDigit(3);
        DecimalDigit neljä = new DecimalDigit(4);
        DecimalDigit kaksi = new DecimalDigit(2);
        DecimalDigit yksi = new DecimalDigit(1);
        DecimalDigit viisi = new DecimalDigit(5);
        DecimalDigit pi = new DecimalDigit(3.1415);
        

        String lauseke = "3.0 + 4.0 * 2.0 / ( 1.0 - 5.0 ) ^ 2.0 ^ 3.1415";
        Lauseke lasku = new Lauseke();
        Lauseke lasku2 = new Lauseke();
        lasku2.lueLauseke(lauseke);
        System.out.println(lasku2);
        lasku2.shuntingYard();
        System.out.println(lasku2);
        
        lasku.addSymbol(kolme);
        lasku.addSymbol(plus);
        lasku.addSymbol(neljä);
        lasku.addSymbol(kerto);
        lasku.addSymbol(kaksi);
        lasku.addSymbol(jako);
        lasku.addSymbol(sulkuauki);
        lasku.addSymbol(yksi);
        lasku.addSymbol(miinus);
        lasku.addSymbol(viisi);
        lasku.addSymbol(sulkukiinni);
        lasku.addSymbol(potenssiin);
        lasku.addSymbol(kaksi);
        lasku.addSymbol(potenssiin);
        lasku.addSymbol(pi);
        
    }
    
}
