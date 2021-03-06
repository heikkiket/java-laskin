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
    
    public void lueLauseke(String lauseke) {
        String luku ="";
        for(int i =0; i < lauseke.length(); i++){
            Symbol lisattava;

            System.out.println(i);
            switch(lauseke.charAt(i)) {
                case '+':
                    lisattava = new Plus();
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
                case '(':
                    lisattava = new OpenParenthesis();
                    alkiot.add(lisattava);
                    break;
                case ')':
                    lisattava = new CloseParenthesis();
                    alkiot.add(lisattava);
                    break;
                case '-':
                    if(lauseke.charAt(i) == '-' && !onNumero(lauseke.charAt(i-1))) {
                        luku ="-";
                        i++;
                    } else {
                        lisattava = new Minus();
                        alkiot.add(lisattava);
                        break;
                    }
                default:
                    if(onNumero(lauseke.charAt(i))) {
                        luku = luku + lauseke.charAt(i);
                        if((i == lauseke.length()-1) || !onNumero(lauseke.charAt(i+1))) {
                            lisattava = new DecimalDigit(Double.parseDouble(luku));
                            alkiot.add(lisattava);
                            luku = "";
                        }
                    }
                    System.out.println("Luku: " + luku);
            }
        }
    }
    
    private boolean onNumero(char c) {
        switch(c) {
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
                case '.':
                    return true;
        }
        return false;
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
