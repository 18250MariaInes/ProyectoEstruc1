/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lisp.interpreter;

import com.lisp.interpreter.command.FunctionCommand;

/**
 *
 * @author cesar.asada
 */
public class Interpreter {
    private FunctionCommand rootCommand = null;
    
    public Interpreter(FunctionCommand rootCommand){        
        this.rootCommand = rootCommand;
    }
    
    public void execute() throws Exception{
        
    }
    
}
