/*
 * Algoritmos y Estructura de datos
 * Proyecto #1 - Compilador LISP
 * 
 */
package com.lisp.interpreter.command;

import com.lisp.interpreter.context.CommandContext;
import com.lisp.interpreter.operand.Operand;
import java.util.List;

/**
 * Esta es la clase extiende a la clase abstracta para analizar los comandos ingresados por el user
 * @author maria.camila.abril
 */
public class DefaultCommand extends BaseCommand {

    /**
     * Ejecuta la funcion
     * @param context
     * @return
     * @throws Exception
     */
    @Override
    public String execute(CommandContext context) throws Exception {
        if (hasNext()){
            ICommand command= getNext();
            return command.execute(context);
        }
        return null;
    }

    /**
     *
     * @param constantV
     */
    @Override
    public void addMappingConstant(String constantV) {
        super.addMappingConstant(constantV); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @param variable
     */
    @Override
    public void addMappingVariable(String variable) {
        super.addMappingVariable(variable); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @param position
     * @return
     */
    @Override
    public Operand getOperand(int position) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @return
     */
    @Override
    public String getName() {
        return "DEFAULT";
    }


    
    
    
}
