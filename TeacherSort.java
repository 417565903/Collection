package Collection;

import java.util.Arrays;

public class TeacherSort {
    private static void  sore(int[] a){
        int start = 0;
        int end = a.length-1;
        qSore(a,start,end);
    }
    public static void qSore(int[] a,int start,int end){
        if(start>=end){return;}
        int postion = sortForIndex(a, start, end);

        qSore(a,start,postion-1);
        qSore(a,postion+1,end);

    }


    private static int sortForIndex(int[] array, int start, int end) {
        int key = array[start];
        while (start<end){
            while (array[end]>=key&&start<end){
                end--;
            }
            array[start] = array[end];
            while (array[start]<=key&&start<end){
                start++;
            }
            array[end] = array[start];
        }
        array[start]=key;
        return start;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1,4,5,6,7,21,123,45,123,1};
        System.out.println(Arrays.toString(a));
        sore(a);
        System.out.println(Arrays.toString(a));
    }
}
