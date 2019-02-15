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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class MainLisp {
    public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    String comando;
    Calculadora calculadora=new Calculadora();
    /* String to Split*/
    System.out.println("Introduzca comando en Lisp que desee ejecutar");
    comando = scan.nextLine();
    /* Con el string se hace split con el delimitador como parametro*/
    String[] items = comando.split(" ");
    /* Se crea una Lista con los item separados anteriormente*/
    List<String> itemList;
        itemList = Arrays.asList(items);
    /* Se imprime el resultado obtenido al operar los elementos de la nueva lista*/
    int resultado=calculadora.resultadodeoperacion(itemList);
    System.out.println("El resultado de tu operacion es: " + resultado);
    
    }
    
}
