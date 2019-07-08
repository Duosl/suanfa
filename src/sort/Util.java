package sort;

import java.util.Arrays;
import java.util.Random;

public class Util {

    public static int[] getRandomIntArray(){
        Random random=new Random();
        int[] arr=new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i]=random.nextInt(50);
        }
        return arr;
    }


    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        System.out.println("\t"+ Arrays.toString(arr));
    }
}
