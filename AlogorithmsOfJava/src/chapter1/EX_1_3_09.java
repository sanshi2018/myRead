package chapter1;

import java.util.Scanner;
import java.util.Stack;

/**
 * 打印出补全括号的中序表达式
 * input: 1+2)*3-4)*5-6)))
 * output: ((1+2)*((3-4)*(5-6)
 */
public class EX_1_3_09 {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()){
            String[] strs = in.nextLine().split(" ");
            Stack<String> ops = new Stack<>();
            Stack<String> val = new Stack<>();
            for (int i = 0; i < strs.length; i++) {
                if (strs[i].equals("("))continue;
                if (strs[i].equals("+")||strs[i].equals("-")||
                        strs[i].equals("*")||strs[i].equals("/")
                        ||strs[i].equals("sqrt")) {
                    ops.push(strs[i]);
                    continue;
                }
                if (strs[i].equals(")")){
                    String v1 = val.pop();
                    String op = ops.pop();
                    String v2 = val.pop();
                    val.push("( "+v2+" "+op+" "+v1+" )");
                    continue;
                }
                if (IsDigital(Integer.parseInt(strs[i]))) {
                    val.push(strs[i]);
                }
            }
            for (int i = 0; i < val.size(); i++) {
                System.out.println(val.pop());
            }
        }
    }

    public static boolean IsDigital (int num) {
        return num>=0 && num<=9;
    }
}
