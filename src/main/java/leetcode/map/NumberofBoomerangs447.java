package leetcode.map;

import java.util.HashMap;
import java.util.Map;

/**
 * @author blank
 * @Description
 * @Date 创建于 18-4-8 下午4:42
 */
public class NumberofBoomerangs447 {
    public static void main(String[] args) {
        int[][] arr = new int[][] {{0, 0}, {1, 0}, {2, 0}};
        System.out.println(new NumberofBoomerangs447().numberOfBoomerangs(arr));
    }
    
    /**
     * 题目大意是求平面上一组点，满足a到b，a到c距离相同的条件的数量，不是很有意思。
     */
    public int numberOfBoomerangs(int[][] points) {
        if (points == null || points.length == 0) {
            return 0;
        }
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length; j++) {
                if (i == j) {
                    continue;
                }
                int distance = getDistance(points[i], points[j]);
                ans += map.getOrDefault(distance, 0) * 2;
                map.computeIfPresent(distance, (k, v) -> v + 1);
                map.putIfAbsent(distance, 1);
            }
            map.clear();
        }
        return ans;
    }
    
    private int getDistance(int[] a, int[] b) {
        return (a[0] - b[0]) * (a[0] - b[0]) + (a[1] - b[1]) * (a[1] - b[1]);
    }
}
