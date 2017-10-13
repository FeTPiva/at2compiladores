/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mincnosso;

import java.io.FileOutputStream;
import java.io.PrintStream;

import parser.AST;
import parser.Digit;
import parser.Operator;

/**
 *
 * @author bndky
 */


public class CompilerMarie {
    /**
     * output é a stream de saída (arquivo com código de máquina)
     */
    private static PrintStream output = null;
    private static int v = 0;
    /**
     * Função que compila (gera o código de máquina) das expressões em Marie
     * 
     * @param ast
     *            é a árvore de sintaxe abstrata produzida pelo parser
     * @param nome
     *              é o nome do arquivo de saida do Marie
     */
    public static void compileMarie(AST ast, String nome) {
        try {
            if (output == null) {
                // Abre o arquivo uma e única vez
                output = new PrintStream(new FileOutputStream(nome+".mas"));
            }
            //Montando pilha de operadores
            String op = Proc.posFixa(ast);
            String[] opp = new String[op.length()];
            
            // Se a árvore for um operador
            if (ast instanceof Operator) {
                // Processa os operandos esquerdo e direito
                compileMarie(ast.getLeftAST(), nome);
                compileMarie(ast.getRightAST(), nome);
                // Converte para Operator
                Operator operator = (Operator) ast;
                // Descobre e executa a operação
                switch (operator.getOperatorSymbol()) {
                case '+':
                    // Gera comando para soma de 2 elementos
                    output.println("Add     x"+v);
                    output.println("Store   x");
                    v++;
                    break;
                case '-':
                    // Gera comando para subtração de 2 elementos
                    output.println("Subt    x"+v);
                    output.println("Store   x");
                    v++;
                    break;
                case '*':
                    // Gera comando para multiplicação de 2 elementos
                    output.println("JnS z"+v);
                    output.println("Load i"+v);
                    output.println("Add x");
                    output.println("Store i"+v);
                    output.println("Load x"+v);
                    output.println("Subt one");
                    output.println("Store x"+v);
                    output.println("Skipcond 400");
                    output.println("Jump z"+v);
                    output.println("Load i"+v);
                    output.println("Store x");
                    output.println("Load x");
                    
                    v++;
                    break;
                case '/':
                    // Gera comando para divisão de 2 elementos
                    output.println("JnS z"+v);
                    output.println("Load i"+v);
                    output.println("Add one");
                    output.println("Store i"+v);
                    output.println("Load x");
                    output.println("Subt x"+v);
                    output.println("Store x");
                    output.println("Skipcond 400");
                    output.println("Jump z"+v);
                    output.println("Load i"+v);
                    output.println("Store x");
                    output.println("Load x");
                    
                    v++;
                    break;
                default: // Erro no operador?
                    // Fechar o arquivo
                    if (output != null) {
                        output.close();
                    }
                    throw new Exception("Invalid operator found!");
                }
            } else { // senão, deve ser uma árvore de operando
                // Converte para Digit
                Digit dig = (Digit) ast;
                // Gera comando para PUSH do dígito
                output.printf("PUSH %d\n", dig.getDigitValue());
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
            // Fechar o arquivo
            if (output != null) {
                output.close();
            }
        }
    }
}