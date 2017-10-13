/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mincnosso;

import parser.*;

/**
 *
 * @author bndky
 */
public class Proc {

    public static String preFixa(AST ast) {
        String exp = "";
        if (ast instanceof Operator) {
            // Converte para Operator
            Operator operator = (Operator) ast;
            exp += operator.getOperatorSymbol();
            if (ast.getLeftAST() != null) {
                preFixa(ast.getLeftAST());
            }
            if (ast.getRightAST() != null) {
                preFixa(ast.getRightAST());
            }
        } else { // senão, deve ser uma árvore de operando
            // Converte para Digit
            Digit dig = (Digit) ast;
            // Retorna o valor do dígito obtido
            exp += dig.getDigitValue();
        }
        return exp;
    }

    public static String posFixa(AST ast) {
        String exp = "";
        if (ast.getLeftAST() != null) {
            preFixa(ast.getLeftAST());
        }
        if (ast.getRightAST() != null) {
            preFixa(ast.getRightAST());
        }
        if (ast instanceof Operator) {
            Operator operator = (Operator) ast;
            exp += operator.getOperatorSymbol();
        } else { // senão, deve ser uma árvore de operando
            // Converte para Digit
            Digit dig = (Digit) ast;
            // Retorna o valor do dígito obtido
            exp += dig.getDigitValue();
        }
        return exp;
    }
}
