/* 1. Código de usuario */
package com.compiladores.compiladores;

import java.io.*;
import java_cup.runtime.*;
import java.util.ArrayList;
import java_cup.runtime.Symbol;
import com.compiladores.compiladores.Tokens.*;

/* 2. Opciones y declaraciones */
%%
%class AnalizadorSintactico
%cup
%public
%function next_token


/* Tokens básicos */
Digito = [0-9]
Caracter = [a-zA-Z]

/* Espacios */
TerminadorLinea = (\r)|(\n)|(\r\n)
Space          = (" ")|(\t)|(\t\f)

EspaciosBlanco     = {TerminadorLinea}|{Space}

/* Identificadores */
Identificador = {Caracter}({Caracter}|{Digito})*

/* Números */
NumeroDecimal = {Digito}+

/* Operadores */
OperadorIgualdad = ("=")


%type Token
%eofval{
	return TokenFactory.crear(Simbolos.EOF,null, -1,-1, null);
%eofval}

/* Reglas léxicas */
%%

{NumeroDecimal}             { return TokenFactory.crear(Simbolos.NUM, yytext(), yyline, yycolumn, "dd*"); }

/*  Operadores */
{OperadorIgualdad}          { return TokenFactory.crear(Simbolos.OP_ASSIGN, yytext(), yyline, yycolumn, "="); }

/* Identificadores */
{Identificador}             { return TokenFactory.crear(Simbolos.ID, yytext(), yyline, yycolumn, "l(l|d)*"); }

{EspaciosBlanco}                { /* ignore */ }

.  { if (yytext() != null && yytext().length() > 0) return TokenFactory.crear(Simbolos.ERROR, yytext(), yyline, yycolumn, null); } 