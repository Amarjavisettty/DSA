import java.util.*;
class LinearSearch{
       	public static void main(String args[])
	{
		Scanner sc =new Scanner(System.in);
		System.out.println("enter size of array");
		int n=sc.nextInt();
		int [] A=new int[n];
		System.out.println("enter "+ n +"numbers");
		for(int i=0;i<n;i++)
		A[i]=sc.nextInt();
		System.out.println("enter element to search");
		int key=sc.nextInt();
		int result=LinearSearch(A,key);
		if(result!=-1)
			System.out.println("Element found in the array.");
			
		else
			System.out.println("Element  not found  ");
	}
	public static int LinearSearch(int[] A,int key){
		for(int i=0;i<A.length;i++)
			if(A[i]==key)
				return i;
	       return -1;
       }
}





output
  enter size of array
4
enter 4nembers
2 4 6 7
enter element to search
5
Element  not found  
