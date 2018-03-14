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
public class Sulku {
    int sulku[] = new int[2];
    public Sulku(){
        sulku[0] = -1;
        sulku[1] = -1;
    }
    public void setAlku(int i){
        sulku[0]=i;
    }
    public void setLoppu(int i){
        sulku[1]=i;
    }
    public int getAlku(){
        return sulku[0];
    }
    public int getLoppu(){
        return sulku[1];
    }
    
}
