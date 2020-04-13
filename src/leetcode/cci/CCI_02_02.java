/*
 * Author: Andliage Pox
 * Date: 2020-04-13
 */

package leetcode.cci;

import leetcode.Util;
import leetcode.ds.ListNode;

public class CCI_02_02 {
    public static void main(String[] args) {
        int k = 3;
        ListNode list = Util.buildLinkedList(new int[]{1, 2, 3, 4, 5});
        System.out.println(new CCI_02_02().kthToLast(list, k));
    }

    public int kthToLast(ListNode head, int k) {
        ListNode pre = head;
        ListNode aft = head;
        for (int i = 0; i < k; i++) pre = pre.next;
        while (pre != null) {
            pre = pre.next;
            aft = aft.next;
        }
        return aft.val;
    }
}
