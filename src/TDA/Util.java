/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TDA;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Formatter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.HashMap;
import java.util.Map;
import Modelo.HuffmanBT;
/**
 *
 * @author Rogencio
 */
public class Util {
    /**
     * Obtener el texto del archivo pasado como parámetro
     * @param nombreArchivo Nombre del archivo con extensión .txt a obtener sus elementos
     * @return String con los elementos del txt
     */
    public static String leerTexto(String nombreArchivo){
        String mensaje="";
        try(Scanner sc = new Scanner(new File(nombreArchivo))){            
            while(sc.hasNextLine()){
            String m= sc.nextLine();
            mensaje+=m;            
        }
        }catch (FileNotFoundException ex) {
            Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
        }
        return mensaje;
    }
    
    /**
     * Calcular la frecuencia de cada uno de los caracteres del texto
     * @param texto Recibe el texto que se leyó desde el archivo
     * @return Un mapa con la información de la frecuencia de cada uno de los caracteres que contiene el texto
     */
    public static HashMap<String,Integer> calcularFrecuencias(String texto){
        HashMap<String,Integer> caracteres= new HashMap<>();
        if(texto!=null){
            for(int i =0; i<texto.length(); i++){   
                char c=texto.charAt(i);
                String s = String.valueOf(c);
                if(!caracteres.containsKey(s))
                    caracteres.put(s, 1);
                else{
                    Integer v = caracteres.get(s);
                    caracteres.put(s, v+1);
                }                
            }
        }
        return  caracteres;
    }
    
    /**
     * Recibe una cadena de Binarios para convertir a hexadecimal
     * @param binario Cadena de Binarios
     * @return Cadena convertida a Hexadecimal
     */
    public static String binarioHexaDecimal(String binario){
        if( !validarBinarios(binario) || binario==null)
            return "";
        int cerosAgregados= equilibrarCeros(binario).length(); //Longitud de los ceros agregados       
        binario+=equilibrarCeros(binario);
        String conversion ="";
        for(int i=0; i<binario.length(); i+=4){
            Integer num = Integer.valueOf(binario.substring(i, i+4), 2);    
            conversion+=Integer.toHexString(num);
        }
        conversion+= new String(new char[cerosAgregados]).replace("\0", "-");
        return conversion;
    }
    
    /**
     * Valida que la cadena ingresada sea de 1 y 0.
     * @param binarios Cadena de tipo String.
     * @return Cadena Hexadecimal.
     */
    private static boolean validarBinarios(String binarios){
        for(int i =0; i<binarios.length(); i++){
            char c=binarios.charAt(i);
            if(c!='1' && c!='0')
                return false;
        } 
        return true;
    }
    
    /**
     * Aumenta los ceros necesarios para realizar la conversion correctamente.
     * @param binarios Cadena de binarios a examinar.
     * @return Cadena de 0 faltantes para equilibrar la cadena;
     */
    private static String equilibrarCeros(String binarios){        
        Integer s=binarios.length();
        if(s%4 ==0) return "";        
        else if(s>0 && s<4){
            int n = 4-s;
            return new String(new char[n]).replace("\0", "0");
        }
        int ceroFaltantes=4-(s%4);
        String s1 = new String(new char[ceroFaltantes]).replace("\0", "0");
        return s1;
    }
    
    /**
     * http://codesandtags.org/conversiones-de-numeros-en-java/
     * @param hexadecimal Cadena hexadecimal a convertir
     * @return String binario
     */
    public static String hexadecimalBinario (String hexadecimal){
        if(hexadecimal==null) return "";
        if(hexadecimal.contains("-")){
            int contador =0;
            contador=contadorCaracteres(hexadecimal,'-');
            String hexRecortado=hexadecimal.substring(0, hexadecimal.length()-contador);
            String hex=ceroYConversion(hexRecortado);
            return hex.substring(0, hex.length()-contador);
        }       
        return ceroYConversion(hexadecimal);
    }
    
    /**
     * Cuenta la cantidad del caracter pasado como parámetros del String cadena
     * @param cadena String Hexadecimal a evaluar
     * @param caracter Caracter a contar
     * @return Cantidad de caracter encontrado.
     */
    private static int contadorCaracteres(String cadena, char caracter){
        int contador =0;
        for(int i=0; i<cadena.length(); i++){
            char c=cadena.charAt(i);
            if(c==caracter)
                contador++;
        }
        return contador;
    }
    
    /**
     * Transforma la cadena en Binario y con ceros necesarios a la izquierda.
     * @param cadena Cadena hexadecimal.
     * @return Cadena binaria con los ceros a la izquierda.
     */
    private static String ceroYConversion(String cadena){        
        String conversion="";
        for(int i=0;i<cadena.length();i++){
            char c=cadena.charAt(i);
            Integer numero=Integer.valueOf(String.valueOf(c), 16);            
            String convertir=Integer.toBinaryString(numero);
            Formatter fmt = new Formatter();
            fmt.format("%04d",Integer.valueOf(convertir));
            conversion+=fmt;
        }
        return conversion;
    }
    
    /**
     * Crea 2 .txt y almacena un texto Convertido| Guarda el Mapa con los textos
     * @param nombreArchivo Nombre del archivo a leer y guardar
     * @param texto String del texto a guardar
     * @param mapa Mapa con las frecuencias del txt leido
     */
    public static void guardarTexto (String nombreArchivo, String texto, HashMap<String,String> mapa){
        if(nombreArchivo!=null && texto!=null && mapa!=null){
            String compress = nombreArchivo .substring(0,nombreArchivo.length()-4)+"_compress.txt";
            System.out.println(compress);
            try(BufferedWriter out = new BufferedWriter(new FileWriter(nombreArchivo));
            BufferedWriter out2 = new BufferedWriter(new FileWriter(compress));){
                out.write(texto);
                out.newLine();
                out.close();
                for (Map.Entry<String,String> entry : mapa.entrySet()) 
                    out2.write(entry.getKey()+","+entry.getValue()+"\n");
                out2.close();
            }catch(IOException e){
                System.err.println("Error"+e);
            }
        }      
    }
    
    public static void guardarDecodificado(String nombreArchivo, String texto){
        if(nombreArchivo!=null && texto!=null){
            try(BufferedWriter out = new BufferedWriter(new FileWriter(nombreArchivo));){
                out.write(texto);
                out.newLine();
                out.close();
            }catch(IOException e){
                System.err.println("Error"+e);
            }
        }      
    }
    
    /**
     * Esta función lee el mapa de códigos para cada carácter desde un archivo y lo retorna en un mapa.
     * @param nombreArchivo Nombre del archivo, con contenido del Mapa a leer, con extension .txt
     * @return HashMap 
     */
    public static HashMap<String,String> leerMapa (String nombreArchivo){
        HashMap<String,String> mapaLeido=new HashMap<>();
        try(Scanner sc = new Scanner(new File(nombreArchivo))){            
            while(sc.hasNextLine()){
                String[] m = sc.nextLine().split(",");
                mapaLeido.put(m[0], m[1]);
            }
        }catch (FileNotFoundException ex) {
            Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
        }
        return mapaLeido;
    }
    
    public static void main(String[] args) {
        HuffmanBT huffmanComprimir = new HuffmanBT();
        String file = "E:\\Respaldo2\\ESPOL\\7mo Semestre\\Estructuras\\HuffmanCode\\src\\Recursos\\hola.txt";
        System.out.println(file);
        String leerText= Util.leerTexto(file);
        System.out.println("Texto antes de calcular Frecuencia Y convertirlo a decimal: "+leerText);
        
        huffmanComprimir.calcularArbol("src/Recursos/hola.txt");
        HashMap<String,String> calcularCodigo = huffmanComprimir.calcularCodigos();
        String codificado = HuffmanBT.codificar(leerText, calcularCodigo);
        String binHexa = Util.binarioHexaDecimal(codificado);
        System.out.println(binHexa);
        Util.guardarTexto(file, binHexa, calcularCodigo); 
        System.out.println(calcularCodigo);
        
        //System.out.println(leerMapa("hola_compress.txt"));
        //System.out.println(binarioHexaDecimal("0010010010010010011101101101101101101101100000000000000001011011011011011011011001001001001001001111111111111111111111110101010101010101010101"));
        //System.out.println(contadorCaracteres("24--", '-'));
        //System.out.println(hexadecimalBinario("9"));
        /*System.out.println(hexadecimalBinario("2A--"));
        System.out.println(binarioHexaDecimal("001010"));*/
        //System.out.println(binarioHexaDecimal("1001001001001001110110"));
        /*int numero = 10; 
        Formatter fmt = new Formatter();
        fmt.format("%04d",numero);
        System.out.println("El numero formateado " + fmt);*/
    }
    
}
