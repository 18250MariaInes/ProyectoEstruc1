/*
 * Algoritmos y Estructura de datos
 * Proyecto #1 - Compilador LISP
 * 
 */
package com.lisp.parser;

import com.lisp.interpreter.command.RootCommand;
import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Este lee el txt y lo envia a Root a traves del Parseer
 * @author maria.camila.abril
 */
public class Executor {
    
    private BufferedReader bfr = null;
    
    /**
     *
     * @param bfr
     * @throws Exception
     */
    public Executor(BufferedReader bfr) throws Exception{
        this.bfr = bfr;
        
    }
    
    /**
     *
     * @param args
     */
    public static void main(String[] args){
        try{
            FileReader fr = new FileReader("C:\\temp\\simpleLisp.txt");
            
            BufferedReader bfr = new BufferedReader(fr);
            
            Parser parser = new Parser(bfr);
            RootCommand root= parser.parse();
            String value =root.execute();
            
            System.out.println("SALIDA:" + value);
            
            bfr.close();
            fr.close();
            
            System.out.println("FIN");
        }catch(Exception ex){
            System.out.println("ERROR:"+ ex);
            ex.printStackTrace();
        }
    }
}
