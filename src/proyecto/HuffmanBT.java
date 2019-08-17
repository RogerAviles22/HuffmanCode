/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import java.io.File;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Stack;

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
    
    public String codificar(String texto){
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
        
        return codificar(root);
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
            nRoot.setRight(n);
            root=nRoot;
            if(!almacen.isEmpty())almacen.offer(root); 
        }
    }
    
    public void enOrden(){
        enOrden(root);
    }

    private void enOrden(Nodo<String> q) {
        if(q!=null){
            enOrden(q.getLeft());
            System.out.print(q.getData()+":"+q.getFrecuencia()+" ");
            enOrden(q.getRight());
        }
    }
}
