package leetcode.algorithm.backtracking;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Created by _blank_ on 2015/5/29.
 */
public class CombinationSumIII {

    public static void main(String[] args) {

        new CombinationSumIII().combinationSum3(3,9);
    }


    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> tmp = new ArrayDeque<>();
        if (n == 0 || k == 0 || n / k > 9) {
            return res;
        }
        helper(res, tmp, 1, k, n);
        return res;
    }

    private void helper(List<List<Integer>> res, Deque<Integer> tmp, int start, int k, int n) {
        if (0 == n && k == 0) {
            res.add(new ArrayList<>(tmp));
//            System.out.println(tmp);
            return;
        }
        for (int i = start; i <= 9; i++) {
            tmp.addLast(i);
            helper(res, tmp, i + 1, k - 1, n - i);
            tmp.removeLast();
        }
    }
}
