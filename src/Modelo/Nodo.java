/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author RIVADENEIRA
 */
public class Nodo<E> {
    private E data;
    private Nodo left,right;
    private int frecuencia;
    private int bit;
    
    public Nodo(E data,Integer frecuencia){
        this.data=data;
        left=right=null;
        this.frecuencia=frecuencia;
        this.bit=0;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public Nodo<E> getLeft() {
        return left;
    }

    public void setLeft(Nodo<E> left) {
        this.left = left;
    }

    public Nodo<E> getRight() {
        return right;
    }

    public void setRight(Nodo<E> right) {
        this.right = right;
    }
    
        public int getFrecuencia() {
        return frecuencia;
    }

    public void setFrecuencia(int frecuencia) {
        this.frecuencia = frecuencia;
    }

    public int getBit() {
        return bit;
    }

    public void setBit(int bit) {
        this.bit = bit;
    }

    
    @Override
    public String toString() {
        return ""+data+":"+frecuencia;
    }
    
    
       
}
