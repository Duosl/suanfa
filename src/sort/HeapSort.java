package sort;

import java.util.Arrays;

/**
 * 堆排序的核心思想
 * 1、创建堆（最大堆）
 *  1）从最后一个非叶子节点（K）开始，比较节点K的左右子节点，找出较大的值同节点K进行比较，如果大于节点K，交换位置；
 *  2）交换位置后，继续判断节点K（位置已发生变化）的左右子节点的左右子节点，直到左右子节点的较大值小于节点K的值；
 *  3）从倒数第二个非叶子节点继续重复步骤 1）和步骤 2），直到堆的根节点。
 * 2、调整堆
 *  1）根节点与最后一个进行交换，对根节点重复创建堆的步骤1）和步骤2）；（交换后的节点不参与排序，因为已经是最大值）
 *  2）倒数第二个和第一个进行交换,...
 *  ...
 *  n-1) 第二个和第一个进行交换,...
 *  n) 堆排序完成。
 */
public class HeapSort {

    static int[] arr = {-1 ,10, 8, 43, 88, 76, 33, 45};

    public static void main(String[] args) {
        heapSort1();

//        int len = arr.length - 1;
//        for (int i = len; i > 2; i--) {
//            System.out.println(i);
//            heapAdjustDesc2(len, i);
//        }
//        System.out.println("创建堆："+ Arrays.toString(arr));
//
//        for (int i = len; i > 1; i--) {
//            heapAdjustDesc2(i,2);
//            int temp = arr[1];
//            arr[1] = arr[i];
//            arr[i] = temp;
//
//        }
//
//        System.out.println("堆排序："+Arrays.toString(arr));

    }

    private static void heapAdjustDesc2(int n, int last) {
        int min;
        for (int i = last/2; 2*i < n ; i = min ) {
            min = 2*i;
            if (last%2 == 0 && arr[min] > arr[min+1]) min++;
            if (arr[i] <= arr[min]) break;
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
    }

    private static void heapSort1() {
        int len = arr.length - 1;
        for (int i = len/2; i > 0; i--) {
//            System.out.println(i + ":" + len);
            heapAdjustAsc1(i, len);
//            heapAdjustDesc1(i, len);
        }

        System.out.println("创建堆："+ Arrays.toString(arr));

        for (int i = len; i > 1; i--) {
            int temp = arr[1];
            arr[1] = arr[i];
            arr[i] = temp;
            heapAdjustAsc1(1,i-1);
//            heapAdjustDesc1(1,i-1);
        }

        System.out.println("堆排序："+Arrays.toString(arr));
    }

    private static void heapAdjustAsc1(int l, int h){
        int temp = arr[l];
        for (int i = 2 * l; i <= h; i *= 2) {
            if (i < h && arr[i] < arr[i+1]) i++;
//            System.out.println(i);
            if (temp >= arr[i]) break;
            arr[l] = arr[i];
            l = i;
        }
        arr[l] = temp;
    }

    private static void heapAdjustDesc1(int l, int h){
        int temp = arr[l];
        for (int i = 2 * l; i <= h; i *= 2) {
            if (i < h && arr[i] > arr[i+1]) i++;
            if (temp < arr[i]) break;
            arr[l] = arr[i];
            l = i;
        }
        arr[l] = temp;
    }
}
