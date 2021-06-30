package test1_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


class Main{
    public static void main(String[] args) throws IOException {
    	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = bf.readLine().split(" ");
        int a = Integer.parseInt(strs[0]);
        int b = Integer.parseInt(strs[1]);
        
        System.out.println(a+b);
        bf.close();
        return;
    }
}