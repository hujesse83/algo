package zero_50.aboutString;

// 541

public class ReverseStringII {
    public static void main(String[] args) {
        String s = "abcdefg";
        int i = 8;
        System.out.println(reverseStr(s, i));

    }
    public static  String reverseStr(String s, int k) {
        char[] ch = s.toCharArray();
        for (int i = 0; i < ch.length; i+=2*k) {
            int start = i;
            int end = Math.min(ch.length-1,start+k-1 );
            while(start < end){
                ch[start] ^= ch[end];
                ch[end] ^= ch[start];
                ch[start] ^= ch[end];
                start++;
                end--;
            }
        }
        return String.valueOf(ch);
    }

}
