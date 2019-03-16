/*
 * Algoritmos y Estructura de datos
 * Proyecto #1 - Compilador LISP
 * 
 */
package com.lisp.interpreter.command;

import java.util.HashMap;
import java.util.Map;

/**
 * Esta clase almacena las funciones definidas para luego usarlas en el root
 * @author maria.camila.abril
 */
public class FunctionCommandCache {
    private Map<String, FunctionCommand> functions = null;
    
    /**
     * Constructor con su HashMap de funciones
     */
    public FunctionCommandCache(){
        functions = new HashMap<String, FunctionCommand>();                
    }
    
    private static FunctionCommandCache me = null;
    
    /**
     * Instancia este tipo de objeto
     * @return
     */
    public static FunctionCommandCache getInsntace(){
        if (me == null){
            me = new FunctionCommandCache();
        }
        return me;
    }
    
    /**
     * Obtiene el comando a ejecutar
     * @param functionName
     * @return
     * @throws Exception
     */
    public FunctionCommand getCommand(String functionName) throws Exception{
        if (functions.containsKey(functionName)){
            return functions.get(functionName);
        }else{
            throw new Exception("FUNCTION (" + functionName  + ") NO EXISTE");
        }
    }
    
    /**
     * Agrega una funcion
     * @param function
     */
    public void register (FunctionCommand function){
        functions.put(function.getName(), function);
    }
}
