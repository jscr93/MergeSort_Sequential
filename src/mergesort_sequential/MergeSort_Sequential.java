/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mergesort_sequential;

import java.util.Arrays;
/**
 *
 * @author Saul Chavez
 */
public class MergeSort_Sequential {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[] array = {8,7,6,9,5,3,3,4,1,2};
        mergeSort_Sequential(array);
    }
    
    public static void mergeSort_Sequential(int a[ ]){
        int tmpArray[] = new int[a.length];
        System.out.println(Arrays.toString(a));
        mergeSort(a,tmpArray, 0, a.length - 1);
        System.out.println(Arrays.toString(tmpArray));
    }
    
    public static void mergeSort( int a[], int tmpArray[], int left, int right){
        if ( left < right) {
            int center = (left + right) / 2;
            mergeSort(a, tmpArray, left, center);
            mergeSort (a, tmpArray, center + 1, right);
            merge(a, tmpArray, left, center + 1, right);
        }
    }
    
    private static void merge(int a[], int tmpArray[], int leftPos,
            int rightPos, int rightEnd){
        int leftEnd = rightPos - 1;
        int tmpPos = leftPos;
        int numElements = rightEnd - leftPos + 1;
        while ( leftPos <= leftEnd && rightPos <= rightEnd) { //Main loop
            if(a[leftPos] < a[rightPos]){
                tmpArray[tmpPos++] = a[leftPos++];
            } else {
                tmpArray[tmpPos++] = a[rightPos++];
            }
        }
        while(leftPos <= leftEnd){
            tmpArray[tmpPos++] = a[leftPos++];              //Copy the rest of first half
        }
        while(rightPos <= rightEnd){
            tmpArray[tmpPos++] = a[rightPos++];             //Copy rest of right half
        }
        for (int i = 0; i < numElements; i ++, rightEnd--){ //Copy TmpArray back
            a[rightEnd] = tmpArray[rightEnd];
        }
    }
}
    
    

