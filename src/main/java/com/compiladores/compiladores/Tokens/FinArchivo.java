package com.compiladores.compiladores.Tokens;

import com.compiladores.compiladores.Simbolos;

public class FinArchivo extends Token {
    public FinArchivo() {
        super(Simbolos.EOF, null, -1,-1, null);
    }
}
