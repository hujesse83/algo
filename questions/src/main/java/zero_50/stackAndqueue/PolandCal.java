package zero_50.stackAndqueue;

import java.util.Stack;

/**
 * leetcode 150
 * 需要注意的是 有的oj比较老，用的是老jdk String不支持== ，得换成equals
 * 逆波兰表示式对计算机很友好。而我们日常生活习惯了中缀
 * && 其实逆波兰表达式相当于是二叉树中的后序遍历
 * && 栈与递归之间在某种程度上是可以转换的
 */
public class PolandCal {
    public static void main(String[] args) {
        String [] array = {
                "10","6","9","3","+","-11","*","/","*","17","+","5","+"
        };
        System.out.println(evalRPN(array));
    }
    public static int evalRPN(String[] tokens) {
        Stack<Integer> num = new Stack<>();
        for (String token : tokens) {
            if (!isOperator(token)){
                num.push(Integer.valueOf(token));
            }else {
                if (num.size()>1){
                    num.push(operate(num.pop(),num.pop(),token.charAt(0)));
                }
            }
        }
        System.out.println(num);
        System.out.println("++++++++");
        return num.pop();
    }
    public static int operate(int b,int a,char c){
        if (c=='+'){
            return a+b;
        }else if (c=='-'){
            return a-b;
        }else if (c=='*'){
            return a*b;
        }else if (c=='/'){
            return a/b;
        }
        return -1;
    }
    public static boolean isOperator(String c){
        return c.equals("+")||c.equals("-")||c.equals("*")||c.equals("/");
    }
}
