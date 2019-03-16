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
public class AtomCommand extends BaseCommand{

    private List<Operand> params = null;
    
    public AtomCommand(){
        this.params = new ArrayList<Operand>();
    }
    
    @Override
    public Operand getOperand(int position) {
        return params.get(position);
    }

    @Override
    public String getName() {
        return "ATOM";
    }

    @Override
    public String execute(CommandContext context) throws Exception {
        
        
        if (this.mapping.size() == 1){
            return "true";
        }else{
            return "nil";
        }
    }
    
}