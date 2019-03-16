/*
 * Algoritmos y Estructura de datos
 * Proyecto #1 - Compilador LISP
 * 
 */
package com.lisp.interpreter.operand;

import com.lisp.interpreter.command.BaseCommand;
import com.lisp.interpreter.context.CommandContext;

/**
 * permite tener control de que operacion sera la que se ejecutara
 * @author maria.camila.abril
 */
public class Operand {

    /**
     * @param value the value to set
     */
    public void setValue(String value) {
        this.value = value;
    }
    private String name = null;
    private String value = null;
    private boolean constant = false;
    private BaseCommand command = null;
    
    /**
     * Constructor
     */
    public Operand(){
        this.constant = true;
    }
    
    /**
     * Establece el nombre y los valores de la operacion
     * @param name
     * @param constValue
     */
    public Operand(String name, String constValue){
        this.name = name;
        this.value = constValue;
        this.constant = true;
    }
    
    /**
     * Establece el nombre
     * @param name
     */
    public Operand (String name){
        this.name = name;
    }
    
    /**
     * Determina el nombre y el comando 
     * @param name
     * @param command
     */
    public Operand (String name, BaseCommand command){
        this.name = name;
        this.command = command;
    }    
    
    /**
     * Evalua si el operando se puede operar
     * @param ctx
     * @return
     * @throws Exception
     */
    public String resolve(CommandContext ctx) throws Exception{
        if (constant){
            return getValue();
        }else{
            if (name != null){
                return ctx.getValue(name);
            }else{
                if (command != null){
                    return command.execute(ctx);                    
                }else{
                    throw new Exception("OPERANDO NO ES VALIDO");
                }
            }
        }
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the value
     */
    public String getValue() {
        return value;
    }

    /**
     * @return the constant
     */
    public boolean isConstant() {
        return constant;
    }

    /**
     * @param constant the constant to set
     */
    public void setConstant(boolean constant) {
        this.constant = constant;
    }
    
    
}
