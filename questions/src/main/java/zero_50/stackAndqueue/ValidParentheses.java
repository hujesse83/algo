package zero_50.stackAndqueue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

// 20 awesome
public class ValidParentheses {
    public static void main(String[] args) {

    }
    public boolean isValid(String s) {
        char[] array = s.toCharArray();
        Stack<Character> s1 = new Stack<>();
        for (char c : array) {
            if (c == '(') s1.push(c);
            else if (c == '[') s1.push(c);
            else if (c == '{') s1.push(c);
            else if (s1.isEmpty() || c != s1.pop()) return false;
        }
        return s1.isEmpty();

    }
}
