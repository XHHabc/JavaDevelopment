package Test04;

public class 插入_链式 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(6);
        head.next.next = new ListNode(9);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        ListNode sortedList = insertionSortList(head); // 调用插入排序算法
        while (sortedList != null) {
            System.out.print(sortedList.val + " ");
            sortedList = sortedList.next;
        }
    }
    public static ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0); // 创建虚拟头节点
        dummy.next = head;
        ListNode lastSorted = head; // 已排序部分的最后一个节点
        ListNode cur = head.next; // 待插入节点
        while (cur != null) {
            if (lastSorted.val <= cur.val) { // 待插入节点比已排序部分的最大节点值大，无需插入
                lastSorted = lastSorted.next;
            } else { // 待插入节点比已排序部分的最大节点值小，需要插入到适当位置
                ListNode prev = dummy; // 从虚拟头节点开始遍历
                while (prev.next.val <= cur.val) { // 找到待插入节点的插入位置
                    prev = prev.next;
                }
                lastSorted.next = cur.next; // 将待插入节点从原位置删除
                cur.next = prev.next; // 将待插入节点插入到正确位置
                prev.next = cur;
            }
            cur = lastSorted.next; // 待插入节点更新为已排序部分的下一个节点
        }
        return dummy.next;
    }
}