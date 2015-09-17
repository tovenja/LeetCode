package leetcode.array;

import leetcode.define.Interval;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by blank on 2015-09-09 下午11:38.
 */
public class InsertInterval {

    public List<Interval> insert(List<Interval> it, Interval n) {
        List<Interval> res = new ArrayList<>();
        if (n == null) {
            return it;
        }
        if (it == null || it.size() == 0) {
            res.add(n);
            return res;
        }
        Iterator<Interval> itr = it.iterator();
        Interval pre = itr.next();
            if (!itr.hasNext()){
                it.add(n);
            }
        boolean last = true;
        while (itr.hasNext()) {
            Interval curr = itr.next();
            if (curr.end < n.start) {
                pre = curr;
            } else {
                last = false;
                if (curr.end < n.end) {
                    curr.end = n.end;
                }
                if (curr.end <= pre.end) {
                    itr.remove();
                } else if (curr.start < pre.end) {
                    pre.end = curr.end;
                    itr.remove();
                } else{
                    pre =curr;
                }
            }
        }
        if (last) {
            it.add(n);
        }
        return it;
    }
}
