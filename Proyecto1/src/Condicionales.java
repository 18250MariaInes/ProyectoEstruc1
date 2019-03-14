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
    String[] operacionesp = {"(+", "(-", "(*", "(/","sqrt","(COND","(LIST","(ATOM", "(=", "(<", "(>"};
    
    public void condicionar(String[] arr){
        int contadora=1;
        int contadorb=0;
        for (int i=0; i<=arr.length; i++){
            if (arr[i].contains("(")){
                contadora++;
            }
            if (arr[i].contains(")")){
                contadorb++;
            }
            if (contadora!=contadorb){
                System.out.println("ERROR DE SINTAXIS EN CONDICIONAL");
                break;
            }
            for (int e=0; e<=arr[i].length(); e++){
                String palabra=arr[i];
                char letra=palabra.charAt(e);
                String s=String.valueOf(letra);
                for (int m=0; m<=operacionesp.length; m++){
                    if (operacionesp[m]==s){
                        ArrayList<String> operandos=new ArrayList();
                        Calculadora calculadora=new Calculadora();
                        String[] div=arr[i].split(" ");
                        for (int n=1; n<=div.length;n++){
                            operandos.add(div[n]);
                                 
                        }
                        calculadora.resultadodeoperacion(div[0], operandos);
                    }
                }
            }
        }
        
    }
}
