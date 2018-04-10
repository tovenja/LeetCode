package leetcode.map;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author blank
 * @Description
 * @Date 创建于 18-4-10 下午2:27
 */
public class BrickWall554 {
    public static void main(String[] args) {
    
    }
    
    /**
     * 每个砖缝对应一个横坐标，该横坐标砖缝最多的时候，切这个位置破坏砖最少。
     * <p>
     * 一开始记录的全部实心的地方，TLE，无语。
     */
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> cnt = new HashMap<>();
        int ans = 0;
        for (int i = 0; i < wall.size(); i++) {
            int sum = 0;
            for (int j = 0; j < wall.get(i).size() - 1; j++) {
                sum += wall.get(i).get(j);
                cnt.put(sum, cnt.getOrDefault(sum, 0) + 1);
                ans = Math.max(ans, cnt.get(sum));
            }
        }
        return wall.size() - ans;
    }
}
