/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lisp.interpreter.constants;

/**
 *
 * @author cesar.asada
 */
public enum Operator {
    PLUS('+'), MINUS('-'), MULTIPLY('*'), DIV('/'), MINOR('<'), MAYOR('>'), EQ('=');
    
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
