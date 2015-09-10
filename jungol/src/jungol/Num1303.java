package jungol;

import java.util.Scanner;

public class Num1303 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("높이 : ");
		int height = scanner.nextInt();
		System.out.print("너비 : ");
		int weight = scanner.nextInt();
		int co = 1;
		int arr[][] = new int[height][weight];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = co ;
				co++;
			}
		}
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(" "+arr[i][j]);
			}
			System.out.println();
		}
	}
}
