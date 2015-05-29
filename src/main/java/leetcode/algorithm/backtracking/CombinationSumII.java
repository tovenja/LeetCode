package leetcode.algorithm.backtracking;

import java.util.*;

/**
 * Created by _blank_ on 2015/5/29.
 */
public class CombinationSumII {


    public static void main(String[] args) {
        int[] array = new int[]{10, 1, 2, 7, 6, 1, 5};
        new CombinationSumII().combinationSum2(array, 8);

    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return res;
        }
        Deque<Integer> tmp = new ArrayDeque<>();
        Arrays.sort(candidates);
        helper(res, tmp, 0, target, candidates);
        return res;
    }

    private void helper(List<List<Integer>> res, Deque<Integer> tmp, int start, int target, int[] candidate) {
        if (target == 0) {
            res.add(new ArrayList<>(tmp));
//            System.out.println(tmp);
            return;
        }
        for (int i = start; i < candidate.length && target >= candidate[i]; i++) {
            tmp.addLast(candidate[i]);
            helper(res, tmp, i + 1, target - candidate[i], candidate);
            tmp.removeLast();
            while (i < candidate.length - 1 && candidate[i + 1] == candidate[i]) {
                i++;
            }
        }
    }
}
