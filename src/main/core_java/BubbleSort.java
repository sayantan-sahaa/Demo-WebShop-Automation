package core_java;

import java.util.Arrays;

public class BubbleSort {

    public static void bubbleSort1(int[] arr){

        for(int i = 0; i<arr.length; i++){
            System.out.println(Arrays.toString(arr));
        }

        for (int i = 0; i < arr.length; i++) {
            boolean swap = false;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swap = true;
                }
            }

            if (!swap) {
                break;
            }
        }

        for(int i = 0; i<arr.length; i++){
            System.out.println(Arrays.toString(arr));
        }


    }

    public static void swap(int[] arr){

        for (int i = 0; i < arr.length; i++) {
            boolean swap = false;

            if (arr[i]>arr[i+1]){

                int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    swap = true;

            }
            if (!swap) {
                break;
            }
        }

    }

    public static void bubbleSort2(int[] arr){

        for(int i = 0; i<arr.length; i++){
            System.out.println(Arrays.toString(arr));
        }

        swap(arr);



        

        for(int i = 0; i<arr.length; i++){
            System.out.println(Arrays.toString(arr));
        }


    }
    
}
