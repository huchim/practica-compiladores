package com.compiladores.compiladores.Tokens;

import com.compiladores.compiladores.Simbolos;

public class NumeroDecimal extends Token {
    public NumeroDecimal(String lexema, int line, int column) {
        super(Simbolos.NUM, lexema, line, column, "NUM");
    }
}
