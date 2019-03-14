
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Camila
 */
public class Predicados {
    
    public int evaluarPred(String pred, List<String> vals){
        List<Integer> valores = new ArrayList();
        String predicado = pred;
        int resul=0;
        int hayLetra =0;
        if(predicado.equals("ATOM")||predicado.equals("LIST")||predicado.equals("<")||predicado.equals(">")){
            for (int i=0; i<=(vals.size()-1); i++){
                int a;
                String item=vals.get(i);
                try{
                    a=Integer.parseInt(item);
                    valores.add(a);
                }catch(NumberFormatException e){
                    //si no es un numero significa que es una variable y eso no es nill para ATOM y LIST
                    hayLetra = 1;
                    valores.add(0);
                }
            }
            if(predicado.equals("ATOM")){
                //Si hay mas de un elemento es nill al igual si se intento agregar una variable sin valor definido
                if (valores.size()>1){
                    resul = 0;
                } else if((valores.size()==1)&&(hayLetra==0)){
                    //Si solo se evalua un valor y no es una letra es T
                    resul = 1;
                }
            } else if (predicado.equals("LIST")){
                //Si hay mas uno o mas elementos es T al igual si no se intento agregar una variable sin valor definido
                if ((valores.size()>=1)&&(hayLetra==0)){
                    resul = 1;
                } else if((valores.size()>=1)&&(hayLetra==1)){
                    //Si se evalua un o mas valor y hay una letra es Nill
                    resul = 0;
                } 
            } else if (predicado.equals(">")){
                int dato1=valores.get(0);
                int dato2=valores.get(1);
                if (dato1>dato2){
                    resul= 1;
                }else{
                    resul= 0;
                }
            } else if (predicado.equals("<")){
                int dato1=valores.get(0);
                int dato2=valores.get(1);
                if (dato1<dato2){
                    resul= 1;
                }else{
                    resul= 0;
                }
            } 
            
        } else if (predicado.equals("EQUAL")){
            String word1 = vals.get(0);
            String word2 = vals.get(1);
            //para que devuelva T los valores tienen que ser exactamente iguales
            if(word1.equals(word2)){
                resul = 1;
            }else{
                resul =0;
            }
        }
       
        return resul;
    }
}
