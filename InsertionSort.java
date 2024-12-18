import java.util.*;
public class InsertionSort{
      public static void main(String []args){
             Scanner sc =new Scanner(System.in);
             System.out.println("enter no of elements");
             int n=sc.nextInt();
             int[] A=new int[n];
            System.out.println("enter the elements");
             for(int i=0;i<n;i++)
             A[i]=sc.nextInt();
            InsertionSort(A);
            System.out.println("sortedarray");
            for(int i=0;i<A.length;i++)
           System.out.println(A[i]+"");
}
      static void InsertionSort(int[] A){
                   int n=A.length;
                   for(int i=0;i<n;i++){
                             int z=A[i];
                             int j=i-1;
                               while( j>=0 && A[j]>z){
                                          A[j+1]=A[j];
                                            j--;
                                         }
                                           A[j+1]=z;
                                            
       } 
    }
 }
 output  
   enter no of elements
5
enter the elements
2 5 3 4 1
sortedarray
1
2
3
4
5
