/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mincnosso;

import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import parser.AST;
import parser.Parser;
import parser.Scanner;
import vm.Compiler;
import vm.Interpreter;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import java.awt.Graphics;
import javafx.stage.Stage;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 *
 * @author Aluno 07
 */
public class Main extends Application {
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
            // de System.in        exp += ast.toString();
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
                        launch(args);
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

    public void start(Stage primaryStage) {
        primaryStage.setTitle("AST:");
        Group root = new Group();
        Canvas canvas = new Canvas(500, 500);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        drawShapes(gc);
        root.getChildren().add(canvas);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    
//arvore exibida em um canvas
    private void drawShapes(GraphicsContext gc) {
        Font fontLarge = Font.font("Arial", FontWeight.BOLD, 12);
        gc.setStroke(Color.BLACK);

        Canvas linha = new Canvas();
        Canvas texto = new Canvas();

        linha.setHeight(3);
        

    }

}
