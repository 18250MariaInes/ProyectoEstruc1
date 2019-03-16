/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lisp.interpreter.command;

import com.lisp.interpreter.context.CommandContext;
import com.lisp.interpreter.operand.Operand;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author maria.camila.abril
 */
public class FunctionCommandTest {
    
    /**
     *
     */
    @Test
    public void testAddParam() {
        System.out.println("addParam");
        String param = "SUMA";
        FunctionCommand instance = new FunctionCommand(param);
        instance.addParam(param);
        List<Operand> prueba=instance.getParams();
        boolean result=prueba.isEmpty();
        boolean expResult=false;
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

   

    /**
     * Test of getParam method, of class FunctionCommand.
     * @throws java.lang.Exception
     */
    @Test
    public void testGetParam() throws Exception {
        System.out.println("getParam");
         String param = "SUMA";
        FunctionCommand instance = new FunctionCommand(param);
        instance.addParam(param);
        List<Operand> prueba=instance.getParams();
        boolean result=prueba.isEmpty();
        boolean expResult=false;
        assertEquals(expResult, result);
    }

    
}
