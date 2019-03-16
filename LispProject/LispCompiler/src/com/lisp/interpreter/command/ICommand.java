/*
 * Algoritmos y Estructura de datos
 * Proyecto #1 - Compilador LISP
 * 
 */
package com.lisp.interpreter.command;

import com.lisp.interpreter.context.CommandContext;
import java.util.List;

/**
 * Esta interfaz es utilizada para leer los diferentes comandos ingresados
 * @author maria.camila.abril
 */
public interface ICommand {

    /**
     * Devuelve el siguiente comando
     * @return
     */
    public ICommand getNext();

    /**
     * Verifica si hay otro comando
     * @return
     */
    public boolean hasNext();

    /**
     * Establece un comando mas
     * @param command
     */
    public void setNext(ICommand command);    

    /**
     * Ejecuta el comando
     * @param context
     * @return
     * @throws Exception
     */
    public String execute (CommandContext context) throws Exception;
}
