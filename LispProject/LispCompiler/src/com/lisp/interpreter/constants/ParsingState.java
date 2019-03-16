/*
 * Algoritmos y Estructura de datos
 * Proyecto #1 - Compilador LISP
 * 
 */
package com.lisp.interpreter.constants;

/**
 * Estados que se pueden presentar en los comandos
 * @author maria.camila.abril
 */
public enum ParsingState {

    /**
     *
     */
    INIT,

    /**
     *
     */
    ROOT,

    /**
     *
     */
    DEFUN,

    /**
     *
     */
    OPERATION,

    /**
     *
     */
    OPERATOR,

    /**
     *
     */
    INIT_OPERAND,

    /**
     *
     */
    END_OPERAND;
}
