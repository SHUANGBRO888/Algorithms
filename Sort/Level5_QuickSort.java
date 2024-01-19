package Sort;

import java.util.Arrays;

public class QuickSort {
    

    // Quick Sort
    public static void main(String[] args) {
        int[] a = new int[] { 2, 3, 1, -1, 7, 0, 9};
        int right = a.length - 1;
        sort(a, 0, right);
        System.out.println(Arrays.toString(a));
    }

    /**
        Initial array: [2, 3, 1, -1, 7, 0, 9]
        QuickSort is called with left = 0 and right = 6 (length of the array - 1)

        QuickSort([2, 3, 1, -1, 7, 0, 9], 0, 6)
        {
            // First Partition:
            // Pivot chosen is 2 (first element).
            // After partitioning: [-1, 1, 0, 2, 7, 3, 9]
            // Pivot position is now index 3.

            QuickSort([-1, 1, 0, 2, 7, 3, 9], 0, 2)
            {
                // Second Partition (left side):
                // Pivot chosen is -1.
                // After partitioning: [-1, 1, 0]
                // Pivot position is index 0.

                QuickSort([-1, 1, 0], 0, -1) // Base case, returns immediately.

                QuickSort([-1, 1, 0], 1, 2)
                {
                    // Pivot is 1.
                    // After partitioning: [-1, 0, 1]
                    // Pivot position is index 2.

                    QuickSort([-1, 0, 1], 1, 1) // Base case, single element, returns immediately.
                }
            }

            QuickSort([-1, 0, 1, 2, 7, 3, 9], 4, 6)
            {
                // Third Partition (right side):
                // Pivot chosen is 7.
                // After partitioning: [-1, 0, 1, 2, 3, 7, 9]
                // Pivot position is index 5.

                QuickSort([-1, 0, 1, 2, 3, 7, 9], 4, 4) // Base case, single element, returns immediately.

                QuickSort([-1, 0, 1, 2, 3, 7, 9], 6, 6) // Base case, single element, returns immediately.
            }
        }

        // Final sorted array: [-1, 0, 1, 2, 3, 7, 9]

     */

    public static void sort(int[] nums, int left, int right){
        if(left >= right) return;
        int p = pivot(nums, left, right);
        sort(nums, left, p - 1);
        sort(nums, p + 1, right);          
    }
    
    public static int pivot(int[] nums, int left, int right){
        int temp = nums[left];
        int i = left , j = right;
        while(i < j){
            while(i < j && nums[j] >= temp){
                j--;
            }
            nums[i] = nums[j];
            while(i < j && nums[i] <= temp){
                i++;
            }
            nums[j] = nums[i];
        }
        nums[i]= temp;
        return i;
    }


}