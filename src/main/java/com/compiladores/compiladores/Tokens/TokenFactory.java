package com.compiladores.compiladores.Tokens;

import com.compiladores.compiladores.Simbolos;

public class TokenFactory {
    
    public static final Token crear(int symbolId, String lexema, int line, int column, String ER) {
        switch (symbolId) {
            case Simbolos.ID:
                return  new Identificador(lexema, line, column);
            case Simbolos.NUM:
            return new NumeroDecimal(lexema, line, column);
            case Simbolos.EOF:
            return new FinArchivo();
            case Simbolos.OP_ASSIGN:
            return new OperadorAsignacion(lexema, line, column);
            case Simbolos.UNKNOWN_TOKEN:
                return new TokenDesconocido(lexema, line, column, ER);
            default:
                return new Token(symbolId, lexema, line, column, ER);
        }
    }
}
