/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Set;

/**
 *
 * @author RIVADENEIRA
 */
public class Proyecto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        HuffmanBT t=new HuffmanBT();
        t.calcularArbol("src/Recursos/FATALITY.txt");
        t.enOrden();
        HashMap<Character,Integer> a = t.getTablaFrecuencias();
        Set<Map.Entry<Character, Integer>> set = a.entrySet(); 
        for(Map.Entry<Character,Integer> me : set){
            System.out.println(me.getKey()+" "+me.getValue());
        }
        //System.out.println(" ");
    }
    
}
