/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulointi;

import java.util.ArrayList;

/**
 *
 * @author Heikki Ketoharju
 */
public class Lauseke {
    private ArrayList<Symbol> alkiot;
    private boolean rpn;

    public Lauseke() {
        alkiot = new ArrayList<>();
        rpn = false;
    }

    public boolean isRpn() {
        return rpn;
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
    
    public void lueLauseke(String lauseke) {
        for(int i =0; i < lauseke.length(); i++){
            Symbol lisattava;
            switch(lauseke.charAt(i)) {
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                    lisattava = new DecimalDigit(Double.parseDouble(String.valueOf(i)));
                    alkiot.add(lisattava);
                    break;
                case '+':
                    lisattava = new Plus();
                    alkiot.add(lisattava);
                    break;
                case '-':
                    lisattava = new Minus();
                    alkiot.add(lisattava);
                    break;
                case '*':
                    lisattava = new Times();
                    alkiot.add(lisattava);
                    break;
                case '/':
                    lisattava = new Division();
                    alkiot.add(lisattava);
                    break;
                case '^':
                    lisattava = new Pow();
                    alkiot.add(lisattava);
                    break;
            }
        }
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
