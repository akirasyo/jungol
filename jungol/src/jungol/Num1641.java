package jungol;

import java.util.*;

public class Num1641 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int type = 0, si = 0, k = 1;
		char co = '0';
		int arr[][];
		while(true){
			System.out.print("1. 직각 2. ▼  3. ▶  4. 종료 : ");
			type = sc.nextInt();
			if(type > 5 || type <= 0){
				System.out.println("1~4까지 중에 고르시오");
			}else if(type == 4){
				System.out.println("종료");
				System.exit(0);
			}else{
				break;
			}
		}
		while(true){
			System.out.print("크기 : ");
			si = sc.nextInt();
			if(si < 0 || si >101) {
				System.out.println("INPUT ERROR!");
			}else if(si%2 == 0){
				System.out.println("홀수만 입력하세요");
			}else{
				break;
			}
		}
		switch(type){
		case 1 :
			arr = new int[si][si];
			int m = 0, n = 0, step =1;
			while(true){
				arr[m][n] = co - 47;
				co++;
				if(step ==1){
					n++;
				}else{
					n--;
				}
				if(n>m){
					step =-1;
					m++;n=m;
				}else if(n<0){
					step=1;
					m++;n=0;
				}
				if(m==si&& n==si) break;
			}
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr.length; j++) {
					System.out.print(arr[i][j] + " ");
				}
				System.out.println();
			}
			break;
		case 2 :
			arr = new int[si][si+si-1];
			co = '0';
			for (int i = 0; i < si; i++) {
				for (int j = 0+i; j <si+si-1-i ; j++) {
					arr[i][j] = co;
				}
				co++;
			}
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr[i].length; j++) {
					System.out.print((char)arr[i][j] +" ");
				}
				System.out.println();
			}
			break;
		case 3 :
			arr = new int[si][si];
			co='0';
			for (int i = 0; i <= si/2; i++) {
				co++;
				for (int j = 0+i; j <si-i ; j++) {
					arr[j][i] = co;
				}
			}
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr[i].length; j++) {
					System.out.print((char) arr[i][j] +" ");
				}
				System.out.println();
			}
			break;
		default :	System.out.println("잘못 누름");	break;
		}
		
	}
}
