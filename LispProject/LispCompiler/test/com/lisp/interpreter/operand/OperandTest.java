/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lisp.interpreter.operand;

import com.lisp.interpreter.context.CommandContext;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Educho
 */
public class OperandTest {
    
    /**
     *
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "Suma";
        Operand instance = new Operand(name, "+");
        instance.setName("Resta");
        String result=instance.getName();
        assertEquals("Resta", result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     *
     */
    @Test
    public void testIsConstant() {
        System.out.println("isConstant");
        Operand instance = new Operand("OP", "+");
        boolean expResult = true;
        boolean result = instance.isConstant();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
}
