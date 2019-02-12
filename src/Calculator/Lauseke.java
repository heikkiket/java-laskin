/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Calculator;

import java.util.ArrayList;

/**
 *
 * @author Heikki Ketoharju
 */
public class Lauseke {
    private ArrayList<Symbol> alkiot;
    private boolean rpn;
    private Laske laskija;

    public Lauseke() {
        this(null);
    }
    
    public Lauseke(String lauseke) {
        if(lauseke != null) {
            lueLauseke(lauseke);
        }
        alkiot = new ArrayList<>();
        rpn = false;
        laskija = new Laske(this);
    }

    public boolean isRpn() {
        return rpn;
    }

    public ArrayList<Symbol> getAlkiot() {
        ArrayList<Symbol> palautettava = new ArrayList<>();
        for(Symbol alkio : alkiot) {
            palautettava.add(alkio);
        }
        return palautettava;
    }
    
    public void addSymbol(Symbol symboli) {
        alkiot.add(symboli);
    }
    
    public void shuntingYard() {
        if(rpn) {
            return;
        }
        
        ArrayList<Symbol> outputQueue = new ArrayList<>();
        ArrayList<Operator> operatorStack = new ArrayList<>();
        for (Symbol alkio : alkiot) {
            if(alkio instanceof DecimalDigit) {
                outputQueue.add(alkio);
                
            } else if(alkio instanceof OpenParenthesis) {
                operatorStack.add((Operator) alkio);
                
            } else if(alkio instanceof CloseParenthesis) {
                int index = operatorStack.size()-1;
                while (index > 0) {
                    Operator token = operatorStack.get(index);
                    if(token instanceof OpenParenthesis) {
                        operatorStack.remove(index);
                        break;
                    }
                    outputQueue.add(token);
                    operatorStack.remove(index);
                    index --;
                }

                
            } else if(alkio instanceof Operator) {
                int index = operatorStack.size()-1;
                Operator token = (Operator) alkio;
                while(index >= 0) {
                    Operator topmost = operatorStack.get(index);
                    if((topmost.weight() > token.weight()
                            || (topmost.weight() == token.weight()
                                && token.isLeftAssociative()))
                            && (topmost instanceof OpenParenthesis == false)) {
                        outputQueue.add(topmost);
                        operatorStack.remove(index);
                    } else {
                        break;
                    }
                    index--;
                }
                operatorStack.add(token);
                
            }
            
        } //For päättyy
        
        
        int index = operatorStack.size()-1;
        while(index >= 0) {
            Symbol token = operatorStack.get(index);
            outputQueue.add(token);
            operatorStack.remove(index);
            
            index--;
        }
        
        alkiot = outputQueue;
        rpn = true;
    }
    
    public double laske() {
        return laskija.laske();
    }

    @Override
    public String toString() {
        String palautettava = "";
        for(Symbol alkio : alkiot ) {
            palautettava = palautettava + " " + alkio.toString();
        }
        return palautettava;
    }
    
    
    
    
}
