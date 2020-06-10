package 链表;

/**
 * 描述: 寻找重复数，通过快慢指针实现
 * 给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,3,4,2,2]
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: [3,1,3,4,2]
 * 输出: 3
 * 说明：
 * <p>
 * 不能更改原数组（假设数组是只读的）。
 * 只能使用额外的 O(1) 的空间。
 * 时间复杂度小于 O(n2) 。
 * 数组中只有一个重复的数字，但它可能不止重复出现一次。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-the-duplicate-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author xiaojunfeng
 * @date 2020/5/26 14:36
 **/
public class 寻找重复数287 {

    // 快慢指针法
    public static int findDuplicate(int[] nums) {
        int fast = 0;
        int slow = 0;
        // 找出环的位置，找到重复值的下标
        for (; fast != slow || fast == 0; ) {
            fast = nums[nums[fast]];
            slow = nums[slow];
        }
        slow = 0;
        // fast，那么fast就是相遇的点，slow从0开始重新遍历，如果碰到了代表确实有环
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

    /**
     * 二分法，由于数组都是小于n的值，所以算出来均值时，总会在其中另一半
     *
     * @param nums
     * @return
     */
    public static int findDuplicate2(int[] nums) {
        int left = 1;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            int cnt = 0;
            for (int num : nums) {
                if (num <= mid) {
                    cnt += 1;
                }
            }
            if (cnt > mid) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

}
