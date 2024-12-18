import java.util.*;
public class SelectionSort{
  public static void main(String []args){
     Scanner sc =new Scanner(System.in);
      System.out.println("enter no of elements");
      int n=sc.nextInt();
      int[] A=new int[n];
      System.out.println("enter the elements");
      for(int i=0;i<n;i++)
       A[i]=sc.nextInt();
      SelectionSort(A);
      System.out.println("sortedarray");
      for(int i=0;i<A.length;i++)
      System.out.println(A[i]+"");
}
  static void SelectionSort(int[] A){
      int n=A.length;
      for(int i=0;i<n-1;i++){
           int z=i;
            for(int j=i+1;j<n;j++){
                 if(A[j]<A[z]){
                      z=j;
                }
               }
  int temp=A[z];
    A[z]=A[i];
  A[i]=temp;
      }
  }
}

