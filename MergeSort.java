import java.io.*;

class MergeSort {

   public static void Merge(int a[], int low, int mid, int high)
    {
         int i=low,j=mid+1,k=i;
         int[] b=new int[high+1];
        while (i <=mid&& j <=high) {
            if (a[i] < a[j]) {
                b[k++]=a[i++];
            }
            else {
                b[k++]=a[j++];
            }
        }

        while (i <=mid) {
            b[k++]=a[i++];
        }

        while (j <=high) {
            b[k++]=a[j++];
        }
        for(int l=low;l<=high;l++){
            a[l]=b[l];
        }
    }

   public static void mergesort(int a[], int low, int high)
    {
        if (low < high) {

            int mid = (low+high) / 2;

            mergesort(a, low, mid);
            mergesort(a,  mid+ 1, high);

            Merge(a, low, mid, high);
        }
    }

    public static void main(String args[])
    {
        int a[] = { 12, 11, 13, 5, 6, 7 };
        int low=0,high=a.length-1;
        mergesort(a,low,high);
        for(int k:a){
            System.out.println(k);
        }

        
    }
}
output
 5
6
7
11
12
13 
