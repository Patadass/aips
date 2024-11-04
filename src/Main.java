import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int[] a = {5,4,2,1,9,0,2};
        new Sort.MergeSort(a);
        for(int i = 0;i < a.length;i++){
            System.out.print(a[i] + " ");
        }
    }
}