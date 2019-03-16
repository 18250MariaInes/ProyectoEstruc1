/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author maria.camila.abril
 */
public class ParameterMapping {

    private String variableName = null;
    private String constantValue = null;
    private BaseCommand command = null;
    
    public ParameterMapping(String s, boolean isConstant){
        if (isConstant){
            this.constantValue = s;            
        }else{
            this.variableName = s;
        }
    }
    
    public ParameterMapping(BaseCommand command){
        this.command = command;
    }

    /**
     * @return the variableName
     */
    public String getVariableName() {
        return variableName;
    }

    /**
     * @param variableName the variableName to set
     */
    public void setVariableName(String variableName) {
        this.variableName = variableName;
    }

    /**
     * @return the constantValue
     */
    public String getConstantValue() {
        return constantValue;
    }

    /**
     * @param constantValue the constantValue to set
     */
    public void setConstantValue(String constantValue) {
        this.constantValue = constantValue;
    }

    /**
     * @return the command
     */
    public BaseCommand getCommand() {
        return command;
    }    
    
}