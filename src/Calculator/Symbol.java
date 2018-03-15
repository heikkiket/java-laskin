/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Calculator;

/**
 *
 * @author Heikki Ketoharju
 */
abstract class Symbol {
    String value;
}

class DecimalDigit extends Symbol {
    private final double value;

    public DecimalDigit(String input) {
        this.value = Double.parseDouble(input);
    }

    public double getValue() {
        return value;
    }

    

    @Override
    public String toString() {
        return String.valueOf(this.value);
    }
}

class Operator extends Symbol {
    int weight;
    boolean leftAssociative;

    public int weight() {
        return this.weight;
    }

    public boolean isLeftAssociative() {
        return leftAssociative;
    }
    
    public double laske(double luku1l, double luku2) {
        return 0.0;
    }
    
    @Override
    public String toString() {
        return this.value;
    }
}

class Plus extends Operator {

    public Plus() {
        this.value = "+";
        this.weight = 1;
        this.leftAssociative = false;
    } 
    
}

class Minus extends Operator {
    
    public Minus() {
        this.value = "-";
        this.weight = 1;
        this.leftAssociative = true;
    }
}

class Times extends Operator {

    public Times() {
        this.value = "*";
        this.weight = 2;
        this.leftAssociative = false;
    }
    
}

class Division extends Operator {
    
    public Division() {
        this.value = "/";
        this.weight = 2;
        this.leftAssociative = true;
    }
}

class Pow extends Operator {

    public Pow() {
        this.value = "^";
        this.weight = 3;
        this.leftAssociative = false;
    }

}

class OpenParenthesis extends Operator {

    public OpenParenthesis() {
        this.value = "(";
        this.weight = 4;
    }
    
}

class CloseParenthesis extends Operator {
    public CloseParenthesis() {
        this.value = ")";
        this.weight = 4;
    }
}