package others;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组(可能是无序的) nums 和一个目标值 target，请你在该数组中找出和为目标值的 两个整数。
 * 如：
 * Input: numbers={2, 7, 11, 15}, target=9
 * Output: index1=0, index2=1
 * <p>
 * Input: numbers={3，2，4}, target=6
 * Output: index1=1, index2=2
 */
public class TwoSum2 {

    public static void main(String[] args) {
        TwoSum2 ts = new TwoSum2();
        int[] numbers = new int[]{3, 2, 4};
        int[] result = ts.twoSum3(numbers, 6);
        if (result == null) {
            System.out.println("没有找到需要的结果");
        } else {
            System.out.println(Arrays.toString(result));
        }
    }

    private int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    private int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int another = target - nums[i];
            if (map.containsKey(another) && map.get(another) != i) {
                return new int[]{i, map.get(another)};
            }

        }
        return null;
    }

    private int[] twoSum3(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int another = target - nums[i];
            if (i > 0 && map.containsKey(another)) {
                return new int[]{i, map.get(another)};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
