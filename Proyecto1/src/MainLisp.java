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
import java.util.stream.Stream;
public class MainLisp {
    public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    String comando;
    Calculadora calculadora=new Calculadora();
    HashMap<String, ArrayList<String>> instrucciones = new HashMap<>();
    /* String to Split
    System.out.println("Introduzca comando en Lisp que desee ejecutar");
    comando = scan.nextLine();
    // Con el string se hace split con el delimitador como parametro
    String[] items = comando.split(" ");
    // Se crea una Lista con los item separados anteriormente
    List<String> itemList;
        itemList = Arrays.asList(items);
    // Se imprime el resultado obtenido al operar los elementos de la nueva lista
    int resultado=calculadora.resultadodeoperacion(itemList);
    System.out.println("El resultado de tu operacion es: " + resultado);*/
    //Se lee el .txt
    ArrayList<String> lectura = new ArrayList<>();
    Analizador separador = new Analizador();
    try{
        Stream<String> lines = Files.lines(
            Paths.get("comands.txt"),
            StandardCharsets.UTF_8
        );
        lines.forEach(c -> lectura.add(c));
        for (int i=0; i<=(lectura.size()-1); i++){
            //Se itera la lectura y cada elemento se divide en dos (nombre-tipo)
            String item = lectura.get(i);
            instrucciones = separador.separar(item);
            System.out.print("\nHASH DEL MAIN ----> " + instrucciones);
            System.out.print("\n\n");
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
