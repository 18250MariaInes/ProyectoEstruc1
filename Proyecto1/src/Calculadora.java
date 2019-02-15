
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
        int dato1=numeros.get(0);
        int dato2=numeros.get(1);
        
        if (operacion.equals("+")){
            resul=dato1+dato2;
        }else if (operacion.equals("-")){
            resul=dato1-dato2;
        }else if (operacion.equals("/")){
            resul=dato1/dato2;
        }else if (operacion.equals("sqrt")){
            resul=(int) Math.sqrt(dato1);
        }else if (operacion.equals("*")){
            resul=dato1*dato2;
        }  
        
        return resul;    
    }
    
    
}
