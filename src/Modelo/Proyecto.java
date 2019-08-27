/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import TDA.Util;
import java.util.HashMap;

/**
 *
 * @author RIVADENEIRA
 */
public class Proyecto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String leerText= Util.leerTexto("src/Recursos/texto.txt");
        HuffmanBT t=new HuffmanBT();
        t.calcularArbol("src/Recursos/FATALITY.txt");
        t.enOrden();
        //HashMap<Character,Integer> a = t.getTablaFrecuencias();
        //Set<Map.Entry<Character, Integer>> set = a.entrySet(); 
        HashMap<String,String> calcularCodigo = t.calcularCodigos();
        //Set<Map.Entry<String, String>> set2 = aa.entrySet(); 
        String codificado = HuffmanBT.codificar(leerText, calcularCodigo);
        String binHexa = Util.binarioHexaDecimal(codificado);
        System.out.println("\n");
        System.out.println(binHexa);
        
        System.out.println("\n");
        String decodificado = HuffmanBT.decodificar(codificado, calcularCodigo);
        System.out.println(decodificado);
        //System.out.println("\n hola");
        /*for(Map.Entry<Character,Integer> me : set){
            System.out.println(me.getKey()+" "+me.getValue());
        }*/
        /*System.out.println("\n");
        for(Map.Entry<String,String> me : set2){
            System.out.println(me.getKey()+" "+me.getValue());
        }*/
        /*Character c = 'a';
        String s = "a";
        String sc = String.valueOf(c);
        System.out.println(sc.equals(s));*/
        //System.out.println(" ");
        
        /*String r = "src/Recursos/fatality.txt";
        String compress = r .substring(0,r.length()-4)+"_compress.txt";
        System.out.println(compress);*/
    }
    
}
