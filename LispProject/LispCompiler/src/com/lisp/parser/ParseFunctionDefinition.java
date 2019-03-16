/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lisp.parser;

import com.lisp.interpreter.command.AtomCommand;
import com.lisp.interpreter.command.BaseCommand;
import com.lisp.interpreter.command.FunctionCommand;
import com.lisp.interpreter.command.FunctionCommandCache;
import com.lisp.interpreter.command.ListCommand;
import com.lisp.interpreter.command.OperationCommand;
import com.lisp.interpreter.constants.Operator;
import java.util.Stack;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author cesar.asada
 */
public class ParseFunctionDefinition {   
   private String functionName = null;
   private String segmentCode = null;
   private String firstLine = null;   
   private Stack<BaseCommand> stack = null;
   
   public ParseFunctionDefinition(String firstLine, String segmentCode){
       this.segmentCode = segmentCode;     
       this.firstLine = firstLine;
       this.stack = new Stack<BaseCommand>();       
   }
   
   public ParseFunctionDefinition(String segmentCode){
       this.segmentCode = segmentCode;     
       this.stack = new Stack<BaseCommand>();       
   }
   
   private OperationCommand getCommand(char operator) throws Exception{
       OperationCommand opc = new OperationCommand(Operator.getBySign(operator));
       return opc;
   }
   
   private void setNextOnTop(BaseCommand command) throws Exception{
       if (stack.size() > 0){
           BaseCommand topCommand = stack.peek();
           System.out.println("ENCADENANDO:" + topCommand.getName() + " CON:" + command.getName());
           
           topCommand.setNext(command);
       }
   }

   private void processSegment(String segment) throws Exception{
       if (StringUtils.startsWith(segment, "(")){
           String operator = StringUtils.substringAfter(segment, "(");
           if (operator.equals("+") || 
                   operator.equals("*") ||
                   operator.equals("-") ||
                   operator.equals("/") ){
               OperationCommand operationCommand = getCommand(operator.charAt(0));
               setNextOnTop(operationCommand);
               stack.push(operationCommand);
           } else {
               if (operator.equals("ATOM")) {
                   AtomCommand atomCommand = new AtomCommand();
                   setNextOnTop(atomCommand);
                   stack.push(atomCommand);
               } else {
                   if (operator.equals("LIST")){
                       ListCommand listCommand = new ListCommand();
                       setNextOnTop(listCommand);
                       stack.push(listCommand);                       
                   }else{
                        FunctionCommand functionCommand = FunctionCommandCache.getInsntace().getCommand(operator);
                        FunctionCommand newCommand = functionCommand.copy();
                        setNextOnTop(newCommand);
                        stack.push(newCommand);
                   }
               }
           }       
           return ;
       }else{
           //si es variable
           if (Character.isLetter(segment.charAt(0))){
               BaseCommand command= this.stack.peek();
               command.addMappingVariable(StringUtils.replace(segment, ")", ""));
           }
           
           //si es constante alfanumerica
           if (StringUtils.startsWith(segment, "\"")){
               BaseCommand command= this.stack.peek();
               segment = StringUtils.replace(segment, ")", "");
               segment = StringUtils.replace(segment, "\"", "");
               command.addMappingConstant(segment);
           }
           
           //si es constante numerica
           if (Character.isDigit(segment.charAt(0))){
               //operador de la funcion TOP.
               BaseCommand command= this.stack.peek();
               segment = StringUtils.replace(segment, ")", "");
               command.addMappingConstant(segment);
           }
           
           //validar si tiene el cierre )
           if (StringUtils.contains(segment, ")")){
               stack.pop();
           }
       }
       
   }
   
   public FunctionCommand parse () throws Exception{
       this.functionName = StringUtils.substringBetween(firstLine, "(DEFUN ", " ");
       FunctionCommand functionCommand = new FunctionCommand(this.functionName);              
       String paramDefs= StringUtils.substringAfter(firstLine, "(DEFUN ");
       paramDefs = StringUtils.substringBetween(paramDefs, "(", ")");
       String[] params= StringUtils.split(paramDefs, " ");
       if (params != null && params.length > 0){
           for (String param : params) {
               functionCommand.addParam(param);
           }
       }    
       parse(functionCommand);
       return functionCommand;
   }
   
   public void parse(FunctionCommand functionCommand) throws Exception{       
       this.stack.push(functionCommand);                
 
       String[] segs= StringUtils.split(segmentCode, " ");
       for (String seg : segs) {
           processSegment(seg);
       }
              
   }
   
}
