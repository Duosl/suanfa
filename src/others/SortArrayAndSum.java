package others;

/**
 * 给一个有序数组arr和一个整型数据target，找出数组中某两个数相加，结果等于第二个整形参数。
 * 如： arr = [1,2,4,5,7], target = 8  => 0,4
 */
public class SortArrayAndSum {

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,4,5,7};
        int target = 1;
        impl(arr,target);
    }

    private static void impl(int[] arr, int target){
        int i = 0, j = arr.length-1;
        if (arr.length==0) return;
        boolean flag = true;
        while (i<j){
            if (arr[i]+arr[j] == target){
                flag = false;
                System.out.println(i+","+j+" ");
                i++;j--;
            }else if(arr[i]+arr[j] < target){
                i++;
            }else {
                j--;
            }
        }
        if (flag){
            System.out.println("没有找到符合要求的值！");
        }
    }
}
