
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Camila
 */
public class Analizador {
    ArrayList<String> operaciones = new ArrayList<>();
    HashMap<String, ArrayList<String>> hashInstrucciones = new HashMap<>();

    public HashMap separar(String usuario) {
        //Se eliminan los parentesis
        String[] prueba = usuario.split(" ");
        String primero = prueba[0];
        if(primero.equals("(DEFUN")){
            String name = prueba[1];
            String param = prueba[2];
            String cuerpo = prueba[3];
            System.out.print("es definicion de funcion, NOMBRE: " + name +"\nPARAMETRO: " +param+"\nCUERPO: " + cuerpo);
        }else{
            String[] arr = usuario.split("\\(");
            String ultimo = arr[arr.length - 1];
            String[] last = ultimo.split("\\)");
            //Cada item dentro de cada ( ) se agrega como un solo String a una posicion del ArrayList
            for (int i =1; i< (arr.length - 1);i++){
                operaciones.add(arr[i]);
            }
            operaciones.add(last[0]);
            //Contador de cuantos items hay en el array
            int numDatos = operaciones.size();
            System.out.print("Num de operaciones: " + numDatos);
            for (int c=0; c < numDatos;c++){
                //Se itera cada comando ingresado, es decir cada item del array
                String comando = operaciones.get(c);
                System.out.print("\n" +operaciones.get(c));
                // Con el string se hace split con el delimitador como parametro
                String[] items = comando.split(" ");
                // Se crea una Lista con los item separados anteriormente
                List<String> comandoList;
                comandoList = Arrays.asList(items);
                ArrayList<String> values = new ArrayList<>();
                for(int m=1; m<comandoList.size();m++){
                    values.add(comandoList.get(m));
                }
                hashInstrucciones.put(comandoList.get(0), values);
                //Este array se pasa como parametro a la funcion Evaluar par determinar que comando es
            }
            System.out.print("\nEl hashMap   "+hashInstrucciones);
        } 
        return hashInstrucciones;
    }
    
    public String evaluar(List<String> comandoList){
        //Esta funcion evalua que tipo de comando es
        if (comandoList.get(0).equals("DEFUN")){
            //si es la definicion de una funcion
        } else if (operaciones.size()==1 && (operaciones.get(0).equals("+")||operaciones.get(0).equals("-")||operaciones.get(0).equals("/")||operaciones.get(0).equals("*")||operaciones.get(0).equals("sqrt"))){
            //Si se tiene solo una operacion 
        }
            return "hola";
    }
    
}
