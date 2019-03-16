/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.lisp.interpreter.context.CommandContext;
import java.util.List;

/**
 *
 * @author maria.camila.abril
 */
public interface ICommand {
    public ICommand getNext();
    public boolean hasNext();
    public void setNext(ICommand command);    
    public String execute (CommandContext context) throws Exception;
}
