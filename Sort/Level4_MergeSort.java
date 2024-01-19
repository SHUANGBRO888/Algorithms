package Sort;

import java.util.Arrays;

public class MergeSort {
    // Merge sort 
    public static void main(String[] args) {
        int[] test = {5, 4, 3, 2, 1};
        MS ms = new MS();
        ms.sort(test, 0, test.length - 1);
        
        System.out.println(Arrays.toString(test));
    }  
}

class MS {
    
    int[] temp;

    public void sort(int[] nums, int lo, int hi){
            if(lo == hi) return;
            int mid = lo + (hi - lo) / 2;
            sort(nums, lo, mid);
            sort(nums, mid + 1, hi);
            merge(nums, lo, hi, mid);
    }
        
    public void merge(int[] nums, int lo, int hi, int mid){
            temp = new int[nums.length];
            for(int i = lo; i <= hi; i++) temp[i] = nums[i];
            
            int i = lo, j = mid + 1;
            
            for(int p = lo; p <= hi; p++){
                if(i == mid + 1){
                    nums[p] = temp[j++];
                }else if(j == hi + 1){
                    nums[p] = temp[i++];
                }else if(temp[j] > temp[i]){
                    nums[p] = temp[i++];
                }else{
                    nums[p] = temp[j++];
                } 
            }
            
        }
}
