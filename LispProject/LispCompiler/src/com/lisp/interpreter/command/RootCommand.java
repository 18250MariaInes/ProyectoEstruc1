/*
 * Algoritmos y Estructura de datos
 * Proyecto #1 - Compilador LISP
 * 
 */
package com.lisp.interpreter.command;

import com.lisp.interpreter.context.CommandContext;

/**
 *
 * @author maria.camila.abril
 */
public class RootCommand extends FunctionCommand{
    
    /**
     * Contiene las instrucciones que deben ser tokenizadas y luego ejecutadas 
     */
    public RootCommand(){
        super("ROOT");
    }
    
    /**
     * Ejecuta
     * @return
     * @throws Exception
     */
    public String execute() throws Exception {
        CommandContext localContext = new CommandContext();
        return execute(localContext);
    }
    
}
