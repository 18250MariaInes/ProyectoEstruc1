/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lisp.interpreter.context;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author cesar.asada
 */
public class CommandContext {
    private Map<String, String> values = null;
    
    public CommandContext (){
        values = new HashMap<String, String>();
    }
    
    public String getValue (String variable) throws Exception{
        if (values.containsKey(variable)){
            return values.get(variable);
        }else{
            throw new Exception("VARIABLE (" + variable + ") NO EXISTE");
        }
    }
    
    public void setValue (String variable, String value){
        if (values.containsKey(variable)){
            values.remove(variable);
        }
        values.put(variable, value);
    }
}
