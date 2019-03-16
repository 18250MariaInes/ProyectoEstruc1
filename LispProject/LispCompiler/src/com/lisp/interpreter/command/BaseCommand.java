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
 * Esta es la clase abstracta para analizar los comandos ingresados por el user
 * @author maria.camila.abril
 */
public abstract class BaseCommand implements ICommand{

    /**
     *
     */
    protected ICommand next = null;

    /**
     * Permite ver el contexto del comando
     */
    protected CommandContext context  = null;

    /**
     * Consiste en los valores a operar
     */
    protected List<ParameterMapping> mapping = null;
    
    /**
     *
     */
    public BaseCommand(){
        mapping = new ArrayList<ParameterMapping>();
    }
    
    /**
     *
     * @param parameterMapping
     * @param context
     * @param position
     * @throws Exception
     */
    public void mapTOOperand(ParameterMapping parameterMapping, CommandContext context , int position) throws Exception {
        Operand functionParam = getOperand(position);
        if (functionParam == null){
            throw new Exception(getName() + ":OPERANDO NO PUEDE SER NULO (" + position + ")");
        }
        if (parameterMapping.getConstantValue() != null) {
            functionParam.setConstant(true);
            functionParam.setValue(parameterMapping.getConstantValue());
        } else {
            if (parameterMapping.getVariableName() != null) {                
                functionParam.setConstant(false);
                functionParam.setName(parameterMapping.getVariableName());
            } else {
                throw new Exception(getName() + ":PARAMETRO (" + parameterMapping.toString() + ") NO SE ENCUENTRA MAPEADO");
            }
        }
    }
    
    /**
     * Agrega al ArrayList una constante
     * @param constantV
     */
    public void addMappingConstant (String constantV){
        ParameterMapping p = new ParameterMapping(constantV, true);        
        mapping.add(p);
    }
    
    /**
     * Agrega al ArrayList una variable
     * @param variable
     */
    public void addMappingVariable(String variable){
        ParameterMapping p = new ParameterMapping(variable, false);        
        mapping.add(p);
    }
    
    /**
     * Obtiene la posicion del operando
     * @param position
     * @return
     */
    public abstract Operand getOperand(int position);
    
    /**
     * Devuelve el siguiente comando
     * @return
     */
    @Override
    public ICommand getNext() {
        return next;
    }

    /**
     * Establece el siguiente parametro
     * @param c
     */
    @Override
    public void setNext(ICommand c) {
        this.next = c;
    }
    
    /**
     * Verifica si todavia hay comandos 
     * @return
     */
    public boolean hasNext(){
        return this.next != null;
    }    
    
    /**
     * @return the mapping analizado
     */
    public List<ParameterMapping> getMapping() {
        return mapping;
    }

    /**
     * @param mapping the mapping a settear
     */
    public void setMapping(List<ParameterMapping> mapping) {
        this.mapping = mapping;
    }
    
    /**
     *
     * @return
     */
    public abstract String getName();
}
