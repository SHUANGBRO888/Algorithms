package Sort;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int[] nums = {5, 3, 8, 4, 2, 7, 1, 6};
        heapSort(nums);
        System.out.println(Arrays.toString(nums));
    }   

    public static void heapSort(int[] nums) {
        int n = nums.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            maxHeapify(nums, n, i);
        }

        for (int i = n - 1; i > 0; i--) {
            swap(i, 0, nums);
            maxHeapify(nums, i, 0);
        }
    }

    public static void maxHeapify(int[] arr, int heapSize, int index){
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        int largest = index;
        if(left < heapSize && arr[left] > arr[largest]) largest =left;
        if(right < heapSize && arr[right] > arr[largest]) largest =right;
        
        if(index != largest){
            swap(largest, index, arr);
            maxHeapify(arr,heapSize,largest);
        } 
    }

    public static void swap(int i, int j, int[] arr) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}