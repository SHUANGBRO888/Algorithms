package Sort;

import java.util.Arrays;

public class RadixSort {
    public static void main(String[] args) {
        RadixSort sorter = new RadixSort();
        int[] nums = {170, 45, 75, 90, 802, 24, 2, 66};
        sorter.radixSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    private static final int NUM_DIGITS = 10;

    public void countingSort(int[] arr, int placeVal) {

        int[] counts = new int[NUM_DIGITS];
            
        for(int elem : arr){
            int cur = elem / placeVal;
            counts[cur % NUM_DIGITS] +=1;
        }
            
        int prev = 0;
        for(int i = 0 ; i < NUM_DIGITS;i++){
            int temp = counts[i];
            counts[i] = prev;
            prev += temp;       
        }
        
        int[] sortedArray = new int[arr.length];
        for(int elem : arr){
            int cur = elem / placeVal;
            sortedArray[counts[cur % NUM_DIGITS]] = elem;
            counts[cur % NUM_DIGITS] ++;   
        }
            
        for (int i = 0; i < arr.length; i++) arr[i] = sortedArray[i];
        // System.arraycopy(sortedArray, 0, arr, 0, arr.length)
    }

    public void radixSort(int[] arr) {
        int maxElem = Integer.MIN_VALUE;

        for (int elem : arr) {
            if (elem > maxElem) maxElem = elem;
        }

        int placeVal = 1;
        while (maxElem / placeVal > 0) {
            countingSort(arr, placeVal);
            placeVal *= 10;
        }
    }

}
