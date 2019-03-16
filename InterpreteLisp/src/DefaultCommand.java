/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.lisp.interpreter.context.CommandContext;
import com.lisp.interpreter.operand.Operand;
import java.util.List;

/**
 *
 * @author maria.camila.abril
 */
public class DefaultCommand extends BaseCommand {



    @Override
    public String execute(CommandContext context) throws Exception {
        if (hasNext()){
            ICommand command= getNext();
            return command.execute(context);
        }
        return null;
    }

    @Override
    public void addMappingConstant(String constantV) {
        super.addMappingConstant(constantV); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addMappingVariable(String variable) {
        super.addMappingVariable(variable); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Operand getOperand(int position) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getName() {
        return "DEFAULT";
    }


    
    
    
}