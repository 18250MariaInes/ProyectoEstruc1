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
 *  Esta clase se utiliza para utilizar comandos de ATOM
 * @author maria.camila.abril
 */
public class AtomCommand extends BaseCommand{

    private List<Operand> params = null;
    
    /**
     * establece los operandos a utilizar
     */
    public AtomCommand(){
        this.params = new ArrayList<Operand>();
    }
    
    /**
     * Devuelve el operando establecido
     * @param position
     * @return
     */
    @Override
    public Operand getOperand(int position) {
        return params.get(position);
    }

    /**
     * Devuelve el tipo
     * @return
     */
    @Override
    public String getName() {
        return "ATOM";
    }

    /**
     * 
     * @param context
     * @return
     * @throws Exception
     */
    @Override
    public String execute(CommandContext context) throws Exception {
        
        
        if (this.mapping.size() == 1){
            return "true";
        }else{
            return "nil";
        }
    }
    
}
