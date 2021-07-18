package asdf;

import java.util.Scanner;

class Main{
    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);
        
        int n=sc.nextInt();
        
        int[] arr = new int[n];
        
        int sumArr = 0;
        
        for(int i=0; i<n; i++) {
        	arr[i]=i+1;
        	sumArr += arr[i];
        
        }
        System.out.println(sumArr);
        sc.close();
    }
}