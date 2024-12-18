import java.util.*;
public class BubbleSort{
    public static void main(String []args){
        Scanner sc =new Scanner(System.in);
        System.out.println("enter no of elements");
         int n=sc.nextInt();
         int[] A=new int[n];
         System.out.println("enter the elements");
         for(int i=0;i<n;i++)
          A[i]=sc.nextInt();
          bubbleSort(A);
          System.out.println("sortedarray");
          for(int i=0;i<A.length;i++)
          System.out.println(A[i]+"");
}
   static void bubbleSort(int[] A){
       int n=A.length;
       for(int i=0;i<n-1;i++)
         for(int j=0;j<n-i-1;j++)
            if(A[j]>A[j+1]){
                   int temp=A[j];
                   A[j]=A[j+1];
                   A[j+1]=temp;
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
