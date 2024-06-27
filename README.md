# Compiladores

## Requisitos

- Instalar Java JDK
  - https://www.oracle.com/java/technologies/downloads/#jdk22-windows
- Descargar JFlex
  - https://github.com/jflex-de/jflex/releases/download/v1.9.1/jflex-1.9.1.tar.gz
- Verificar variables de entorno:
  - `JAVA_HOME=C:\Program Files\Java\jdk-22`
  - `JFLEX_HOME=C:\Users\da227\Downloads\Demo1\jflex-1.9.1`
- Instalar NetBeans
  - https://www.apache.org/dyn/closer.lua/netbeans/netbeans-installers/22/Apache-NetBeans-22-bin-windows-x64.exe
- Compilar proyecto (F11)

## Introducción

El archivo `./src/*main/jflex/lex.flex` contiene las reglas necesarias para el analizador sintáctico.

Este archivo contiene 3 secciones.

### Sección de código de usuario.

JFlex genera un archivo que es el que funcionará como analizador sintáctico.

```java
/* 1. Código de usuario */
package com.compiladores.compiladores;

import java.io.*;
import java_cup.runtime.*;
import java.util.ArrayList;
import java_cup.runtime.Symbol;
import com.compiladores.compiladores.Tokens.*;
```

### Opciones y declaraciones

La segunda sección, corresponde a las opciones para generar el archivo:

```lex
%class AnalizadorSintactico
%cup
%public
%function next_token
```

Al igual que la definición de cada uno de los tokens.

```jflex
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
```

### Reglas léxicas

Esta sección creará el código necesario para devolver cada uno de los tokens.

```jflex
{NumeroDecimal}             { return TokenFactory.crear(Simbolos.NUM, yytext(), yyline, yycolumn, "dd*"); }

/*  Operadores */
{OperadorIgualdad}          { return TokenFactory.crear(Simbolos.OP_ASSIGN, yytext(), yyline, yycolumn, "="); }

/* Identificadores */
{Identificador}             { return TokenFactory.crear(Simbolos.ID, yytext(), yyline, yycolumn, "l(l|d)*"); }

{EspaciosBlanco}                { /* ignore */ }

.  { if (yytext() != null && yytext().length() > 0) return TokenFactory.crear(Simbolos.ERROR, yytext(), yyline, yycolumn, null); } 
```

## Estructura del proyecto.

Los archivos se encuentran ubicados en `./src/main/java` y `.src/main/jflex`.

Cada token que acepta el programa se encuentra declarado en la clase `Token`. Para poder especializar más la clase, se ha creado una clase que derive de `Token` por cada uno de los tokens soportados. Lo anterior tiene la finalidad de poder más adelante reconocer o asignar funciones específicas a cada tipo de tokens. Un ejemplo de token es la clase `OperadorAsignacion -> Token`.

### Crear nuevo token

Para crear un nuevo token se debe seguir los siguientes pasos:

1.- **Crear un nuevo identificador de token** en la clase `Simbolos`. El identificador es un número único que corresponderá a cada token. La clase es parecida a la siguiente:

```java
package com.compiladores.compiladores;

public class Simbolos {
    public static final int ERROR = -1;
    public static final int ID = 1;
    public static final int NUM = 2;
    public static final int EOF = 58;
    public static final int OP_ASSIGN = 3;

    /** Crear una nueva línea para cada Token */
}
```

Un identificador, permitirá reconocer el tipo de token más adelante.

2.- **Crear una clase especializada** que derive de `Token`, use el eemplo de `OperadoAsignacion`:

```java
package com.compiladores.compiladores.Tokens;

import com.compiladores.compiladores.Simbolos;

public class OperadorAsignacion extends Token {
    public OperadorAsignacion(String lexema, int line, int column) {
        super(Simbolos.OP_ASSIGN, lexema, line, column, "ASIGNACION");
    }
}
```

Este paso es importante para que sepamos más adelante que la instancia del token se refiere a un operador de asignación. Se debe notar que la clase `Token` hereda de `Symbol`, esta última clase es de `java_cup` otro proyecto que servirá más adelante para el análisis semántico.

Es importante mencionar que el valor de cada token debe ser tratado de manera distinta, es decir, a veces es un número entero, otras veces un valor booleano.

3.- **Agregar el token a la fábrica de tokens**. La fábrica de tokens sirve para que en el archivo de JFlex, podamos pasarle únicamente el identificador del token y la fábrica cree la instancia correcta. La clase se llama `TokenFactory`.

```java
package com.compiladores.compiladores.Tokens;

import com.compiladores.compiladores.Simbolos;

public class TokenFactory {    
    public static final Token crear(int symbolId, String lexema, int line, int column, String ER) {
        switch (symbolId) {
            case Simbolos.ID:
                return  new Identificador(lexema, line, column);
            /** ... */
            default:
                return new Token(symbolId, lexema, line, column, ER);
        }
    }
}
```

5.- **Definir la regla léxica en el archivo de JFlex**. Este es el paso más complicado, básicamente hay que definir la estructura de un token en la sección 2 del archivo de JFlex y luego en la sección 3, definir un código para devolver el token correcto.

```jflex
{NumeroDecimal}             { return TokenFactory.crear(Simbolos.NUM, yytext(), yyline, yycolumn, "dd*"); }

/*  Operadores */
{OperadorIgualdad}          { return TokenFactory.crear(Simbolos.OP_ASSIGN, yytext(), yyline, yycolumn, "="); }
```

Es aquí donde entra la fábrica de tokens `TokenFactory.crear()` que recibirá el tipo de token y su valor.