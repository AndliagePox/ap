/*
 * Author: Andliage Pox
 * Date: 2020-03-19
 */

package leetcode.solution;

import java.util.LinkedList;
import java.util.List;

public class Solution00077 {
    private int n;
    private int k;
    private List<List<Integer>> ans = new LinkedList<>();

    public static void main(String[] args) {
        int k = 2;
        int n = 4;
        for (List<Integer> list: new Solution00077().combine(n, k)) {
            System.out.println(list);
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        this.n = n;
        this.k = k;
        backtrack(1, new LinkedList<>());
        return ans;
    }

    private void backtrack(int index, LinkedList<Integer> list) {
        if (list.size() == k) {
            ans.add(new LinkedList<>(list));
            return;
        }

        for (int i = index; i <= n; i++) {
            list.add(i);
            backtrack(i + 1, list);
            list.removeLast();
        }
    }
}
