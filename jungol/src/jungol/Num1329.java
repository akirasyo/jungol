package jungol;

import java.util.*;

public class Num1329 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int height = 0;
		char ch = '*';
		char arr[][] = new char[1][1];
		while(true){
			System.out.print("1. ���� 2. ���� : ");
			int sel = sc.nextInt();
			if(sel ==2){
				System.out.println("�����մϴ�.");
				System.exit(0);
			}
		switch(sel){
		case 1:
		System.out.print("���� : ");
		height = sc.nextInt();
		if(height >100){
			System.out.println("INPUT ERROR!!");
		}else if(height%2 ==0){
			System.out.println("Ȧ���� �Է�");
			break;
		}
		int k = 2;
		arr = new char[height][height+height/2];
		for (int i = 0; i <= arr.length/2; i++) {
			for (int j = i; j <= i*3; j++) {
				arr[i][j] = ch;
			}
		}
		for (int i = arr.length/2+1; i < arr.length; i++) {
			for (int j = i-k; j <= (i-k)*3; j++) {
				arr[i][j]=ch;
			}
			k+=2;
		}
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
		break;
		case 2: System.exit(0); break;
		default: System.out.println("�ٽ� ������");break;
		}
		}
	}
}
