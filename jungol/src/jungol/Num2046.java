package jungol;

import java.util.Scanner;

public class Num2046 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("출력할 종류 : ");
		int type = scanner.nextInt();
		System.out.print("한 변의 길이 : ");
		int input = scanner.nextInt();
		int co = 1, i = 0, j = 0, step = 1;
		int arr[][] = new int[input][input];
		switch (type) {
		case 1:
			for (int m = 0; m < arr.length; m++) {
				for (int n = 0; n < arr[i].length; n++) {
					arr[m][n] = co;
					System.out.print(arr[m][n] + " ");
				}
				co++;
				System.out.println();
			}			break;
		case 2:
			while(true){
					arr[i][j] = co;
					if(step ==1)	j++;
					else j--;
					if(j>input-1 || j<0){
						i++; step *= -1;
						if(j<0) j=0;
						else j=input-1;
					}
					co++;
					if(co >input) co =1;
					if(i>input-1) break;
				}
			for (int m = 0; m < arr.length; m++) {
				for (int n = 0; n < arr.length; n++) {
					System.out.print(arr[m][n] + " ");
				}
				System.out.println();
			}			break;
		case 3:
			for (int m = 0; m < arr.length; m++) {
				co = 1;
				for (int n = 0; n < arr.length; n++) {
					arr[0][n] = co ;
					co++;
				}
				arr[m][0] = arr[0][m];
			}
			for (int m = 1; m < arr.length; m++) {
				for (int n = 1; n < arr.length; n++) {
					arr[m][n] = arr[0][n] * arr[m][0];
				}
			}
			for (int m = 0; m < arr.length; m++) {
				for (int n = 0; n < arr.length; n++) {
					System.out.print(arr[m][n] + " ");
				}
				System.out.println();
			}			break;
		default:			System.out.println("입력하신 종류의 번호가 없습니다.");			break;
		}
	}
}
