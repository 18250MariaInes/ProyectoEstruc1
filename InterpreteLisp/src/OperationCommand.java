/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author maria.camila.abril
 */
public class OperationCommand  extends BaseCommand{
 
    private Operator operator = null;
    private Operand operand1 = null;
    private Operand operand2 = null;
    
    public OperationCommand(Operator operator){
        this.operator = operator;
        operand1 = new Operand();
        operand2 = new Operand();
    }        

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
        if (obj1 == null || !StringUtils.isNumeric(obj1.toString())){
            throw new Exception(getName() + ":VALOR (" + obj1 + ") NO ES NUMERICO o no es valido");
        }
        if (obj2 == null || !StringUtils.isNumeric(obj2.toString())){
            throw new Exception(getName() + ":VALOR (" + obj2 + ") NO ES NUMERICO o no es valido");
        }
        int result = 0;
        char operchar= getOperator().getValue();
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
            default:
                throw new Exception(getName() + ":OPERADOR NO VALIDO");                
        }
        return Integer.toString(result);
    }

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
