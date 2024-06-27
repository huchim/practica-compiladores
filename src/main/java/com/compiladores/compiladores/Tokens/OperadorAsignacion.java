package com.compiladores.compiladores.Tokens;

import com.compiladores.compiladores.Simbolos;

public class OperadorAsignacion extends Token {
    public OperadorAsignacion(String lexema, int line, int column) {
        super(Simbolos.OP_ASSIGN, lexema, line, column, "ASIGNACION");
    }
}
