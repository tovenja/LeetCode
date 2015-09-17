package leetcode.array;

import java.util.*;

/**
 * Created by blank on 2015-09-09 下午9:18.
 */
public class MergeIntervals {


    public static void main(String[] args) {
        List<Interval> para = new ArrayList<>();
        para.add(new Interval(1, 4));
        para.add(new Interval(4, 5));
//        para.add(new Interval(6,7));
//        para.add(new Interval(8,9));
//        para.add(new Interval(1,10));


        List<Interval> res = mergeMine(para);
        System.out.println(res);
    }


    public static List<Interval> mergeMine(List<Interval> it) {
        List<Interval> res = new ArrayList<>();
        if (it == null || it.size() == 0) {
            return res;
        }
        Comparator<Interval> comp = new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if (o1.start - o2.start != 0) {
                    return o1.start - o2.start;
                }
                return o2.end - o1.end;
            }
        };
        Collections.sort(it, comp);
        int begin = it.get(0).start;
        int end = it.get(0).end;
        for (int i = 0; i < it.size() - 1; i++) {
            if (it.get(i).end < it.get(i + 1).start) {
                res.add(new Interval(begin, it.get(i).end));
                begin = it.get(i + 1).start;
            } else {
                it.get(i + 1).end = Math.max(it.get(i).end, it.get(i + 1).end);
            }
            end = it.get(i + 1).end;

        }
        res.add(new Interval(begin, end));
        return res;
    }


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

        @Override
        public String toString() {
            return "{" +
                    start +
                    "," + end +
                    '}';
        }
    }
}
