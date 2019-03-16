/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lisp.interpreter.command;

/**
 *
 * @author cesar.asada
 */
public class ParameterMapping {
    private String variableName = null;
    private String constantValue = null;
    
    
    public ParameterMapping(String s, boolean isConstant){
        if (isConstant){
            this.constantValue = s;            
        }else{
            this.variableName = s;
        }
    }
     

    /**
     * @return the variableName
     */
    public String getVariableName() {
        return variableName;
    }

    /**
     * @param variableName the variableName to set
     */
    public void setVariableName(String variableName) {
        this.variableName = variableName;
    }

    /**
     * @return the constantValue
     */
    public String getConstantValue() {
        return constantValue;
    }

    /**
     * @param constantValue the constantValue to set
     */
    public void setConstantValue(String constantValue) {
        this.constantValue = constantValue;
    }

    
    
}
