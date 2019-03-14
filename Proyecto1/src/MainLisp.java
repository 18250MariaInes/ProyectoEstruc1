/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author maria
 */
import java.util.*;
 import java.text.*;
 import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.LinkedHashMap ;
import java.util.stream.Stream;
public class MainLisp {
    public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    String comando;
    Calculadora calculadora=new Calculadora();
    Predicados predicado =new Predicados();
    HashMap<String, Object> instrucciones = new LinkedHashMap<>();
    HashMap<String, Funcion> hashFunciones = new LinkedHashMap<>();
    ArrayList<String> lectura = new ArrayList<>();
    Analizador separador = new Analizador();
    try{
        Stream<String> lines = Files.lines(
            Paths.get("comands.txt"),
            StandardCharsets.UTF_8
        );
        lines.forEach(c -> lectura.add(c));
        for (int i=0; i<=(lectura.size()-1); i++){
            System.out.print("-------INSTRUCCION # " +i +"-----------\n");
            //Se itera la lectura y cada elemento se divide en dos (tipo-datos)
            String item = lectura.get(i);
            instrucciones = separador.separar(item);
            HashMap<String,Object> resultados = new LinkedHashMap<>();
            System.out.print("\nHASH DEL MAIN ----> " + instrucciones+"\n");
            for (Map.Entry<String, Object> entry : instrucciones.entrySet()) {
                //Se itera cada dato del Map para obtener cada uno de sus valores
                String clave = entry.getKey();
                Object valor = entry.getValue();
                System.out.println("clave=" + clave + ", valor=" + valor);
                if(clave.equals("+")||clave.equals("-")||clave.equals("/")||clave.equals("*")||clave.equals("sqrt") || clave.equals("=")){
                    int resultado=calculadora.resultadodeoperacion(clave, (List<String>) valor);
                    System.out.println("El resultado de tu operacion es: " + resultado);
                    resultados.put(clave,resultado);
                    System.out.println("El hashmap con resultados: " + resultados);
                }
                else if(clave.equals("COND")){
                    ArrayList<String> cons=new ArrayList();
                    Condicionales cond=new Condicionales();
                    int contadora=1;
                    int contadorb=0;
                    int lineas=0;
                     System.out.println("AQUIIIIIIIIIIIIIIIIIIIIIIII ESTOYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY");
                    System.out.println("contador a:"+contadora);
                    System.out.println("contador b:"+contadorb);
                    System.out.println(lectura.get(i));
                    int m=i;
                    while (contadora!=contadorb){
                        
                        if (contadora==1 && contadorb==0){
                            contadora--;
                        }
                        System.out.println("***********************************ENTRA*********************");
                        
                        for (int p=0; p<lectura.get(m).length(); p++){
                            
                            String palabra=lectura.get(m);
                            char letra=palabra.charAt(p);
                            String s=String.valueOf(letra);
                            //rSystem.out.println(s);
                            if (s.equals("(")){
                                contadora++;
                            }else if (s.equals(")")){
                                contadorb++;
                            }
                        }
                        //System.out.println(m);
                        cons.add(lectura.get(m));
                        lineas++;
                        //lectura.remove(i);
                        System.out.println("contador a ADENTRO:"+contadora);
                        System.out.println("contador b ADENTRO:"+contadorb);
                        m++;
                    }
                    
                    System.out.println("----------ESTAS SON CONDS--------"+cons);
                    i=i+(lineas-1);
                    boolean resul=cond.condicionar(cons);
                    System.out.println(resul);
                    
                }
                else if(clave.equals("EQUAL")||clave.equals(">")||clave.equals("<")||clave.equals("ATOM")||clave.equals("LIST")){
                    int resultadoPred = predicado.evaluarPred(clave, (List<String>) valor);
                    resultados.put(clave,resultadoPred);
                    System.out.println("El resultado de tu operacion es: " + resultadoPred);
                    System.out.println("El hashmap con resultados: " + resultados);
                }
                else{
                    //Si no es ninguno de los anteriores significa que es una funcion definida por el user
                    
                }
            }
            System.out.print("\nAhora se recorre el Hashmap de resultados para operarlos todos\n");
            
            ArrayList<String> keyList = new ArrayList(resultados.keySet());
            ArrayList<Integer> aOperar = new ArrayList<>();
            int resulFinal;
            System.out.print("\nOperadores: " + keyList+"\n");
            String ope = "";
            for ( int mi = keyList.size() - 1; mi >= 0; mi--) {
		//get key
		String key = keyList.get(mi);
                ope = key;
		System.out.println("Key :: " + key);
		//get value corresponding to key
		Object value = resultados.get(key);
                aOperar.add((Integer) value);
		System.out.println("Value :: " + value);
		System.out.println("--------------------------------" + mi);
            }
            System.out.print("\nPrincipal: "+ope+"\n");
            System.out.print(aOperar);
            resulFinal = calculadora.total(ope,aOperar);
            if (ope.equals("EQUAL")||ope.equals(">")||ope.equals("<")||ope.equals("ATOM")||ope.equals("LIST")){
                if(resulFinal==1){
                    System.out.print("T");
                }else{
                    System.out.print("Nill");
                }
                System.out.print("\n\n");
            }else{
                System.out.print(resulFinal);
                System.out.print("\n\n");
            }
            
        }
        
    } catch (IOException e){
            System.out.println("Error al leer el archivo");
    }
    /*Analizador separador = new Analizador();
    instrucciones = separador.separar("(LIST 1 2 3 4 5(+ 8 9)))");
    System.out.print("\nHASH DEL MAIN ----> " + instrucciones);
    System.out.print("\n\n");
    instrucciones = separador.separar("(DEFUN queTanBienLeCaigoADiego (nombre) 0)");
    System.out.print("\nHASH DEL MAIN ----> " +instrucciones);*/
    }
    
    
}
