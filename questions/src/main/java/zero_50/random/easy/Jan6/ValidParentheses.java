package zero_50.random.easy.Jan6;

import java.util.Stack;

/**
 * @author jesse.hu
 * @date 2022/1/6 15:42
 * @LeetCodeNo 20
 * @Description 使用栈对括号进行匹配
 */
public class ValidParentheses {
    // 解法
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '{') {
                stack.push('}');
            } else if (stack.isEmpty() || c != stack.pop()) {
                return false;
            }
        }
        return stack.isEmpty();
    }

    public boolean isValidV2(String s) {
        int length = s.length() / 2;
        for (int i = 0; i < length; i++) {
            s = s.replace("()", "").replace("{}", "").replace("[]", "");
        }

        return s.length() == 0;
    }
}
