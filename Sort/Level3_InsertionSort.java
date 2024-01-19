package Sort;

import java.util.Arrays;

public class InsertionSort {
    // Insertion sort
    public static void main(String[] args) {
        Object[] a = new Object[] { 2, 3, 1, -1, 7, 0, 9};
        InsertionSorting(a);
        System.out.println(Arrays.toString(a));
    }

    // GEZI way 
    public static void InsertionSorting(Object[] arr){
        for(int i = 1; i < arr.length;i++){
            int curIndex = i;
            while(curIndex > 0 && compare(arr[curIndex], arr[curIndex-1]) < 0 ){
                swap(curIndex, curIndex-1, arr);
                curIndex--;
            }
        }
    }

    // modelize
    private static int compare(Object o1, Object o2) {
        if (o1 instanceof Comparable && o2 instanceof Comparable) {
            Comparable c1 = (Comparable) o1;
            Comparable c2 = (Comparable) o2;
            return c1.compareTo(c2);
        } else {
            throw new ClassCastException("Objects are not comparable");
        }
    }
    public static void swap(int i, int j, Object[] arr) {
        Object temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}