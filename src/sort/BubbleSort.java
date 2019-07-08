package sort;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * 算法: 冒泡排序 Java实现
 * 思想：
 * 1、比较相邻的元素。如果第一个比第二个大，就交换他们两个。
 * 2、对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。这步做完后，最后的元素会是最大的数。
 * 3、针对所有的元素重复以上的步骤，除了最后一个。
 * 4、持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。
 */
public class BubbleSort {

    public static void main(String[] args) {
//        int[] arr1=sort.Util.getRandomIntArray();
//        int[] arr2=new int[arr1.length];
//        for (int i = 0; i < arr1.length; i++) {
//            arr2[i]=arr1[i];
//        }
//        System.out.println(Arrays.toString(arr1));
//        System.out.println(Arrays.toString(bubbleSort(arr1)));
//        System.out.println(Arrays.toString(bubbleSort2(arr2)));

//        bubbleSort11();

    }

    /**
     * 将较小的放在前方
     *
     * @param arr
     * @return
     */
    public static int[] bubbleSort(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                    count++;
                }
            }
        }
        System.out.println("1交换次数：" + count);
        return arr;
    }

    /**
     * 将最大的放在最后
     *
     * @param arr
     * @return
     */
    public static int[] bubbleSort2(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                    count++;
                }
            }
        }
        System.out.println("2交换次数：" + count);
        return arr;
    }


    public static void bubbleSort11() {
        int[] arr = Util.getRandomIntArray();
        System.out.println("原数组：" + Arrays.toString(arr));
        int len = arr.length;
        //方法1
//        for (int i = 0; i < len; i++) {
//            boolean flag = true;
//            for (int j = 0; j < len-i-1; j++) {
//                if (arr[j] > arr[j+1]){
//                    swap(arr, j, j+1);
//                    flag = false;
//                }
//            }
//            if (flag) break;
//        }

        //方法二
        for (int i = 0; i < len; i++) {
            boolean flag = true;
            for (int j = i + 1; j < len; j++) {
                if (arr[i] > arr[j]) {
                    Util.swap(arr, i, j);
                    flag = false;
                }
            }
            if (flag) break;
        }
        System.out.println("排序后：" + Arrays.toString(arr));
    }
}
