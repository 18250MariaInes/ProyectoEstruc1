/*
 * Algoritmos y Estructura de datos
 * Proyecto #1 - Compilador LISP
 * 
 */
package com.lisp.interpreter.context;

import java.util.HashMap;
import java.util.Map;

/**
 * Almacena los contextos de los comandos analizados
 * @author maria.camila.abril
 */
public class CommandContext {
    private Map<String, String> values = null;
    
    /**
     * Instancia el hashmap para almacenar los contextos 
     */
    public CommandContext (){
        values = new HashMap<String, String>();
    }
    
    /**
     * Devuelve una variable especificada
     * @param variable
     * @return
     * @throws Exception
     */
    public String getValue (String variable) throws Exception{
        if (values.containsKey(variable)){
            return values.get(variable);
        }else{
            throw new Exception("VARIABLE (" + variable + ") NO EXISTE");
        }
    }
    
    /**
     * Modifica la variable y valor
     * @param variable
     * @param value
     */
    public void setValue (String variable, String value){
        if (values.containsKey(variable)){
            values.remove(variable);
        }
        values.put(variable, value);
    }
}
