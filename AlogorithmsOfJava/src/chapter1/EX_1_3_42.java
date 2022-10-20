package chapter1;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class EX_1_3_42 {
  public Stack copyStack(Stack s){
      Stack res = new Stack();
      Stack queue = new Stack();
      Iterator iterator = s.iterator();
      while (iterator.hasNext()){
          queue.add(iterator.next());
      }
      while (!queue.isEmpty()){
          res.add(queue.pop());
      }
      return res;
      
  }
}
