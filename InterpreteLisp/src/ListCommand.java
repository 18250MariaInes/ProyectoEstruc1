/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.lisp.interpreter.context.CommandContext;
import com.lisp.interpreter.operand.Operand;

/**
 *
 * @author maria.camila.abril
 */
public class ListCommand extends BaseCommand{
    
    public ListCommand(){
        
    }

    @Override
    public Operand getOperand(int position) {
        return null;
    }

    @Override
    public String getName() {
        return "LIST";
    }

    @Override
    public String execute(CommandContext context) throws Exception {
        if (this.mapping != null && this.mapping.size() > 1){
            return "true";
        }
        return "nil";
    }
    
}
