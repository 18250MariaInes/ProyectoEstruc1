/*
 * Algoritmos y Estructura de datos
 * Proyecto #1 - Compilador LISP
 * 
 */
package com.lisp.interpreter.command;

/**
 * Esta es la clase que se emplea para hacer mapping de los parametros recibidos
 * @author maria.camila.abril
 */
public class ParameterMapping {
    private String variableName = null;
    private String constantValue = null;
    
    /**
     * Determina si el parametro es variable o constante y lo establece
     * @param s
     * @param isConstant
     */
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
