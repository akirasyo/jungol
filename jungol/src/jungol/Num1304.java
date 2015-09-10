package jungol;

import java.util.Scanner;

public class Num1304 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("한변의 길이 : ");
		int input = scanner.nextInt();
		int arr[][] = new int[input][input];
		int co = 1, i = 0, j = 0 ,step = 1;
		while(true){
			arr[i][j] = co;
			i+=step;
			if(i>=input){
				j++; i = 0;
			}
			co++;
			if(j>=input) break;
		}
		for (int k = 0; k < arr.length; k++) {
			for (int k2 = 0; k2 < arr[i].length; k2++) {
				System.out.print(arr[k][k2]+" ");
			}
			System.out.println();
		}
	}
}
