/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mincnosso;

import parser.AST;
import parser.Parser;
import parser.Scanner;
import vm.Compiler;
import vm.Interpreter;
import tela.FXMLController;

/**
 *
 * @author Aluno 07
 */
public class Main {
// Uso: java -jar minc.jar [opções]
    // Onde opções pode incluir:
    //-c : compilar código OU
    //-i : interpretar código
    //-e : prefixa e pós fixa
    //-d : grafico
    //-m : marie

    public static void main(String[] args) {
        // TODO code application logic here

        // Verificar as opções da linha de comando
        // e então decidir se a expressão será interpretada
        // ou compilada
        if (args.length == 0) {
            // Relizar a análise sintática e geração da AST a partir
            // de System.in
            Parser parser = new Parser(Scanner.getScanner(System.in));
            try {
                AST ast = parser.parse();
                // Processar linha de comando
                switch (args[0]) {
                    case "-c":
                        // Executar compilador
                        Compiler.compile(ast);
                        break;

                    case "-i":
                        // Executar interpretador
                        int result = Interpreter.interpret(ast);
                        System.out.println(String.format("Resultado: %d", result));
                        break;

                    case "-e":
                        //expressão nova
                        System.out.println(Proc.posFixa(ast));
                        System.out.println(Proc.preFixa(ast));

                        break;

                    case "-d":

                        break;

                    case "-m":

                        break;

                    default:
                        System.err.println("Opção inválida!");
                        break;
                }
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        } else {
            System.err.println("Número de opções inválido");
        }

    }

}
