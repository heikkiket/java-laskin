/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//Testaan muutoksen tekemistä lisäämällä tarpeettoman kommentin.
package Calculator;

import java.util.ArrayList;

/**
 *
 * @author simo
 */
public class Laske {
    private Lauseke lauseke;
    ArrayList<Double> luvut;
    ArrayList<Character> laskut;
    ArrayList<Sulku> sulut;
    
    Laske (Lauseke lauseke){
        this.lauseke = lauseke;
    }
    public double lueLuvut(String n1){
        double dLuku=0.0;
        String tulos = "";
        boolean pilkku = false;
              
        //mjono = n1.trim(); //poistetaan välilöynnit ja muut tyhjät merkit
        for(int i =0; i<n1.length();i++){
            if(this.onkoNumero(n1.charAt(i))){
               tulos += Character.toString(n1.charAt(i));
            }else{
                if ((n1.charAt(i)=='.' || n1.charAt(i)==',') && pilkku == false){
                    tulos += ".";
                    pilkku = true;
                                       
                }else {
                    if (n1.charAt(i)== '+'|| n1.charAt(i)=='-' ||
                            n1.charAt(i)== '/'|| n1.charAt(i)=='*'){
                        if(tulos.length()>0){
                            this.laskut.add(n1.charAt(i));
                            dLuku = Double.parseDouble(tulos);
                            tulos = "";
                            this.luvut.add(dLuku);
                            pilkku=false;
                        }else {
                            if (n1.charAt(i)=='-'|| n1.charAt(i)=='+'){
                                tulos += Character.toString(n1.charAt(i));
                            }
                            if (n1.charAt(i)=='('|| n1.charAt(i)==')')
                                this.laskut.add(n1.charAt(i));
                                if (n1.charAt(i)=='('){
                                    int j = laskut.size() -1;
                                    Sulku sulku = new Sulku();
                                    sulku.setAlku(j);
                                    sulut.add(sulku);//sulku.getLoppu() == -1
                                }
                                if (n1.charAt(i)==')'){
                                    for(int ind = sulut.size()-1;ind >= 0; ind--){
                                        if (sulut.get(ind).getLoppu()==(-1)){
                                            int j = laskut.size() -1;
                                            Sulku sulku = new Sulku();
                                            sulku = sulut.get(ind);
                                            sulku.setLoppu(j);
                                            sulut.set(ind, sulku);
                                            ind=0; // lopetus
                                        }
                                    }
                                }
                        }
                    }
                    ;//ei tehdä mitään
                }
            }            
        }
                    
        dLuku = Double.parseDouble(tulos);
        this.luvut.add(dLuku);
        
        dLuku=this.luvut.get(0);
        return dLuku;
    }
    /**
     * metodi palauttaa 
     *  0-sulut '(' ja ')'
     *  1-kerto '*' 
     *  2-jako  '/'
     *  3-plus ja miinus '+' ja '.'
     * @param merkki
     * @return 
     */
    
    public double laske(){
        double laskutulos=0.0;
        ArrayList<Symbol> luvut=new ArrayList();//desimaaliluvut
        ArrayList<Symbol> lasku = lauseke.getAlkiot(); // rpn- lasku
        int koko = 0;
        double tulos =0.0;
        
        koko = lasku.size();
          
            //(+ ja -) -lasku
            for (Symbol alkio: lasku){
                if (alkio instanceof DecimalDigit){
                    luvut.add(0,alkio);
                }else{
                    DecimalDigit luku1 = (DecimalDigit) luvut.get(1);
                    DecimalDigit luku2 = (DecimalDigit) luvut.get(0);
                    Operator laskutoimitus = (Operator) alkio;
                    tulos = this.laskeLuvut(luku1.getValue(), luku2.getValue(),alkio.value.charAt(0));
                    luvut.add(0, new DecimalDigit(tulos));
                    luvut.remove(1);
                    luvut.remove(1);
                }

            }
        
        laskutulos= Double.parseDouble(luvut.get(0).value);
        //laskutulos=lukuja.get(0);
        return laskutulos;
    }

    public int jarjestys(char merkki){
        int indeksi=0; //sulut
        if (merkki == '*')
            indeksi=1;
        if (merkki == '/')
            indeksi = 2;
        if (merkki == '+'|| merkki == '-')
            indeksi = 3;
        
        return indeksi;
    }
    public int laskutKoko(){
        int koko = 0;
        int sulut=0;
        
        for (int i =0; i<this.laskut.size();i++){
            if(this.laskut.get(i)=='('||this.laskut.get(i)==')')
                sulut++;
        }
        koko = (laskut.size() - sulut);
        return koko;
    }
    public boolean onkoNumero(char merkki){
        boolean totta = false;
        char [] numerot ={'0','1','2','3','4','5','6','7','8','9'};
        
        for(int i = 0; i<numerot.length;i++){
            if(numerot[i]==merkki){
                totta = true;
                break;
            }
        }
        
        return totta;
    }
    //public double merkkijonoLuvuksi(String n1){
    public double laskeLuvut(double a,double b, char merkki){
        double tulos =0.0;
      
            switch (merkki){
                case '+':
                    tulos = (a+b)*1.0;   
                    break;
                case '-':
                    tulos = (a-b)*1.0;
                    break;
                case '/':
                    if (b!=0.0)
                        tulos = (a / b)*1.0;    
                    break;
                case '*':
                    tulos = (a*b)*1.0;
                    break;
                case '^':
                    tulos = Math.pow(a, b)*1.0;
                    break;
                default:  
                    break;
                    
            }
                    
                        
        return tulos;
    }
    
    public static void main(String[] args) {
        double lasku = 2+3-5/(23+23.5*(34.0-23));
        
    /*    Lauseke lasku = new Lauseke("2+3-5/(23+23.5*(34.0-23))");
        
        double tulos = lasku.laske;
    
        System.out.println("2+3-5/(23+23,5*(34.0-23)) = "+lasku);
        
        System.out.print("\n Anna lasku:");
        mjono = lukija.nextLine();
        
        System.out.println("\ntulos = " );
     */   
    }
   
}
