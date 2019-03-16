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
public enum ParsingState {
    INIT, ROOT, DEFUN, OPERATION, OPERATOR, INIT_OPERAND, END_OPERAND;
}
