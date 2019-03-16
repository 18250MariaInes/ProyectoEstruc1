/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lisp.interpreter.command;

import com.lisp.interpreter.context.CommandContext;

/**
 *
 * @author cesar.asada
 */
public class RootCommand extends FunctionCommand{
    
    public RootCommand(){
        super("ROOT");
    }
    
    public String execute() throws Exception {
        CommandContext localContext = new CommandContext();
        return execute(localContext);
    }
    
}
