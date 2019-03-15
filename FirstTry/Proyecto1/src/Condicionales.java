/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Maria
 *
 */
import java.util.*;
import java.util.Arrays;
public class Condicionales {
    String[] operacionesp = {"(+", "(-", "(*", "(/","(sqrt","(COND","(LIST","(ATOM", "(="};
    String [] operacionespre={"(EQUAL", "(ATOM", "(LIST", "(<", "(>"};
    
    public void condicionar(ArrayList<String> arr){
       
        
        /*
        for (int i=0; i<=arr.size(); i++){
            String [] types=arr.get(i).split(" ");
            String s=types[0];
            int verdad=0;
            for (int m=0; m<=operacionesp.length; m++){
                 if (operacionesp[m]==s){
                     ArrayList<String> operandos=new ArrayList();
                     Calculadora calculadora=new Calculadora();
                     String[] div=arr.get(i).split(" ");
                     for (int n=1; n<=div.length;n++){
                         operandos.add(div[n]);       
                     }
                     verdad=calculadora.resultadodeoperacion(div[0], operandos);
                 }
           }
            for (int L=0; L<=operacionespre.length; L++){
                 if (operacionespre[L]==s){
                     ArrayList<String> operandos=new ArrayList();
                     Predicados predi=new Predicados();
                     String[] div=arr.get(i).split(" ");
                     for (int n=1; n<=div.length;n++){
                         operandos.add(div[n]);       
                     }
                     verdad= predi.evaluarPred(div[0], operandos);
                 }
           }
            if (verdad==1){
                return true;
            }
        }
       
        return false;
*/
    }
}
