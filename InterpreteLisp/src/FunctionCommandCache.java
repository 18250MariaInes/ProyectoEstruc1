/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author maria.camila.abril
 */
public class FunctionCommandCache {
    private Map<String, FunctionCommand> functions = null;
    
    public FunctionCommandCache(){
        functions = new HashMap<String, FunctionCommand>();                
    }
    
    private static FunctionCommandCache me = null;
    
    public static FunctionCommandCache getInsntace(){
        if (me == null){
            me = new FunctionCommandCache();
        }
        return me;
    }
    
    public FunctionCommand getCommand(String functionName) throws Exception{
        if (functions.containsKey(functionName)){
            return functions.get(functionName);
        }else{
            throw new Exception("FUNCTION (" + functionName  + ") NO EXISTE");
        }
    }
    
    public void register (FunctionCommand function){
        functions.put(function.getName(), function);
    }
}