package zero_50.aboutString;
// 该复习KMP了
//  当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题
public class Kmp {
    public static void main(String[] args) {
        String a = "abcddasasdsa";
        String b = "dda";
        System.out.println(strStr(a, b));
    }
    public static int strStr(String haystack, String needle) {
        if (haystack=="" ||needle==""){
            return 0;
        }
        char[] h = haystack.toCharArray();
        char[] n = needle.toCharArray();
        int[] next = new int[needle.length()];
        getPrefixTable(needle,next);
        getNext(next);
        int i = 0;
        int j = 0;
        while (i<haystack.length() && j<needle.length()){
            if (j>0 && h[i]!=n[j]){
                j = next[j];
            }else {
                i++;
                j++;
            }
        }
        System.out.println(i);
        System.out.println(j);
        return i-j==needle.length()?i+1-j:-1;
    }
    public static void getPrefixTable(String p,int []next){
        char []pattern = p.toCharArray();
        next[0] = 0;
        for (int i = 1; i < pattern.length ; i++) {
            int k = next[i-1];
            // 不断递归寻找子对称，k=0说明不会再有子对称
            while(pattern[i]!=pattern[k] &&k>0){
                k = next[k-1];
            }
            if (pattern[i]==pattern[k]){
                next[i] = k+1;
            }else {
                next[i]=0;
            }
        }
    }
    public static void getNext(int []preTable){
        for (int i = preTable.length-1; i >=1 ; i--) {
            preTable[i] = preTable[i-1];
        }
        preTable[0] = -1;
    }
}
