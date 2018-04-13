package mier;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author 杨立群
 * @Description 描述
 * 定义一个美丽字符串，对于字符串S，S中只包含小写的a-z字符，存在2条规则：
 * 规则1：S中每个字符出现的次数一样，如abc，每个字符出现1次，aabbcc，每个字符出现2次
 * 规则2：添加或删除S中的一个字符后，使得S中每个字符出现的次数一样，如abca，删除一个字符a，则变为abc后每个字符出现1次
 * 又例如aabcbbcc,添加一个字符a，则变为aabcbbcca，每个字符出现3次
 * 对于字符串S，若满足规则1，2中任意一条规则，则称为美丽的字符串
 * <p>
 * 输入
 * 一个字符串S，只包含a-z的小写字符
 * <p>
 * 输出
 * 判断该字符串是否为美丽的字符串，若是则输出YES，若不是则输出NO
 * @Date 创建于 18-4-13 上午10:57
 */
public class BeautyString {
    public static void main(String[] args) {
//        System.out.println(solution("aabbccc"));
//        System.out.println(solution("abcc"));
//        System.out.println(solution("abs"));
//        System.out.println(solution("aaabbbccc"));
        System.out.println(solution("abccc"));
    }
    
    private static String solution(String line) {
        // 在此处理单行数据
        char[] arr = line.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            Integer cnt = map.get(arr[i]);
            if (cnt == null) {
                map.put(arr[i], 1);
            } else {
                map.put(arr[i], cnt + 1);
            }
        }
        
        Set<Integer> set = new HashSet<>(map.values());
//        System.out.println(set);
        if (set.size() >= 3) {
            return "NO";
        }
        int i = 0;
        int ans = 0, tmp = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            int num = entry.getValue();
            if (i == 0) {
                i++;
                tmp = num;
                continue;
            }
            ans += Math.abs(num - tmp);
            if (ans > 1) {
                return "NO";
            }
            i++;
        }
        // 返回处理后的结果
        return "YES";
    }
}
