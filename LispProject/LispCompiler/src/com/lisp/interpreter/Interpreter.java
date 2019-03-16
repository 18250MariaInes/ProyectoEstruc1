/*
 * Algoritmos y Estructura de datos
 * Proyecto #1 - Compilador LISP
 * 
 */
package com.lisp.interpreter;

import com.lisp.interpreter.command.FunctionCommand;

/**
 *
 * @author maria.camila.abril
 */
public class Interpreter {
    private FunctionCommand rootCommand = null;
    
    /**
     * Utiliza a rootCommand
     * @param rootCommand
     */
    public Interpreter(FunctionCommand rootCommand){        
        this.rootCommand = rootCommand;
    }
    
    /**
     *  
     * @throws Exception
     */
    public void execute() throws Exception{
        
    }
    
}
