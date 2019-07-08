package algorithms4th;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class BinarySearch {

    //二分查找 for
    public static int rank(int key, int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == key) return mid;
            else if (arr[mid] > key){
                high = mid-1;
            }else {
                low = mid+1;
            }
        }
        return -1;
    }

    public static int rank2(int key, int[] arr, int low, int high){
        int mid = low + (high - low) / 2;
        if (arr[mid] < key) return rank2(key,arr,mid+1, high);
        else if (arr[mid] > key) return rank2(key,arr,0,mid-1);
        else return mid;
    }

    public static void main(String[] args) {
//        int[] nums = {1,2,4,5,6,7,8,11,34};
//        System.out.println(rank(34,nums));
//        System.out.println(rank2(34,nums,0,nums.length-1));

        int[] whiteList = StdIn.readAllInts();
        Arrays.sort(whiteList);
        while (!StdIn.isEmpty()){
            int key = StdIn.readInt();
            if (rank(key, whiteList)<0){
                StdOut.println(key);
            }
        }

    }
}
