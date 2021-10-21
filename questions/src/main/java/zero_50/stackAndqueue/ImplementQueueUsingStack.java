package zero_50.stackAndqueue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;
// 232 用栈实现队列
public class ImplementQueueUsingStack {
    public static void main(String[] args) {

    }
    class MyQueue {
        private Stack<Integer> s1;
        private Stack<Integer> s2;
        public MyQueue() {
            s1 =  new Stack<Integer>();
            s2 =  new Stack<Integer>();
        }
        Deque a = new ArrayDeque<Integer>();

        public void push(int x) {
            s1.push(x);
        }

        public int pop() {
            dumpStack();
            return s2.pop();
        }

        public int peek() {
            dumpStack();
            return s2.peek();
        }

        public boolean empty() {
            return (s1.isEmpty() && s2.isEmpty());
        }
        // 方法复用真的很有必要！
        private void dumpStack(){
            if (s2.isEmpty()){
                while (!s1.isEmpty()){
                    s2.push(s1.pop());
                }
            }
        }
    }

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
}
