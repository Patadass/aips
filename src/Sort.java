public class Sort {
    static class MergeSort{
        MergeSort(int[] a){
            sort(a,0,a.length-1);
        }
        private static void sort(int[] a, int start, int end){
            if(start >= end){
                return;
            }
            int mid = (start + end) / 2;
            sort(a,start,mid);
            sort(a,mid+1,end);
            for(int i = start;i <= mid;i++){
                System.out.print(a[i] + " ");
            }
            System.out.print("    |    ");
            for(int i = mid + 1;i <= end;i++){
                System.out.print(a[i] + " ");
            }
            System.out.print("\n");
            merge(a,start,mid,end);
        }
        private static void merge(int[] a, int start, int mid, int end){
            int nl = mid - start + 1;
            int nr = end - mid;
            int[] left = new int[nl];
            int[] right = new int[nr];
            for(int i = 0;i < nl;i++){
                left[i] = a[start + i];
            }
            for(int i = 0;i < nr;i++){
                right[i] = a[i + mid + 1];
            }
            int i = 0;
            int j = 0;
            int k = start;
            while(i < nl && j < nr){
                if(left[i] <= right[j]){
                    a[k] = left[i];
                    i++;
                }else{
                    a[k] = right[j];
                    j++;
                }
                k++;
            }
            while(i < nl){
                a[k] = left[i];
                i++;
                k++;
            }
            while(j < nr){
                a[k] = right[j];
                j++;
                k++;
            }
        }
    }
}
