package com.compiladores.compiladores.Tokens;

import com.compiladores.compiladores.Simbolos;

public class Identificador extends Token {
    public Identificador(String lexema, int line, int column) {
        super(Simbolos.ID, lexema, line, column, "Identificador");
    }
}
