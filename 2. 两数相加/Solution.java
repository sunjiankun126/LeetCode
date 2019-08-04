//给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
//
// 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
//
// 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
//
// 示例：
//
// 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
// 输出：7 -> 0 -> 8
// 原因：342 + 465 = 807
// 来源：力扣（LeetCode）
// 链接：https://leetcode-cn.com/problems/add-two-numbers
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        int flag = 0;
        int result = 0;
        ListNode head = new ListNode(0);
        ListNode pre = head;
        ListNode cur = head;
        while (cur1 != null && cur2 != null) {
            result = (cur1.val + cur2.val + flag) % 10;
            flag = (cur1.val + cur2.val + flag) / 10;
            pre = cur;
            cur = new ListNode(result);
            pre.next = cur;
            cur1 = cur1.next;
            cur2 = cur2.next;
        }

        while (cur1 != null) {
            result = (cur1.val + flag) % 10;
            flag = (cur1.val + flag) / 10;
            pre = cur;
            cur = new ListNode(result);
            pre.next = cur;
            cur1 = cur1.next;
        }

        while (cur2 != null) {
            result = (cur2.val + flag) % 10;
            flag = (cur2.val + flag) / 10;
            pre = cur;
            cur = new ListNode(result);
            pre.next = cur;
            cur2 = cur2.next;
        }

        if (flag != 0) {
            result = flag;
            pre = cur;
            cur = new ListNode(result);
            pre.next = cur;
        }
        return head.next;
    }

    // 测试代码，提交答案需删除
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(2);
        ListNode ret = solution.addTwoNumbers(l1, l2);
        System.out.println("");
    }
}