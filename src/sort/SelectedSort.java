package sort;

import sort.Util;

import java.util.Arrays;

/**
 * 选择排序
 * 思想：
 * 1、从未排序的数组中寻找最小的数，放在首位置（与第一个交换位置）；
 * 2. 再从剩下的后面找到最小的（第二小）的数，放在第二个位置（与第二个交换位置），
 * ...
 * n. 直到排序完成
 */
public class SelectedSort {

    public static void main(String[] args) {
        int[] arr = Util.getRandomIntArray();
        System.out.println("原数组："+ Arrays.toString(arr));
        selectedSort(arr);
        System.out.println("排序后："+ Arrays.toString(arr));
    }

    private static int[] selectedSort(int[] arr) {

        for (int i = 0; i < arr.length-1; i++) {
            int min = i;
            for (int j = i+1; j < arr.length; j++) {
                if (arr[j] < arr[min]){
                    min = j;
                }
            }
            if (min != i){
                Util.swap(arr,min,i);
            }
        }
        return arr;
    }


}
