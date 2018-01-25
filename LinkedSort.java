package Collection;

import com.sun.javafx.css.Size;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LinkedSort {
    public static void main(String[] args) {
        int[] arr =new int[]{12,23,56,123,4654,1,158,1};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void sort(int[] arr){
        qSort(arr,0,arr.length-1);
    }
    public static void qSort(int[] arr,int start,int end){
        int i = start;
        int j = end;
        int key = arr[i];
        if(start>=end){return;}
        while (i<j){
            while (arr[j]>=key&&i<j){
                j--;
            }
            arr[i] = arr[j];
            while (arr[i]<=key&&i<j){
                i++;
            }
            arr[j] = arr[i];
        }
        arr[i] = key;

        qSort(arr,start,i-1);
        qSort(arr,i+1,end);
    }

}

