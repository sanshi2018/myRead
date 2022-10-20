package chapter1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Evaluate {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        ResizingArrayStack<String> ops = new ResizingArrayStack<>();
        ResizingArrayStack<Double> vals = new ResizingArrayStack<>();
        // Stack<String> ops = new Stack<>();
        // Stack<Double> vals = new Stack<>();
        ops.pop();
        while (in.hasNextLine()) {
            String[] strs = in.nextLine().split(" ");
            for (int i = 0; i < strs.length; i++) {
                String s =strs[i];
                if (s.equals("(")) continue;
                // 读取字符如果是运算符则压入栈
                switch (s) {
                    case "+":
                        ops.push(s);
                        break;
                    case "-":
                        ops.push(s);
                        break;
                    case "*":
                        ops.push(s);
                        break;
                    case "/":
                        ops.push(s);
                        break;
                    case "sqrt":
                        ops.push(s);
                        break;
                    default:
                        break;
                }

                if (s.equals(")")) {
                    String op = ops.pop();
                    double v = vals.pop();
                    switch (op) {
                        case "+":
                            v = vals.pop() + v;
                            break;
                        case "-":
                            v = vals.pop() - v;
                            break;
                        case "*":
                            v = vals.pop() * v;
                            break;
                        case "/":
                            v = vals.pop() / v;
                            break;
                        case "sqrt":
                            v = Math.sqrt(v);
                            break;
                        default:
                    }
                    vals.push(v);
                }
                try {
                   double val = Double.parseDouble(s);
                    if(val>=0&&val<=9) {
                        vals.push(val);
                    }
                }catch (Exception e) {
                    continue;
                }
            }
            System.out.println(vals.pop());
            ops.clear();
            vals.clear();
        }

    }
}