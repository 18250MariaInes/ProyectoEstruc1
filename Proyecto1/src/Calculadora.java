
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author maria
 */
public class Calculadora {
    List<String> comando = new ArrayList();
    List<Integer> numeros = new ArrayList();
    public int resultadodeoperacion(List<String> n){
        String operacion=n.get(0);
        int resul=0;
        //String item=n.get(0)
        for (int i=0; i<=(n.size()-1); i++){
            int a;
            String item=n.get(i);
            try{
                a=Integer.parseInt(item);
                numeros.add(a);
            }catch(NumberFormatException e){
                //operacion=item+operacion;
            }
        }
        
        if (operacion.equals("+")){
            for(int i=0; i<=(numeros.size()-1);i++){
                resul += numeros.get(i);
            }
        }else if (operacion.equals("-")){
            resul = numeros.get(0);
            for(int i=1; i<=(numeros.size()-1);i++){
                resul -= numeros.get(i);
            }
        }else if (operacion.equals("/")){
            try{
                //se realiza la division si no hay excepcion de denominador 0
                int dato1=numeros.get(0);
                int dato2=numeros.get(1);
                resul=dato1/dato2;
            } catch(ArithmeticException e){
                System.out.print("Error!! Es imposible dividir entre 0\n");
            }
        }else if (operacion.equals("sqrt")){
            resul=(int) Math.sqrt(numeros.get(0));
        }else if (operacion.equals("*")){
            resul = 1;
            for(int i=0; i<=(numeros.size()-1);i++){
                resul *= numeros.get(i);
            }
        }  
        
        return resul;    
    }
    
    
}
