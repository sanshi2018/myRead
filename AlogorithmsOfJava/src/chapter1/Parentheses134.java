package chapter1;

import java.util.Scanner;

public class Parentheses134 {
    Scanner in = new Scanner(System.in);
    public void matchParentheses() {
        while (in.hasNextLine()) {
            String[] strs = in.nextLine().split(" ");
            LinkStack<String > linkStack = new LinkStack<>();
            int i =0;
            for (; i < strs.length; i++) {
                String s = strs[i];
                boolean isPush =false;
                switch (s) {
                    case "[" : {linkStack.push("]"); isPush=true; break;}
                    case "{" : { linkStack.push("}");isPush=true; break;}
                    case "(" : {linkStack.push(")");isPush=true; break;}
                }
                    if (!isPush) {
                        if (!linkStack.pop().equals(s)){
                            System.out.println("FALSE");
                            break;
                        }
                    }
            }
            if (i == strs.length)
            System.out.println("TRUE");
        }
    }
    public static void main(String[] args) {
        Parentheses134 p = new Parentheses134();
        p.matchParentheses();
    }
}
