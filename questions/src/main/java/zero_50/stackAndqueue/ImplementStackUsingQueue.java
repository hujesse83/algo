package zero_50.stackAndqueue;

import java.util.ArrayDeque;
import java.util.Deque;
//225
public class ImplementStackUsingQueue {
    public static void main(String[] args) {

    }
    class MyStack {
        private Deque<Integer> d1;
        private Deque<Integer> d2;
        public MyStack() {
            d1 = new ArrayDeque<Integer>();
            d2 = new ArrayDeque<Integer>();
        }

        public void push(int x) {
            d1.addLast(x);
        }

        public int pop() {
            while (d1.size()>1){
                d2.addLast(d1.pop());
            }
            int x =  d1.pop();
            while (d2.size()>0){
                d1.addLast(d2.pop());
            }
            return x;
        }

        public int top() {
            int temp = pop();
            push(temp);
            return temp;
        }

        public boolean empty() {
            return d1.isEmpty();
        }
    }

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
}
