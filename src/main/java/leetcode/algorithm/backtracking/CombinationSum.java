package leetcode.algorithm.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by _blank_ on 2015/5/29.
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();

        if (candidates == null || candidates.length == 0) {
            return res;
        }
        Arrays.sort(candidates);
        List<Integer> tmp = new ArrayList<>();
        helper(res, tmp, 0, candidates, target);
        return res;
    }

    private void helper(List<List<Integer>> res, List<Integer> tmp, int start, int[] candidates, int target) {
        if (0 == target) {
            res.add(new ArrayList<>(tmp));
            // System.out.println(tmp);
            return;
        }
        for (int i = start; i < candidates.length && target >= candidates[i]; i++) {
            tmp.add(candidates[i]);
            helper(res, tmp, i, candidates, target - candidates[i]);
            tmp.remove(tmp.size() - 1);
        }
    }
}
