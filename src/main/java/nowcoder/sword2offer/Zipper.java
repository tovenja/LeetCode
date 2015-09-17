package nowcoder.sword2offer;

/**
 * Created by blank on 2015-09-06 上午10:55.
 */
public class Zipper {

    public static void main(String[] args) {
        String arg = "jjjjjjxxxxxxxooZLLLLLLLLQQQQQQQQQLLLLLLLLECXXXXXXXIIIIIIIIIhjjyyySSooooooooommmuuEEEEEEEEEnnnnnnnffffffAAAAAllllllllbbbbkkkkkkkkkkkkKKKKKKhhhhhhhhhooooooooooYCCCCCCOOOOOOOOOMMMMMMMMMMiiiiiivvvvvvvWWWWkkkkkkwwwwwwwMmmmmmmmmLLLwwwwwwwkkkjjjjjjttttQQQQQQQQQaaaaaaaFFFFFFFlllllllllggggggggggPPPPPPuuuuuuuuaYYYYYYwQQQFFFFFFFFFFaaaaapXXXXXXXxxxxxxQQQQQQQQQsssssGGGGfffffffddddddpppQQQQQQHHHTTTaaaaaaGGGGGGddyyyyyMhhllllllllllNNNNNNNNUUUWWWWWWLLLLLLLLLYYYYYYYYYYTTKKKKKKKKiiiiiiitttttttXXXXXXXXXLLLHZZZZZZZssssjjJJJEEEEEOOOOOttttttttttBBttttttTTTTTTTTTTrrrrttttRRRRRyyooooooaaaaaaaaarrrrrrrPPPPPPPjjPPPPddddddddddHHHHnnnnnnnnnnSSSSSSSSSSzzHHHHHHHHHddddddDDDzzzhhhhhfffffffffftttttteeeeeeeeEEEEEEEEEaaaaaaccccccccccFFFFFFFF";

        String res = zipString(arg);
        System.out.println(arg.length());
        System.out.println(res.length());
    }


    public static String zipString(String str) {
        if(str==null||str.length()<=1){
            return str;
        }
        int len = str.length();

        StringBuilder sb = new StringBuilder();
        int pos = 0;
        while(pos<len){
            int cnt = 1;
            while(pos<len-1&&str.charAt(pos)==str.charAt(pos+1)){
                cnt++;
                pos++;
            }
            sb.append(str.charAt(pos)).append(cnt);
            pos++;
        }
        System.out.println(sb.toString());
        if(sb.length()>=len){
            return str;
        }
        return sb.toString();
    }
}
