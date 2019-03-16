/*
 * Algoritmos y Estructura de datos
 * Proyecto #1 - Compilador LISP
 * 
 */
package com.lisp.interpreter.command;

import com.lisp.interpreter.context.CommandContext;
import com.lisp.interpreter.operand.Operand;

/**
 * Esta clase se emplea para poder utilizar comandos de tipo LIST
 * @author maria.camila.abril
 */
public class ListCommand extends BaseCommand{
    
    /**
     *
     */
    public ListCommand(){
        
    }

    /**
     * Obtiene el operando a utilizar
     * @param position
     * @return
     */
    @Override
    public Operand getOperand(int position) {
        return null;
    }

    /**
     * Devuelve el tipo de comando 
     * @return
     */
    @Override
    public String getName() {
        return "LIST";
    }

    /**
     * Ejecuta el predicado LIST
     * @param context
     * @return
     * @throws Exception
     */
    @Override
    public String execute(CommandContext context) throws Exception {
        if (this.mapping != null && this.mapping.size() > 1){
            return "true";
        }
        return "nil";
    }
    
}
