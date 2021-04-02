package com.app.arrays;
import java.util.Arrays;
public class SortingAnArray {
	//@Karunakar
    public static void main(String[] args) {
        Integer a[] = { 3, 2, 4, 55, 78, 67, -9 };
        Arrays.stream(sortArray(a)).forEach(e->System.out.print(e+" "));
    }
    public static Integer[] sortArray(Integer arr[]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }
}
