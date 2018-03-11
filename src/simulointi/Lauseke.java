/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulointi;

import java.util.ArrayList;

/**
 *
 * @author heikki
 */
public class Lauseke {
    private ArrayList<Symbol> alkiot;

    public Lauseke() {
        alkiot = new ArrayList<>();
    }
    
    public void addSymbol(Symbol symboli) {
        alkiot.add(symboli);
    }

    @Override
    public String toString() {
        String palautettava = "";
        for(Symbol alkio : alkiot ) {
            palautettava = palautettava + alkio.toString();
        }
        return palautettava;
    }
    
    
    
    
}
