package jungol;

import java.util.*;

public class Num1523 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char ch = '*';
		while(true){
			System.out.print("1.직각삼각형(위) 2. 직각삼각형(아래) 3. 정삼각형 4. 종료\n종류 : ");
			int type = sc.nextInt();
			if(type ==4) System.exit(0);
			System.out.print("높이 : ");
			int height = sc.nextInt();
			if(height < 0 || height > 100) System.out.println("INPUT ERROR!!");
			int arr[][] = new int[height][height];
		switch(type){
		case 1 :
			for (int i = 0; i < height; i++) {
				for (int j = 0; j <= i; j++) {
					arr[j][i] = ch;
					System.out.print((char) arr[j][i]);
				}
				System.out.println();
			}
			break;
		case 2 :
			for (int i = 0; i < height; i++) {
				for (int j = height-1-i; j >= 0; j--) {
					arr[i][j] = ch ;
					System.out.print((char) arr[i][j]);
				}
				System.out.println();
			}
			break;
		case 3 : 
			arr = new int[height][height+height-1];
			if(height>4 && height%2==1) height = height+1;
			for (int i = 0; i < arr.length; i++) {
				for (int j = arr.length-1; j >= (arr.length-1)-i; j--) {
					arr[i][j] = ch ;
				}
			}
			for (int i = 1; i < arr.length; i++) {
				for (int j = arr.length; j < arr.length+i; j++) {
					arr[i][j] = ch;
				}
			}
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr[i].length; j++) {
					System.out.print((char) arr[i][j]);
				}
				System.out.println();
			}
			break;
		default : System.out.println("종류를 잘못 입력하였습니다.");
		}
	}
	}
}
