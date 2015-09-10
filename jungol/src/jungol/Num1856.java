package jungol;

import java.util.*;

public class Num1856 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("높이 : ");
		int height = scanner.nextInt();
		System.out.print("너비 : ");
		int weight = scanner.nextInt();
		int co = 1,i = 0, j=0;
		int step = 1;
		int arr[][] = new int[height][weight];
		while(true){
			arr[i][j] = co;
			if(step==1) j++;
			else j--;
			if (j>weight-1 || j<0) {
				i++;
				step *= -1;
				if (j<0) j=0;
				else j=weight-1;
			}
			if (i>height-1) break;
			co++;
		}
		for (int k = 0; k < height; k++) {
			for (int m = 0; m < weight; m++) {
				System.out.print(arr[k][m] + " ");
			}
			System.out.println();
		}
	}
}
