package 链表;

/**
 * 描述: 最优解，通过map实现O(1)检索
 *
 * @author xiaojunfeng
 * @date 2020/5/29 18:39
 **/
public class 两数之和 {
    public static int[] twoSum(int[] nums, int target) {
        int i = 0;
        int sum = 0;
        int j = 0;
        while (i < nums.length) {
            j = i + 1;
            do {
                sum = nums[i] + nums[j];
            } while (sum != target && ++j < nums.length);
            if (sum != target) {
                i++;
            } else {
                break;
            }
        }
        if (sum == target) {
            int[] array = new int[2];
            array[0] = i;
            array[1] = j;
            return array;
        }
        return null;
    }

    public static void main(String[] args) {
        int[] array = new int[4];
        array[0] = 0;
        array[1] = 2;
        array[2] = 4;
        array[3] = 0;
        int[] tmp = 两数之和.twoSum(array, 0);
    }
}
