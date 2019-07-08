package sort;

import java.util.Arrays;


/**
 * 插入排序
 * 思想：
 *  将第一待排序序列第一个元素看做一个有序序列，把第二个元素到最后一个元素当成是未排序序列。
 *  从头到尾依次扫描未排序序列，将扫描到的每个元素插入有序序列的适当位置。（如果待插入的元素与有序序列中的某个元素相等，则将待插入元素插入到相等元素的后面。）
 */
public class InsertSort {

    public static void main(String[] args) {
        int[] arr = Util.getRandomIntArray();
        System.out.println("原数组："+ Arrays.toString(arr));
        insertSort(arr);
        System.out.println("排序后："+ Arrays.toString(arr));
    }

    private static int[] insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {

            int temp = arr[i];//待插入的数据
            int j = i;
            //从已排序的数组的最右边开始比较，将该数据插入到相应的位置（注：i之前是排好序的数组）
            while (j>0 && temp < arr[j-1]){
                arr[j] = arr[j-1];
                j--;
            }

            //如果i和j不相等，则说明待插入的数据比已排序数组中某个位置的数据小，将其放在适当的位置，形成新的已排序数组
            if (j != i){
                arr[j] = temp;
            }

        }
        return arr;
    }
}
