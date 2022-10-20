package chapter1;

import java.util.Scanner;
import java.util.Stack;

/**
 * 中序表达式转化为后序表达式
 *
 * 例如：中序表达式(23+34*45/(5+6+7))转换成后序表达式23 34 45 * 5 6 + 7 + / +
 * 后序表达式用处：
 * 当转换成后序表达式后更方便计算表达式的值，如将后序表达式的元素依次进栈直到遇到运算符，这时候从栈中弹出两个元素，
 * 再结合运算符计算出这两个数运算的结果(如34*45=1530)，将其结果压栈（此时栈元素为23 1530），然后继续将后序非符号元素压栈，直到遇到运算符。重复之前的操作。。。
 *
 * 例子
 * input：( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )
 * output : 1 2 3 + 4 5 * * +
 */
public class EX_1_3_10_InfixToPostfix {



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
                    val.push(v2+" "+v1+" "+op);
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
