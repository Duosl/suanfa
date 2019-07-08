package sort;

import sort.Util;

import java.util.Arrays;

/**
 * 算法: 快速排序 Java实现
 * 思想：
 *  1、取一个标准值，将小于该标准值的数据放在其前面，大于的放在该标准值的后面；
 *  2、将前半部分和后半部分分别执行步骤1（递归）
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = Util.getRandomIntArray();
        System.out.println(Arrays.toString(arr));
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));

    }

    private static void quickSort(int[] arr, int low, int high) {
        if (low >= high) return;
        int mid = QPass(arr, low, high);
        quickSort(arr, low, mid - 1);
        quickSort(arr, mid + 1, high);

    }

    private static int QPass(int[] arr, int low, int high) {
        int key = arr[low];
        System.out.println("key:" + key);
        while (low < high) {
            while (low < high && key <= arr[high]) {//从后面寻找大于key的值
                high--;
            }
            arr[low] = arr[high];
            System.out.println("\t1:" + Arrays.toString(arr));
            while (low < high && key >= arr[low]) {
                low++;
            }
            arr[high] = arr[low];
            System.out.println("\t2:" + Arrays.toString(arr));
        }
        arr[low] = key;
        System.out.println("\t3:" + Arrays.toString(arr));
        System.out.println();
        return low;
    }

}
