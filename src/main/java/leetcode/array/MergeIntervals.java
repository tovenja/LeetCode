package leetcode.array;

import java.util.*;

/**
 * Created by blank on 2015-09-09 下午9:18.
 */
public class MergeIntervals {


    public static List<Interval> merge(List<Interval> it) {
        List<Interval> res = new ArrayList<>();
        if (it == null || it.size() == 0) {
            return res;
        }
        //这里如果用lambda表达式,会超时
        Comparator<Interval> comp = new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        };
        Collections.sort(it, comp);
        Interval curr;
        Iterator<Interval> itor = it.iterator();
        curr = itor.next();
        while (itor.hasNext()) {
            Interval tmp = itor.next();
            if (curr.end >= tmp.start) {
                curr.end = Math.max(curr.end, tmp.end);
                itor.remove();
            } else {
                curr = tmp;
            }
        }
        return res;
    }


    public static class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }
}
