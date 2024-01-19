package Sort;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] nums = new int[] { 2, 3, 1, -1, 7, 0, 9};
        SelectionSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void SelectionSort(int[] nums){
        // bubble sort
        boolean hasSwaped = true;
        while(hasSwaped){
            hasSwaped = false;
            for(int i = 0; i < nums.length-1;i++){
                if(nums[i] > nums[i+1]){
                    swap(i, i+1, nums);
                    hasSwaped = true;
                }
            }
        }
    }

    public static void swap(int i, int j, int[] arr) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
