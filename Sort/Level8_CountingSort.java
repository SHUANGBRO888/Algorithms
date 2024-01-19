package Sort;

import java.util.Arrays;

public class CountingSort {
    public static void main(String[] args) {
        int[] nums = {5, 4, 3, 2, 1};
        countingSort(nums);
        System.out.println(Arrays.toString(nums));
    }


    public static void countingSort(int[] nums) {
        int shift = Arrays.stream(nums).min().getAsInt();
        int K = Arrays.stream(nums).max().getAsInt()-shift;
  
        
        int[] count = new int [K+1];
        for(int num : nums) count[num-shift]++;
        
        int startIndex = 0;
        for(int i = 0; i < K+1;i++){
            int temp = count[i];
            count[i] = startIndex;
            startIndex += temp;
        }
        
        int sortedArray[] = new int[nums.length];
        
        for(int num : nums){
            sortedArray[count[num-shift]]= num;
            count[num-shift]++;
        }
        
        for (int i = 0; i < nums.length; i++) {
            nums[i] = sortedArray[i];
        }
        // System.arraycopy(sortedArray, 0, nums, 0, nums.length);

    }

}
