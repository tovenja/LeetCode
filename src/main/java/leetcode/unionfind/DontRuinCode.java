package leetcode.unionfind;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 杨立群
 * @Description 描述
 * 最近公司内爆发了一种名叫“瞎改我代码就会死”的传染病
 * <p>
 * 传播方式是只要与染病者共同编辑过一份代码，那么就会被感染，无关改动的先后顺序
 * <p>
 * 这个病毒病的潜伏期很长，码农感染后仍然能像正常人一样coding，但一旦被传染，就必死无疑
 * <p>
 * 正巧这段时间小王也瞎改了一通别人的代码，这里有一份整理好的git修改历史，快帮小王诊断一下他还有没有救吧
 * <p>
 * 输入
 * 第一段是通过上帝视角知晓的感染者名单，每个用户用空格分割
 * 之后是很多段代码修改记录，每段内部用空格分割，第一列是文件名，之后是一系列的修改过这份代码的用户
 * 每段之间使用分号分割
 * <p>
 * ps1：小王在git上的用户名是neighbor_wang
 * ps2：0<代码文件数，码农数<=10000
 * <p>
 * 输出
 * 小王还有救输出"good programmer"，否则输出"go die"
 * @Date 创建于 18-4-13 下午2:28
 */
public class DontRuinCode {
    public static void main(String[] args) {
        System.out.println(solution("xiaohong;Main.java neighbor_wang xiaoming;IndexController.java xiaohong xiaoming"));
//        System.out.println(solution("5;p0 1 neighbor_wang;p1 1 3 4 6 7;p2 1 2;p3 1 2 neighbor_wang;p4 1 3 4 5 6 7;p5 2 3 5 7 8;p6 neighbor_wang;p7 1 2 4 5 6 neighbor_wang"));
    }
    
    private static String solution(String line) {
        // 在此处理单行数据
        String[] arr = line.split(";");
        String[] names = arr[0].split(" ");
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < names.length; i++) {
            map.put(names[i], names[i]);
        }
        map.put("neighbor_wang", "neighbor_wang");
        for (int i = 1; i < arr.length; i++) {
            String[] codes = arr[i].split(" ");
            for (int j = 1; j < codes.length; j++) {
                if (map.get(codes[j]) == null) {
                    map.put(codes[j], codes[j]);
                }
                if (j > 1) {
                    union(map, codes[j - 1], codes[j]);
                }
            }
        }
        for (int i = 0; i < names.length; i++) {
            boolean res = connected("neighbor_wang", names[i], map);
            if (res) {
                return "go die";
            }
        }
        // 返回处理后的结果
        return "good programmer";
    }
    
    private static void union(Map<String, String> map, String p, String q) {
        String pp = find(p, map);
        String pq = find(q, map);
        if (pp.equals(pq)) {
            return;
        }
        map.put(pp, pq);
    }
    
    private static String find(String p, Map<String, String> map) {
        while (!p.equals(map.get(p))) {
            map.put(p, map.get(map.get(p)));
            p = map.get(p);
        }
        return p;
    }
    
    private static boolean connected(String p, String q, Map<String, String> map) {
        return find(p, map).equals(find(q, map));
    }
}
