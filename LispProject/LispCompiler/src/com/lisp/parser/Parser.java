/*
 * Algoritmos y Estructura de datos
 * Proyecto #1 - Compilador LISP
 * 
 */
package com.lisp.parser;

import com.lisp.interpreter.command.FunctionCommand;
import com.lisp.interpreter.command.FunctionCommandCache;
import com.lisp.interpreter.command.RootCommand;
import com.lisp.interpreter.constants.ParsingState;
import java.io.BufferedReader;
import org.apache.commons.lang3.StringUtils;

/**
 * Clase para analizar y decodificar el txt
 * @author maria.camila.abril
 */
public class Parser {
    
    private BufferedReader reader = null;
    private ParsingState state = null;
    private RootCommand rootFunction = null;
    private StringBuffer segment = new StringBuffer();
    private String functionFirstLine = null;
    
    /**
     * crea los objetos utiles para la lectura
     * @param reader
     */
    public Parser(BufferedReader reader){
        this.reader = reader;
        this.state = ParsingState.INIT;
    }

    private void clearSegment (){
        segment.delete(0, segment.length());
    }
    
    private void processLine(String line) throws Exception{
        //Ve en donde empieza y termina las definiciones y el root
        line = StringUtils.strip(line);        
        if (state.equals(ParsingState.INIT)){
            if (StringUtils.startsWith(line, "(DEFUN ")){
                state = ParsingState.DEFUN;
                processLine(line);
                return;
            }
            if (StringUtils.startsWith(line, "//root")){
                state = ParsingState.ROOT;
                clearSegment();
                this.functionFirstLine = null;
                processLine(line);
                return;
            }
        }
        if (state.equals(ParsingState.DEFUN)){
            if (StringUtils.equals(line, "//root")){
                this.state = ParsingState.ROOT;
                processLine(line);
                return;
            }
            if (this.functionFirstLine == null){
                this.functionFirstLine = line;      
            }else{
                if (StringUtils.equals(line, ")//fin")){                    
                    ParseFunctionDefinition parseFunction = new ParseFunctionDefinition(this.functionFirstLine
                            , this.segment.toString());
                    FunctionCommand parsedFunction= parseFunction.parse();
                    FunctionCommandCache.getInsntace().register(parsedFunction);
                    clearSegment();                    
                    this.functionFirstLine = null;
                }else{
                    segment.append(line);
                    segment.append(" ");                    
                }
            }
        }
        if (state.equals(ParsingState.ROOT)){
            if (StringUtils.startsWith(line, "(DEFUN ")){
                throw new Exception("NO SE PUEDEN DEFINIR FUNCIONES DESPUES DEL CODIGO ROOT");
            }
            if (StringUtils.startsWith(line, "//fin root")){
                if (rootFunction == null){
                    throw new Exception("CUERPO DE ROOT NO DEFINIDO");
                }else{
                    ParseFunctionDefinition parserFunction = new ParseFunctionDefinition(segment.toString());
                    parserFunction.parse(rootFunction);
                    
                }
            } else {
                if (StringUtils.equals(line, "//root")){
                    if (rootFunction == null) {
                        rootFunction = new RootCommand();
                    }
                }else{
                    segment.append(line);
                    segment.append(" ");
                }
            }
            
        }
    }
    
    /**
     *
     * @return
     * @throws Exception
     */
    public RootCommand parse() throws Exception{
        String line = null;

        while ((line = reader.readLine()) != null){
            processLine(line);
        }
        
        return this.rootFunction;
    }
}
