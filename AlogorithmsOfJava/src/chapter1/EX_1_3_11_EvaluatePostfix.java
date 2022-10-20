package chapter1;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Stack;

/**
 * 给出一个后序表达式计算结果
 * input：( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )
 * output : 1 2 3 + 4 5 * * +
 */
public class EX_1_3_11_EvaluatePostfix {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()){
            String[] strs = in.nextLine().split(" ");
            Stack<Double> val = new Stack<>();
            for (int i = 0; i < strs.length; i++) {
                if (strs[i].equals("(")||strs[i].equals(")"))continue;
                if (strs[i].equals("+")||strs[i].equals("-")||
                        strs[i].equals("*")||strs[i].equals("/")
                        ||strs[i].equals("sqrt")) {
                    double v1 = val.pop();
                    switch (strs[i]){
                        case "+": val.push(val.pop() + v1);break;
                        case "-": val.push(val.pop() - v1);break;
                        case "*": val.push(val.pop() * v1);break;
                        case "/": val.push(val.pop() / v1);break;
                        case "sqrt": val.push(Math.sqrt(val.pop()));break;
                    }
                }else
                val.push(Double.parseDouble(strs[i]));
            }
            for (int i = 0; i < val.size(); i++) {
                System.out.println(val.pop());
            }
            val.clear();
        }
    }

}
