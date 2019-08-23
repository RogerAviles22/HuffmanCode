/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import java.io.File;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author RIVADENEIRA
 */
public class HuffmanBT {
    private List<Character> elementos;
    private Nodo<String> root;
    private PriorityQueue<Nodo<String>> almacen;
    private HashMap<Character,Integer> tablaFrecuencias;

    
    public HuffmanBT(){
        elementos=new LinkedList<>();
        root=null;
        almacen=new PriorityQueue<>((Nodo<String> n,Nodo<String> n1) -> n.getFrecuencia()-n1.getFrecuencia());
        tablaFrecuencias= new HashMap<>();
    }
    public boolean isEmpty(){
        return root==null;
    }
    
    public void calcularArbol(String texto){
        Scanner sc=null;
        try{
            sc= new Scanner(new File(texto));
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        if (sc!=null){
            while (sc.hasNext()){
                String linea=sc.nextLine();
                for (int i = 0; i<linea.length();i++){
                    elementos.add(linea.charAt(i));
                }
            }
        }
        crearTablaFrecuencias();
        añadirNodos();
        
        //return codificar(root);
    }
    
    private String codificar(Nodo<String> nodo){
        if(nodo==null)return "";
        return "R";
    }
    
    private void crearTablaFrecuencias(){
        for(Character c:elementos){
            if(!tablaFrecuencias.containsKey(c)){
                tablaFrecuencias.put(c, 1);
            }else{
                int olV=tablaFrecuencias.get(c);
                tablaFrecuencias.replace(c,olV,olV+1);
            }
        }
    }
    
    private void añadirNodos(){
        for(Map.Entry<Character, Integer> m:tablaFrecuencias.entrySet()){
            Nodo<String> node=new Nodo(String.valueOf(m.getKey()),m.getValue());
            almacen.offer(node);
        }
        
        while(!almacen.isEmpty()){
            Nodo<String> n=almacen.poll();
            Nodo<String> n2=almacen.poll();
            Nodo<String> nRoot=new Nodo<>(n.getData()+n2.getData(),n.getFrecuencia()+n2.getFrecuencia());
            nRoot.setLeft(n2);
            n2.setBit(0);
            nRoot.setRight(n);
            n.setBit(1);
            root=nRoot;
            if(!almacen.isEmpty())almacen.offer(root); 
        }
    }
    
    public HashMap<String,String> calcularCodigos (){
        HashMap<String,String> mapCodeBinario= new HashMap<>();
        Set<Map.Entry<Character, Integer>> set = tablaFrecuencias.entrySet(); 
        if(this.isEmpty()) return mapCodeBinario;
        for (Map.Entry<Character,Integer> me : set) {
            String s =String.valueOf(me.getKey());                    
             mapCodeBinario.put(s, calcularCodigos(s, root));
        }
        
        return mapCodeBinario;
    }
    
    /*public HashMap<String,String> calcularCodigos(String Hexadecimal){
        HashMap<String,String> mapcodificado= new HashMap<>();
        String[] cadenas=Hexadecimal.split("");
        for (String cadena : cadenas) {
             mapcodificado.put(cadena, calcularCodigos(cadena, root));
        }
        return  mapcodificado;
    }*/
    
    private String calcularCodigos(String letra, Nodo<String> p){
        String codigo="";
        if(p==null) return "";
        if(p.getLeft()==null && p.getRight()==null && !p.getData().equals(letra)) return "";
        if( p.getData().contains(letra)&& p!=root){
           codigo+= Integer.toString(p.getBit());
        }
        codigo+=calcularCodigos(letra,p.getLeft()) + calcularCodigos(letra,p.getRight());
        return codigo;
    }
    
    public void enOrden(){
        enOrden(root);
    }

    private void enOrden(Nodo<String> q) {
        if(q!=null){
            enOrden(q.getLeft());
            System.out.print(q.getData()+":"+q.getFrecuencia()+" BIT:"+q.getBit()+" - ");
            enOrden(q.getRight());
        }
    }
    
    /**
     * Recibe el texto que se leyó desde el archivo y el mapa que contiene los códigos respectivos para cada carácter
     * @param leerTexto Texto leido del Archivo
     * @param mapa Con los codigos de cada caracter.
     * @return la conformación del código de Huffman
     */
    public static String codificar (String leerTexto, HashMap<String,String> mapa){
        if (leerTexto== null ||  mapa == null)
            return "";
        String binario ="";
        for(int i=0; i<leerTexto.length(); i++){
            char b= leerTexto.charAt(i);
            binario+=mapa.get(String.valueOf(b));            
        }
        return binario;
    }
    
    /**
     * Recibe el código de huffman y el mapa que contiene los códigos respectivos para cada carácter.
     * @param binario Código de huffman
     * @param mapa contiene los códigos respectivos para cada carácter
     * @return El texto original.
     */
    public static String decodificar (String binario, HashMap<String,String> mapa){
        if (binario== null ||  mapa == null)
            return ""; //if(mapa.get(bitCode)!=null){
        String bitCode ="";
        String txt_original ="";
        
        for(int i=0; i<binario.length(); i++){
            bitCode+=binario.charAt(i);
            if(mapa.containsValue(bitCode)){
                for (Map.Entry<String, String> entry : mapa.entrySet()) {
                    if(entry.getValue().equals(bitCode)){
                        txt_original+=entry.getKey();
                        bitCode="";
                    }
                }
            }      
        }
        return txt_original;
    }

    public PriorityQueue<Nodo<String>> getAlmacen() {
        return almacen;
    }

    public HashMap<Character, Integer> getTablaFrecuencias() {
        return tablaFrecuencias;
    }
    
    
}
