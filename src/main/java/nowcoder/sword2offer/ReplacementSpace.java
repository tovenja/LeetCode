package nowcoder.sword2offer;

import java.util.Arrays;

/**
 * Created by blank on 2015-09-06 上午10:42.
 */
public class ReplacementSpace {

    public static void main(String[] args) {
        System.out.println(replaceSpace("xx dd",5));
    }

    public static String replaceSpace(String str, int length) {
        if(length<=0){
            return "";
        }
        int cnt=0;
        for(int i=0;i<length;i++){
            if(str.charAt(i)==' '){
                cnt++;
            }
        }
        if(cnt==0){
            return str;
        }
        int newLength = length + cnt * 2;
        char[] array = new char[newLength];
        cnt = 0;
        for(int i=0;i<length;i++){
            if(str.charAt(i)!=' '){
                array[cnt++]=str.charAt(i);
            }else{
                array[cnt++]='%';
                array[cnt++]='2';
                array[cnt++]='0';
            }
        }
        return String.valueOf(array);
    }
}
