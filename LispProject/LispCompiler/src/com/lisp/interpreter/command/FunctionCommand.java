/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lisp.interpreter.command;

import com.lisp.interpreter.context.CommandContext;
import com.lisp.interpreter.operand.Operand;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cesar.asada
 */
public class FunctionCommand extends BaseCommand implements Cloneable{
    private String name = null;
    private List<Operand> params = null;
    
    public FunctionCommand(String name){
        this.name = name;
        params = new ArrayList<Operand>();
    }

    @Override
    public Operand getOperand(int position) {
        return params.get(position);
    }  

    public void addParam(String param){
        Operand operand = new Operand(param);
        this.params.add(operand);
    }
    
    @Override
    public String execute(CommandContext contex) throws Exception {
        CommandContext localContext = new CommandContext();
        int pos=0;
        for (Operand functionParam : params) {             
            ParameterMapping paramMapping= mapping.get(pos);
            localContext.setValue(functionParam.getName(), paramMapping.getConstantValue());
            pos++;
        }        
        
        if (hasNext()){
            ICommand nextCommand = getNext();
            return nextCommand.execute(localContext);
        }else{
            throw new Exception("[" + name + "]NO SE PERMITEN FUNCIONES VACIAS");
        }        
    }
    
    public Operand getParam(int paramPos) throws Exception{
        if (paramPos < params.size()){
            Operand operand= params.get(paramPos);            
            return operand;
        }else{
            throw new Exception("PARAMETRO EN POSICION (" + paramPos + ") NO ES VALIDO");
        }        
    }

    
    public FunctionCommand copy() throws CloneNotSupportedException {
        FunctionCommand newObj = new FunctionCommand(this.getName());
        for (Operand param : params) {
            newObj.params.add(param);
        }
        newObj.setNext(this.getNext());
        
        return newObj;
    }
    
    

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the params
     */
    public List<Operand> getParams() {
        return params;
    }
    
    
}
