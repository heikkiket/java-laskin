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
        

        String lauseke = "2+3-5/(23+23.5*(34.4-23))";
        Lauseke lasku = new Lauseke();
        lasku.lueLauseke(lauseke);
        lasku.shuntingYard();
        System.out.println(lasku);
        
        
    }
    
}
