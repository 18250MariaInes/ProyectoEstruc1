/*
 * Algoritmos y Estructura de datos
 * Proyecto #1 - Compilador LISP
 * 
 */
package com.lisp.interpreter.command;

import com.lisp.interpreter.constants.Operator;
import com.lisp.interpreter.context.CommandContext;
import com.lisp.interpreter.operand.Operand;
import org.apache.commons.lang3.StringUtils;

/**
 * Clase empleada para ejecutar comandos de operaciones aritmeticas
 * @author maria.camila.abril
 */
public class OperationCommand  extends BaseCommand{
 
    private Operator operator = null;
    private Operand operand1 = null;
    private Operand operand2 = null;
    
    /**
     * 
     * @param operator
     */
    public OperationCommand(Operator operator){
        this.operator = operator;
        operand1 = new Operand();
        operand2 = new Operand();
    }        

    /**
     * ejecuta la operacion luego de realizar una evaluacion de valores y operando
     * @param context
     * @return
     * @throws Exception
     */
    @Override
    public String execute(CommandContext context ) throws Exception {

        
        if (getOperator() == null){
            throw new Exception(getName() + ":OPERADOR NO PUEDE SER NULO");
        }
        if (this.mapping.size() < 2){
            throw new Exception(getName() + ":NO TIENE DEFINIDO OPERANDOS");
        }
        ParameterMapping mapping1= this.mapping.get(0);
        mapTOOperand(mapping1, context, 0);
        
        ParameterMapping mapping2= this.mapping.get(1);
        mapTOOperand(mapping2, context, 1);
        
        String obj1 = getOperand1().resolve(context);
        String obj2 = getOperand2().resolve(context);
        if (!StringUtils.isNumeric(obj1.toString())){
            throw new Exception(getName() + ":VALOR (" + obj1 + ") NO ES NUMERICO");
        }
        if (!StringUtils.isNumeric(obj2.toString())){
            throw new Exception(getName() + ":VALOR (" + obj2 + ") NO ES NUMERICO");
        }
        int result = 0;
        char operchar= getOperator().getValue();
        //Se verifica que tipo de operacion es
        switch(operchar){
            case '+' :
                result = Integer.parseInt(obj1) + Integer.parseInt(obj2);
                break;
            case '-' :
                result = Integer.parseInt(obj1) - Integer.parseInt(obj2);
                break;
            case '*' :
                result = Integer.parseInt(obj1) * Integer.parseInt(obj2);
                break;
            case '/' :
                result = Integer.parseInt(obj1) / Integer.parseInt(obj2);
                break;
            case '<':
                if (Integer.parseInt(obj1)<Integer.parseInt(obj2)){
                    return "true";
                }else{
                    return "nil";
                }
            case '>':
                if (Integer.parseInt(obj1)<Integer.parseInt(obj2)){
                    return "nil";
                }else{
                    return "true";
                }
            case '=':
                if (Integer.parseInt(obj1)==Integer.parseInt(obj2)){
                    return "true";
                }else{
                    return "nil";
                }
            default:
                throw new Exception(getName() + ":OPERADOR NO VALIDO");                
        }
        return Integer.toString(result);
    }

    /**
     * Obtiene y devuelve el operando determinado
     * @param position
     * @return
     */
    @Override
    public Operand getOperand(int position) {
        if (position == 0){
            return this.operand1;
        }
        if (position == 1){
            return this.operand2;
        }
        return null;
    }

    /**
     * Presenta el tipo de comando utilizado
     * @return
     */
    @Override
    public String getName() {
        return this.operator.toString();
    }
    
    
    
    /**
     * @return the operator
     */
    public Operator getOperator() {
        return operator;
    }

    /**
     * @return the operand1
     */
    public Operand getOperand1() {
        return operand1;
    }

    /**
     * @param operand1 the operand1 to set
     */
    public void setOperand1(Operand operand1) {
        this.operand1 = operand1;
    }

    /**
     * @return the operand2
     */
    public Operand getOperand2() {
        return operand2;
    }

    /**
     * @param operand2 the operand2 to set
     */
    public void setOperand2(Operand operand2) {
        this.operand2 = operand2;
    }    
}
