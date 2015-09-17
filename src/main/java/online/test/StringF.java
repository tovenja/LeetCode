package online.test;

/**
 * Created by blank on 2015-09-10 下午5:43.
 */
public class StringF {

    public static void main(String[] args) {
        String res =formatString(" string");
        System.out.println(res);
    }


    public static String formatString(String str) {
        if(str == null||str.length()==0){
            return str;
        }
        int startPos = 0;
        int endPos = str.length()-1;
        while(startPos<endPos&&str.charAt(startPos)==' '){
            startPos++;
        }
        if(startPos == endPos){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for(int i=startPos;i<endPos;i++){
            if(str.charAt(i)!=' '){
                sb.append(str.charAt(i));
            }else if(str.charAt(i+1)!=' '){
                sb.append(" ");
            }
        }
        if (str.charAt(endPos)!=' '){
            sb.append(str.charAt(endPos));
        }
        return sb.toString();
    }
}
