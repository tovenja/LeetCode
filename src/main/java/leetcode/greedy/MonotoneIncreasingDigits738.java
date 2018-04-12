package leetcode.greedy;

/**
 * @author blank
 * @Description
 * @Date 创建于 18-4-12 下午6:04
 */
public class MonotoneIncreasingDigits738 {
    public static void main(String[] args) {
        System.out.println(new MonotoneIncreasingDigits738().monotoneIncreasingDigits(123456798));
    }
    
    
    /**
     * 处理了一些繁琐的细节，当然可以用toCharArray()和Integer.valueOf(new String(arr))，不用处理前缀为'0'这种
     */
    public int monotoneIncreasingDigits(int N) {
        String str = String.valueOf(N);
        String ans = "";
        boolean flag = false;
        int cnt= 0;
        for (int i = str.length() - 1; i >= 0; i--) {
            char c = str.charAt(i);
            if (flag) {
                c--;
            }
            cnt++;
            if (i > 0 && c >= str.charAt(i - 1)) {
                if (c != '0' || i != 1) {
                    ans = c + ans;
                }
                flag = false;
            } else {
                if (i == 0) {
                    if (c != '0') {
                        ans = c + ans;
                    }
                } else {
                    ans = "";
                    for (int j = 0; j < cnt; j++) {
                        ans += "9";
                    }
                }
                flag = true;
            }
        }
        return Integer.valueOf(ans);
    }
}
