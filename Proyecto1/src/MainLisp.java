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
    System.out.println("Introduzca comando en Lisp que desee ejecutar");
    comando=scan.next();
    List<String> operacion = new ArrayList<String>(Arrays.asList(comando.split(" ")));
    System.out.println(operacion.get(1));
    //int resultado=calculadora.resultadodeoperacion(operacion);
    //System.out.println(resultado);
    
    }
    
}
