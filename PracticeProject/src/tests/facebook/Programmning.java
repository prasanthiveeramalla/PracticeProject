package tests.facebook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Programmning {
	
	public static void main(String args[]) {
		TestRanks() ;
	}
	
	public static void TestSortRanks(){
	    int k=3; int temp;
	    Integer[] marks= {50, 60, 47,60, 80};
	    List<Integer> aa=new ArrayList<Integer>();
	  Collections.sort(aa);
	  
	}
	public static void TestRanks(){
	    int k=3; int temp;
	    int[] marks= {50, 60, 47,60, 80};
	   Arrays.sort(marks);
	    int[] ranks= {1,2,3,4};
	    
	    for(int i=0;i<marks.length;i++) {
	    	  for(int j=i+1;j<marks.length;j++) {
	    	if(marks[i]>marks[j]) {
	    		temp=marks[i];
	    		marks[i]=marks[j];
	    		marks[j]=temp;
	    	}
	    	  }
	    	
	    }
	HashMap<Integer, Integer> aa=new HashMap<>();
	
	  for(int i=0;i<marks.length;i++) {
		  aa.put(marks[i], i+1);
	  }
	
	    for(int i=marks.length-1;i>=0;i--) {
	    	
	    	if((i!=0) && (marks[i]==marks[i-1])) {
	    		System.out.println("rank is"+marks[i]+" ="+(i+1));
	    		System.out.println("rank is"+marks[i-1]+" ="+(i+1));
	    		
	    		i--;
	    	}else {
	    	System.out.println("rank is"+marks[i]+" ="+(i+1));
	    	}
	    }
	    
	}

public static void fibonacci(){
    int a,b,sum,n;
    a=b=1;
    Scanner sc=new Scanner(System.in);
    System.out.println("How many numbers you want to print in fibonacci series");
    n=sc.nextInt();
    for(int i=1;i<=n;i++){
        System.out.println(a);
        sum=a+b;
        a=b;
        b=sum;
    }

}
public static void minMax(){
    int min,max,n=0;
    Scanner sc=new Scanner(System.in);
    System.out.println("How many elements you want to store in Array");
    n=sc.nextInt();
    int a[]=new int[n];
    System.out.println("Enter '"+n+"' integers to store them in Array");
    for(int i=0;i<n;i++){
        System.out.println("Enter an interger to store in a["+i+"] position");
        a[i]=sc.nextInt();
    }
    //Assume mix and max as the first element of the array
    min=max=a[0];
    for(int i=0;i<n;i++){
        if(min>a[i]){
            min=a[i];
        }
        if(max<a[i]){
            max=a[i];
        }       
    }
    System.out.println("Min= "+min+ " and Max= "+max);
}
public static void palindrome(){
    int n,i,temp;
    int rev=0;
    System.out.println("Enter a number");
    Scanner sc=new Scanner(System.in);
    n=sc.nextInt();
    temp=n;
    while(n!=0){
        i=n%10;
        rev=(rev*10)+i;
        n=n/10;
    }
    System.out.println("Reverse is "+rev);
    if(temp==rev){
        System.out.println("Palindrome");
    }
    else{
        System.out.println("Not a Palindrome");
    }
}
public static void primenumber(){
    int min,max,counter;
    min=max=0;
    Scanner sc=new Scanner(System.in);
    System.out.println("Enter lower bound");
    min=sc.nextInt();
    System.out.println("Enter upper bound");
    max=sc.nextInt();

    //finding and printing prime numbers in descending order
    for(int i=max;i>=min;i--){
        counter=0;
        for(int j=2;j<i;j++){
            if(i%j==0){
                counter++;
            }
        }
        if(counter==0){
            if(i!=1 && i!=0)
                System.out.println(i);
        }
    }
}
public static void reversewords(){
    String input,splitArray[],output="";
    Scanner sc=new Scanner(System.in);
    System.out.println("Enter input string");
    input=sc.nextLine();
    splitArray=input.split(" ");
    for(int i=splitArray.length-1;i>=0;i--){
        if(i==0)
            output=output+splitArray[i];
        else
            output=output+splitArray[i]+" ";
    }
    System.out.println(output);

}
public static void reverse(){
    String input,output="";
    Scanner sc=new Scanner(System.in);
    System.out.println("Enter input string");
    input=sc.nextLine();
    for(int i=input.length()-1;i>=0;i--){
        output=output+input.charAt(i);
    }
    System.out.println(output);
}
public static void duplicates(){
    String input,temp;
    char ch;
    int count=0;       
    System.out.println("Enter a string");
    Scanner sc=new Scanner(System.in);
    input=sc.nextLine();
    temp=input;
    for(int i=0;i<input.length()-1;i++){
        ch=input.charAt(i);
        count=0;
        for(int j=0;j<temp.length()-1;j++){
            if(ch==temp.charAt(j)){
                count++;
            }
        }
        if(count>1){
            System.out.println(ch+"->"+count);
            count=0;               
        }
        temp=temp.replace(ch, '\0');
       
    }


}
}