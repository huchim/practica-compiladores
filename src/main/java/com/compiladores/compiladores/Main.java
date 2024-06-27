/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.compiladores.compiladores;

import com.compiladores.compiladores.Tokens.Token;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

/**
 *
 * @author DA227
 */
public class Main {

    public static void main( String[] args ) throws IOException
    {
        String entrada = "demo=10";
        Reader sr = new StringReader(entrada);
        AnalizadorLexico lx = new AnalizadorLexico(sr);
        
        Token tk = lx.next_token();
        
        while(tk.getLexema()!=null) {
            System.out.println(tk.getER());
            tk = lx.next_token();
        }

    }
}
