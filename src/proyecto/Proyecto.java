/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import java.util.PriorityQueue;

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
        t.codificar("PruebaHuffman.txt");
        t.enOrden();
        System.out.println(" ");
    }
    
}
