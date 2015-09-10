package jungol;

import java.util.Scanner;

public class Num1307 {
	public static void main(String[] args) {
		int wh = input();
		int arr[][] = new int[wh][wh];
		char co = 65;
		int i = wh-1, j = wh-1;
		while(true){
			arr[i][j] = co;
			co++;
			if(co > 90) co = 65;
			i--;
			if(i<0){
				i=wh-1;
				j--;
			}
			if(i == 0 && j == 0){
				arr[i][j] = co;
				break;
			}
		}
		for (int m = 0; m < arr.length; m++) {
			for (int n = 0; n < arr[m].length; n++) {
				System.out.print((char)arr[m][n] + " ");
			}
			System.out.println();
		}
	}
	public static int input(){
		Scanner sc = new Scanner(System.in);
		while(true){
		System.out.print("한 변의 길이 : ");
		int wh = sc.nextInt();
		if(wh>0 && wh<101) return wh;
		else System.out.println("1~100 사이로 입력하시오.");
		}
	}
}
