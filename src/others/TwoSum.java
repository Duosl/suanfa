package others;

import java.util.Arrays;

/**
 * 题目描述：在有序数组中找出两个数，使它们的和为 target。
 * 如：
 * Input: numbers={2, 7, 11, 15}, target=9
 * Output: index1=0, index2=1
 */
public class TwoSum {

    public static void main(String[] args) {
        TwoSum ts = new TwoSum();
        int[] numbers = new int[]{2, 7, 11, 15};
        int[] result = ts.twoSum(numbers, 13);
        if (result == null){
            System.out.println("没有找到需要的结果");
        }else {
            System.out.println(Arrays.toString(result));
        }

    }

    private int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1 - i;
        while (i < j) {
            int sum = numbers[i] + numbers[j];
            if (sum == target) {
                return new int[]{i, j};
            }else if (sum < target){
                i++;
            }else {
                j--;
            }
        }
        return null;
    }
}
