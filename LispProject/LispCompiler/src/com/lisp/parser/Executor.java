/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lisp.parser;

import com.lisp.interpreter.command.RootCommand;
import java.io.BufferedReader;
import java.io.FileReader;

/**
 *
 * @author cesar.asada
 */
public class Executor {
    
    private BufferedReader bfr = null;
    
    
    public Executor(BufferedReader bfr) throws Exception{
        this.bfr = bfr;
        
    }
    
    
    
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
