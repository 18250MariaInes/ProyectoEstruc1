
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.LinkedHashMap;

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
    //ArrayList<String> operaciones = new ArrayList<>();
    String[] posibles = {"(+", "(-", "(*", "(/","sqrt","(COND","(LIST","(ATOM", "(=", "(<", "(>"};

    public HashMap separar(String usuario) {
        //Se eliminan los parentesis y se crea el hasmap y arraylist que tendra todos los comandos de la linea
        HashMap<String, ArrayList<String>> hashInstrucciones = new LinkedHashMap<>();
        HashMap<String, Object> hashFuncion = new LinkedHashMap<>();
        ArrayList<String> operaciones = new ArrayList<>();
        String[] prueba = usuario.split(" ");
        String primero = prueba[0];
        if(primero.equals("(DEFUN")){
            //Si es la deficion de una funcion
            String name = prueba[1];
            String[] parametros = prueba[2].split("\\(");
            String param = parametros[1];
            parametros = param.split("\\)");
            param = parametros[0];
            parametros = param.split(",");
            String cuerpo = prueba[3];
            String[] opera = cuerpo.split("\\)");
            cuerpo = opera[0];
            hashFuncion.put("nombre", name);
            hashFuncion.put("param", parametros);
            hashFuncion.put("cuerpo", cuerpo);
            System.out.print("Es definicion de funcion!!\n NOMBRE: " + name +"\nPARAMETRO: " +Arrays.toString(parametros)+"\nCUERPO: " + cuerpo);
            System.out.print(hashFuncion);
            return hashFuncion;
        }else if (Arrays.asList(posibles).contains(primero)){
            //Si es algun comando LISP determinado 
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
            System.out.print("\nEl hashMap   "+ hashInstrucciones);
        } else{
            //Si es alguna funcion definida por el user
            System.out.print("\nEs una funcion definida por el user en el txt");
            
        }
        return hashInstrucciones;
    }
    
  
    
}
