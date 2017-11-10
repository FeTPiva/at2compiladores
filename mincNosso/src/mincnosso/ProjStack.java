package mincnosso;

import java.util.Scanner;
import java.util.Stack;

//classe que compilará a pilha
public class ProjStack {

    Stack<Integer> stack = new Stack<>();

    String inst = "PUSH";

    
    public ProjStack() {
        while (!inst.equals("fim")) {
            Scanner sc = new Scanner(System.in);
            inst = sc.nextLine();
            if (inst.contains("PUSH")) {

                String[] n = inst.split(" ");
                int num = Integer.parseInt(n[1]);

                stack.push(num);
            }
            if (inst.contentEquals("ADD")) {

                int v1 = stack.pop();
                int v2 = stack.pop();
                System.out.println(v1 + v2);
            }
            if (inst.contentEquals("SUB")) {
                int v1 = stack.pop();
                int v2 = stack.pop();
                System.out.println(v1 - v2);
            }
            if (inst.contentEquals("MULT")) {
                int v1 = stack.pop();
                int v2 = stack.pop();
                System.out.println(v1 * v2);
            }
            if (inst.contentEquals("DIV")) {
                int v1 = stack.pop();
                int v2 = stack.pop();
                System.out.println(v1 / v2);
            }
        }

    }
}
