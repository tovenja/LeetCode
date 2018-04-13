package mier;

/**
 * @author 杨立群
 * @Description 描述
 * 给定一个整数N，求N!的末尾有多少个0.
 * <p>
 * 输入
 * 输入为一个整数N，1 <= N <= 1000000000.
 * <p>
 * 输出
 * 输出为N!末尾0的个数
 * @Date 创建于 18-4-13 上午11:27
 */
public class NFactorial {
    public static void main(String[] args) {
        System.out.println(solution("8735373"));
    }
    
    private static String solution(String line) {
        // 在此处理单行数据
        int N = Integer.valueOf(line);
        int ans = 0;
        while (N > 0) {
            ans += N / 5;
            N /= 5;
        }
        // 返回处理后的结果
        return ans + "";
    }
}
