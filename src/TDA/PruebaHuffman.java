/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TDA;

import java.util.HashMap;

/**
 *
 * @author Rogencio
 */
public class PruebaHuffman {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        HashMap<String,String> mapa= new HashMap<>();
        mapa.put("A", "001");
        mapa.put("B", "110");
        mapa.put("C", "000");
        mapa.put("D", "101");
        mapa.put("E", "100");
        mapa.put("F", "111");
        mapa.put("G", "01");
        String cofidicar =ArbolHuffman.codificar("AAAAAABBBBBBBBCCCCCDDDDDDDEEEEEEFFFFFFFFGGGGGGGGGGG", mapa);
        System.out.println(cofidicar);
        //0010010010010010011101101101101101101101100000000000000001011011011011011011011001001001001001001111111111111111111111110101010101010101010101
        String decodificar = ArbolHuffman.decodificar("0010010010010010011101101101101101101101100000000000000001011011011011011011011001001001001001001111111111111111111111110101010101010101010101", mapa);
        System.out.println(decodificar);
    }
    
}
