/*
 * Algoritmos y Estructura de datos
 * Proyecto #1 - Compilador LISP
 * 
 */
package com.lisp.interpreter.constants;

/**
 * Constantes que se pueden necesitar
 * @author maria.camila.abril
 */
public enum Operator {

    /**
     * 
     */
    PLUS('+'),

    /**
     *
     */
    MINUS('-'),

    /**
     *
     */
    MULTIPLY('*'),

    /**
     *
     */
    DIV('/'),

    /**
     *
     */
    MINOR('<'),

    /**
     *
     */
    MAYOR('>'),

    /**
     *
     */
    EQ('=');
    
    private char value = ' ';
    
    private Operator(char v){
        this.value = v;
    }

    /**
     * @return the value
     */
    public char getValue() {
        return value;
    }
    
    /**
     *
     * @param sign
     * @return
     * @throws Exception
     */
    public static Operator getBySign(char sign) throws Exception{
        Operator[] ops= Operator.values();
        for (Operator op : ops) {
            if (op.value == sign){
                return op;
            }
        }
        throw new Exception("SIGNO NO DEFINIDO (" + sign + ")");
    }
    
    
}
