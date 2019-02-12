/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Calculator;

/**
 *
 * @author heikki
 */
public class Function extends Operator {
    private String funktio;
    private Lauseke funktiolauseke;
    private double value;

    public Function(String input) {
        funktio = input;
        funktiolauseke = new Lauseke();
        funktiolauseke.lueLauseke(funktio);
    }

    public double laske() {
        
        return funktiolauseke.laske();
    }
    
    
    
}
