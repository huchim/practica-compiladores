package com.compiladores.compiladores.Tokens;

import java_cup.runtime.Symbol;

public class Token extends Symbol {
	private String lexema;
	private String ER;
	private int line;
	private int column;
	
	public Token(int symbolId, String lexema, int line, int column, String ER) {
		// symbolId = sym
		super(symbolId);

		this.lexema = lexema;
		this.line = line;
		this.column = column;
		this.ER = ER;
	}

	public String getLexema() {
		return this.lexema;
	}
	
	public void setLexema(String lexema) {
		this.lexema = lexema;
	}
	
	public String getER() {
		return this.ER;
	}
	
	public void setER(String ER) {
		this.ER = ER;
	}
	
	public int getLine() {
		return this.line;
	}
	
	public void setLine(int line) {
		this.line= line;
	}
	
	public int getColumn() {
		return this.column;
	}
	
	public void setColumn(int column) {
		this.column = column;
	}
}