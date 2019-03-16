/*
 * Algoritmos y Estructura de datos
 * Proyecto #1 - Compilador LISP
 * 
 */
package com.lisp.interpreter.command;

import com.lisp.interpreter.context.CommandContext;
import com.lisp.interpreter.operand.Operand;
import java.util.ArrayList;
import java.util.List;

/**
 * Esta es la clase que se emplea para definir funciones
 * @author maria.camila.abril
 */
public class FunctionCommand extends BaseCommand implements Cloneable{
    private String name = null;
    private List<Operand> params = null;
    
    /**
     * Define el nombre
     * @param name
     */
    public FunctionCommand(String name){
        this.name = name;
        params = new ArrayList<Operand>();
    }

    /**
     *  devuelve la un operando determinado
     * @param position
     * @return
     */
    @Override
    public Operand getOperand(int position) {
        return params.get(position);
    }  

    /**
     * Agrega un nuevo parametro
     * @param param
     */
    public void addParam(String param){
        Operand operand = new Operand(param);
        this.params.add(operand);
    }
    
    /**
     * Ejecuta la funcion
     * @param contex
     * @return
     * @throws Exception
     */
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
    
    /**
     * Devuelve un operando determinado
     * @param paramPos
     * @return
     * @throws Exception
     */
    public Operand getParam(int paramPos) throws Exception{
        if (paramPos < params.size()){
            Operand operand= params.get(paramPos);            
            return operand;
        }else{
            throw new Exception("PARAMETRO EN POSICION (" + paramPos + ") NO ES VALIDO");
        }        
    }

    /**
     * 
     * @return
     * @throws CloneNotSupportedException
     */
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
