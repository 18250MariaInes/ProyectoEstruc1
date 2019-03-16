/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.lisp.interpreter.context.CommandContext;
import com.lisp.interpreter.operand.Operand;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author maria.camila.abril
 */
public abstract class BaseCommand implements ICommand{

    protected ICommand next = null;
    protected CommandContext context  = null;
    protected List<ParameterMapping> mapping = null;
    
    public BaseCommand(){
        mapping = new ArrayList<ParameterMapping>();
    }
    
    public void mapTOOperand(ParameterMapping parameterMapping, CommandContext context , int position) throws Exception {
        Operand functionParam = getOperand(position);
        if (functionParam == null){
            throw new Exception(getName() + ":OPERANDO NO PUEDE SER NULO (" + position + ")");
        }
        if (parameterMapping.getConstantValue() != null) {
            functionParam.setConstant(true);
            functionParam.setValue(parameterMapping.getConstantValue());
        } else {
            if (parameterMapping.getVariableName() != null) {                
                functionParam.setConstant(false);
                functionParam.setName(parameterMapping.getVariableName());
            } else {
                if (parameterMapping.getCommand() != null){
                    functionParam.setCommand(parameterMapping.getCommand());
                    functionParam.setConstant(false);
                }else{
                    throw new Exception(getName() + ":PARAMETRO (" + parameterMapping.toString() + ") NO SE ENCUENTRA MAPEADO");
                }
            }
        }
    }
    
    public void addMappingConstant (String constantV){
        ParameterMapping p = new ParameterMapping(constantV, true);        
        mapping.add(p);
    }
    
    public void addMappingVariable(String variable){
        ParameterMapping p = new ParameterMapping(variable, false);        
        mapping.add(p);
    }
    
    public void addMappingCommand(BaseCommand command){
        ParameterMapping p = new ParameterMapping(command);
        mapping.add(p);
    }
    
    public abstract Operand getOperand(int position);
    
    @Override
    public ICommand getNext() {
        return next;
    }

    @Override
    public void setNext(ICommand c) {
        this.next = c;
    }
    
    public boolean hasNext(){
        return this.next != null;
    }    
    
    /**
     * @return the mapping
     */
    public List<ParameterMapping> getMapping() {
        return mapping;
    }

    /**
     * @param mapping the mapping to set
     */
    public void setMapping(List<ParameterMapping> mapping) {
        this.mapping = mapping;
    }
    
    public abstract String getName();
}