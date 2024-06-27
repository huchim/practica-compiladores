package com.compiladores.compiladores.Tokens;

import com.compiladores.compiladores.Simbolos;

public class TokenDesconocido extends Token {
    public TokenDesconocido(String lexema, int line, int column, String ER) {
        super(Simbolos.UNKNOWN_TOKEN, lexema, line, column, "UnknownToken");
    }
}
