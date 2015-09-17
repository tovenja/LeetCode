package nowcoder.sword2offer;

/**
 * Created by blank on 2015-09-06 上午11:17.
 */
public class Reverse {


    public static void main(String[] args) {
        String res = reverseString("xxcvx xfafaf");
        System.out.println(res);
    }

    public static String reverseString(String str) {
        if(str==null||str.length()<=1){
            return str;
        }
        char[] array = str.toCharArray();
        int j = array.length-1;
        int i = 0;
        while(i<j){
            char x = array[i];
            array[i] = array[j];
            array[j] = x;
            i++;
            j--;
        }
        return String.valueOf(array);
    }
}
