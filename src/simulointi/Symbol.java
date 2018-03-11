/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulointi;

/**
 *
 * @author heikki
 */
abstract class Symbol {
    String value;
}

class DecimalDigit extends Symbol {
    private final double value;

    public DecimalDigit(double input) {
        this.value = input;
    }

    @Override
    public String toString() {
        return String.valueOf(this.value);
    }
}

class Operator extends Symbol {
    int weight;

    public int weight() {
        return this.weight;
    }
    
    @Override
    public String toString() {
        return this.value;
    }
}

class Plus extends Operator {

    public Plus() {
        this.value = "+";
        super.weight = 1;
    } 
}

class Minus extends Operator {
    
    public Minus() {
        this.value = "-";
        this.weight = 1;
    }
}

class Times extends Operator {

    public Times() {
        this.value = "*";
        this.weight = 2;
    }
    
}

class Division extends Operator {
    
    public Division() {
        this.value = "/";
        this.weight = 2;
    }
}

class Pow extends Operator {

    public Pow() {
        this.value = "^";
        this.weight = 3;
    }
    
    
}

class OpenParenthesis extends Symbol {

    public OpenParenthesis() {
        this.value = "(";
    }
    
}

class CloseParenthesis extends Symbol {
    public CloseParenthesis() {
        this.value = ")";
    }
}