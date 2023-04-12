package org.example;

import java.util.Arrays;

public class Main {

    //no return type, array sorted in place
    public static void mergeSort(int[] array)
    {
        //check whether array is empty or null
        if(array == null || array.length == 0) {
            return;
        }

        if(array.length > 1) {
            //find midpoint of array
            int mid = array.length / 2;
            //create left and right parts of array
            int[] left = Arrays.copyOfRange(array, 0, mid);
            int[] right = Arrays.copyOfRange(array, mid, array.length);

            mergeSort(left);
            mergeSort(right);

            int i = 0, j = 0, k = 0;

            //comparing elements from left and right
            //pushing them to 'array'
            while (i < left.length && j < right.length) {
                //push left to 'array' and increase the index of i
                //should left[i] be less than right[i]
                if (left[i] <= right[j]) {
                    array[k] = left[i];
                    i++;
                } else {
                    array[k] = right[j];
                    j++;
                }
                //increase index of 'array'
                k++;
            }
            //adding the remaining elements to array
            while (i < left.length) {
                array[k] = left[i];
                i++;
                k++;
            }
            while (j < right.length) {
                array[k] = right[j];
                j++;
                k++;
            }
        }

    }

    public static void main(String[] args) {
        int arr[] = {6, 3, 2, 7, 10, 100, 200, -1};
        System.out.println("Given array is " + Arrays.toString(arr));

        mergeSort(arr);

        System.out.println("\nSorted array is " + Arrays.toString(arr));
        }
    }
