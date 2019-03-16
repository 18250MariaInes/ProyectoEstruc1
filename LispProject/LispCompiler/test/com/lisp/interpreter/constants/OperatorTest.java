/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lisp.interpreter.constants;

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
public class OperatorTest {
    
    /**
     *
     * @throws Exception
     */
    @Test
    public void testGetBySign() throws Exception {
        System.out.println("getBySign");
        char sign = '/';
        Operator result=Operator.getBySign(sign);
        System.out.println("            "+result);
        Operator exp=Operator.getBySign(sign);
        assertEquals(exp, result);
        
        
    }
}
