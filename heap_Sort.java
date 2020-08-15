package Heap_Sort;

import java.util.Arrays;
import java.util.Scanner;

public class Heap_Sort {
    public void sort(int arr[]) {
        int n = arr.length;

        // Build max heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // Heap sort
        for (int i = n - 1; i >= 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Heapify root element
            heapify(arr, i, 0);
        }
    }

    void heapify(int arr[], int n, int i) {
        // Find largest among root, left child and right child
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < n && arr[l] > arr[largest])
            largest = l;

        if (r < n && arr[r] > arr[largest])
            largest = r;

        // Swap and continue heapifying if root is not largest
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            heapify(arr, n, largest);
        }
    }

    // Driver code
    public static void main(String args[]) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("enter the size of the array");
        int size=scanner.nextInt();
        int arr[] = new int[size];
        System.out.println("enter elements");
        for(int i=0;i<size;i++){
            arr[i]=scanner.nextInt();
        }

        Heap_Sort hs = new Heap_Sort();
        hs.sort(arr);


        System.out.println("sorted array is:");
        for(int i=0;i<size;i++){
            System.out.println(arr[i]);
        }
    }
}

