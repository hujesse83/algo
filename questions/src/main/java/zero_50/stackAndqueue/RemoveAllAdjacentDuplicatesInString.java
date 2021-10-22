package zero_50.stackAndqueue;

import java.util.Stack;



// 1047
public class RemoveAllAdjacentDuplicatesInString {
    public static void main(String[] args) {
        System.out.println(removeDuplicates2("abbaca"));
    }
    // use stack
    public static String removeDuplicates(String s) {
        char[] array = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char c : array) {
            if (stack.size()==0){
                stack.push(c);
            }else if (stack.size()>0 && c==stack.peek()){
                stack.pop();
            }else {
                stack.push(c);
            }
        }
        String str = "";
        while (!stack.isEmpty()){
            str = stack.pop()+str;
        }
        return str;
    }
    // 特流氓的解法
    public static String removeDuplicates2(String S) {
        int now = S.length();
        int next = 1;
        while(now !=next){
            now = S.length();
            S=S.replace("aa","").replace("bb","").replace("cc","").replace("dd","").replace("ee","").replace("ff","").replace("gg","").replace("hh","").replace("ii","").replace("jj","").replace("kk","").replace("ll","").replace("mm","").replace("nn","").replace("oo","").replace("pp","").replace("qq","").replace("rr","").replace("ss","").replace("tt","").replace("uu","").replace("vv","").replace("ww","").replace("xx","").replace("yy","").replace("zz","");
            next = S.length();
        }
        return S;
    }
}
