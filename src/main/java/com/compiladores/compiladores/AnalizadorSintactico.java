
//----------------------------------------------------
// The following code was generated by CUP v0.11b 20160615 (GIT 4ac7450)
//----------------------------------------------------

package com.compiladores.compiladores;

import java.util.ArrayList;
import java_cup.runtime.*;
import java_cup.runtime.XMLElement;

/** CUP v0.11b 20160615 (GIT 4ac7450) generated parser.
  */
@SuppressWarnings({"rawtypes"})
public class AnalizadorSintactico extends java_cup.runtime.lr_parser {

 public final Class getSymbolContainer() {
    return Simbolos.class;
}

  /** Default constructor. */
  @Deprecated
  public AnalizadorSintactico() {super();}

  /** Constructor which sets the default scanner. */
  @Deprecated
  public AnalizadorSintactico(java_cup.runtime.Scanner s) {super(s);}

  /** Constructor which sets the default scanner. */
  public AnalizadorSintactico(java_cup.runtime.Scanner s, java_cup.runtime.SymbolFactory sf) {super(s,sf);}

  /** Production table. */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\003\000\002\002\004\000\002\002\005\000\002\002" +
    "\003" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\006\000\004\004\005\001\002\000\006\002\007\006" +
    "\006\001\002\000\006\002\uffff\006\uffff\001\002\000\004" +
    "\004\010\001\002\000\004\002\001\001\002\000\006\002" +
    "\000\006\000\001\002" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\006\000\004\002\003\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001" });

  /** Access to <code>reduce_goto</code> table. */
  public short[][] reduce_table() {return _reduce_table;}

  /** Instance of action encapsulation class. */
  protected CUP$AnalizadorSintactico$actions action_obj;

  /** Action encapsulation object initializer. */
  protected void init_actions()
    {
      action_obj = new CUP$AnalizadorSintactico$actions(this);
    }

  /** Invoke a user supplied parse action. */
  public java_cup.runtime.Symbol do_action(
    int                        act_num,
    java_cup.runtime.lr_parser parser,
    java.util.Stack            stack,
    int                        top)
    throws java.lang.Exception
  {
    /* call code in generated class */
    return action_obj.CUP$AnalizadorSintactico$do_action(act_num, parser, stack, top);
  }

  /** Indicates start state. */
  public int start_state() {return 0;}
  /** Indicates start production. */
  public int start_production() {return 0;}

  /** <code>EOF</code> Symbol index. */
  public int EOF_sym() {return 0;}

  /** <code>error</code> Symbol index. */
  public int error_sym() {return 1;}


/** Cup generated class to encapsulate user supplied action code.*/
@SuppressWarnings({"rawtypes", "unchecked", "unused"})
class CUP$AnalizadorSintactico$actions {
  private final AnalizadorSintactico parser;

  /** Constructor */
  CUP$AnalizadorSintactico$actions(AnalizadorSintactico parser) {
    this.parser = parser;
  }

  /** Method 0 with the actual generated action code for actions 0 to 300. */
  public final java_cup.runtime.Symbol CUP$AnalizadorSintactico$do_action_part00000000(
    int                        CUP$AnalizadorSintactico$act_num,
    java_cup.runtime.lr_parser CUP$AnalizadorSintactico$parser,
    java.util.Stack            CUP$AnalizadorSintactico$stack,
    int                        CUP$AnalizadorSintactico$top)
    throws java.lang.Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$AnalizadorSintactico$result;

      /* select the action based on the action number */
      switch (CUP$AnalizadorSintactico$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // $START ::= L EOF 
            {
              Object RESULT =null;
		int start_valleft = ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.elementAt(CUP$AnalizadorSintactico$top-1)).left;
		int start_valright = ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.elementAt(CUP$AnalizadorSintactico$top-1)).right;
		Object start_val = (Object)((java_cup.runtime.Symbol) CUP$AnalizadorSintactico$stack.elementAt(CUP$AnalizadorSintactico$top-1)).value;
		RESULT = start_val;
              CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("$START",0, ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.elementAt(CUP$AnalizadorSintactico$top-1)), ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), RESULT);
            }
          /* ACCEPT */
          CUP$AnalizadorSintactico$parser.done_parsing();
          return CUP$AnalizadorSintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // L ::= L COMMA ID 
            {
              Object RESULT =null;

              CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("L",0, ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.elementAt(CUP$AnalizadorSintactico$top-2)), ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // L ::= ID 
            {
              Object RESULT =null;

              CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("L",0, ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintactico$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number "+CUP$AnalizadorSintactico$act_num+"found in internal parse table");

        }
    } /* end of method */

  /** Method splitting the generated action code into several parts. */
  public final java_cup.runtime.Symbol CUP$AnalizadorSintactico$do_action(
    int                        CUP$AnalizadorSintactico$act_num,
    java_cup.runtime.lr_parser CUP$AnalizadorSintactico$parser,
    java.util.Stack            CUP$AnalizadorSintactico$stack,
    int                        CUP$AnalizadorSintactico$top)
    throws java.lang.Exception
    {
              return CUP$AnalizadorSintactico$do_action_part00000000(
                               CUP$AnalizadorSintactico$act_num,
                               CUP$AnalizadorSintactico$parser,
                               CUP$AnalizadorSintactico$stack,
                               CUP$AnalizadorSintactico$top);
    }
}

}
