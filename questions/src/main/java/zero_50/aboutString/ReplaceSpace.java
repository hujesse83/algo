package zero_50.aboutString;

// 剑指offer 05. 替换空格
public class ReplaceSpace {
    public static void main(String[] args) {
        String a = "a a a ";
        System.out.println(replaceSpace(a));
    }
    public static String replaceSpace(String s) {
        StringBuilder res = new StringBuilder();
        char[] array = s.toCharArray();
        for (int i = 0; i < array.length; i++) {
            if (array[i]==' '){
                res.append("%20");
            }else {
                res.append(array[i]);
            }
        }
        return res.toString();
    }
}
