package leetcode.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * HeapSort
 * Created by blank on 15/8/12.
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] arr = new int[100000];
        for (int i = 0; i < 100000; i++) {
            arr[i] = new Random().nextInt(100000000);
        }
        int[] copy = arr.clone();
        heapSort(arr);
        Arrays.sort(copy);
        for (int i = 0; i < 100000; i++) {
            if (arr[i] != copy[i]) {
                System.out.println("wrong");
            }
        }
        System.out.println("right");
    }

    static void heapSort(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }
        for (int i = (array.length - 1) / 2; i >= 0; i--) {
            siftDown(array, i, array.length);
        }
        for (int i = array.length - 1; i >= 0; i--) {
            swap(array, i, 0);
            siftDown(array, 0, i);
        }
    }

    private static void swap(int[] array, int a, int b) {
        if (a >= array.length || b >= array.length) {
            return;
        }
        int tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
    }

    private static void siftDown(int[] array, int root, int hi) {
        int half = hi >>> 1;
        while (root < half) {
            int child = root * 2 + 1;
            if (child >= hi) {
                return;
            }
            if (child + 1 < hi && array[child + 1] > array[child]) {
                child++;
            }
            if (array[child] < array[root]) {
                return;
            }
            swap(array, root, child);
            root = child;
        }
    }

}
