package jungol;
import java.util.*;
public class Num1719 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int type = 0, si = 0, k = 1;
		char ch ='*';
		while(true){
		System.out.print("1. �� 2. ��  3. �𷡽ð���  4. ����Ī���  5. ���� : ");
		type = sc.nextInt();
		if(type > 5 || type <= 0){
			System.out.println("1~5���� �߿� ���ÿ�");
		}else if(type == 5){
			System.out.println("����");
			System.exit(0);
		}else{
			break;
		}
		}
		while(true){
		System.out.print("ũ�� : ");
		si = sc.nextInt();
		if(si < 0 || si >101) {
			System.out.println("INPUT ERROR!");
		}else if(si%2 == 0){
			System.out.println("Ȧ���� �Է��ϼ���");
		}else{
			break;
		}
		}
		char arr[][] = new char[si][si];
		switch(type){
		case 1 :
			for (int i = 0; i <= arr.length/2; i++) {
				for (int j = 0; j <= i; j++) {
					arr[i][j] = ch;
				}
			}
			for (int i = arr.length/2+1 ; i < arr.length; i++) {
				for (int j = 0 ; j <= si/2-k ; j++) {
						arr[i][j] = ch;
				}
				k++;
			}
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr[i].length; j++) {
					System.out.print((char) arr[i][j]);
				}
				System.out.println();
			}
			break;
		case 2 : 
			for (int i = 0; i <= arr.length/2; i++) {
				for (int j = arr.length-1 ; j >= (arr.length-1)-i ; j--) {
					arr[i][j] = ch;
				}
			}
			for (int i = si/2+1; i < arr.length; i++) {
				for (int j = arr.length-1 ; j >= si/2+k ; j--) {
					arr[i][j] = ch;
				}
				k++;
			}
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr[i].length; j++) {
					System.out.print((char) arr[i][j]);
				}
				System.out.println();
			}
			break;
		case 3 :
			for (int i = 0; i <= arr.length/2; i++) {
				for (int j = 0+i; j < arr.length-i; j++) {
					arr[i][j] = ch;
				}
			}
			for (int i = arr.length/2+1; i < arr.length; i++) {
				for (int j = arr.length-1-i; j <= arr.length/2+k; j++) {
					arr[i][j] = ch;
				}
				k++;
			}
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr[i].length; j++) {
					System.out.print((char) arr[i][j]);
				}
				System.out.println();
			}
			break;
		case 4 :
			for (int i = 0; i <= arr.length/2; i++) {
				for (int j = i; j <= arr.length/2; j++) {
					arr[i][j] = ch;
				}
			}
			for (int i = arr.length/2+1; i < arr.length; i++) {
				for (int j = arr.length/2; j <= arr.length/2+k; j++) {
					arr[i][j] = ch;
				}
				k++;
			}
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr[i].length; j++) {
					System.out.print((char) arr[i][j]);
				}
				System.out.println();
			}
			break;
		default : System.out.println("������ �ٽ� �Է��Ͻÿ�");
		}
	}
}
