package jungol;
import java.util.*;
class N2071{
	int arr[][];
	int in;
	public N2071() {
		start();
	}
	public void start(){
		Scanner sc = new Scanner(System.in);
		while(true){
			System.out.print("1. �����ﰢ�� 2. ���ﰢ�� 3.�����̹غ��� �����ﰢ�� 4.���� : ");
			int select = sc.nextInt();
			System.out.print("���� : ");
			in = sc.nextInt();
			switch(select){
			case 1: 	case1();				break;
			case 2:	case2();				break;
			case 3:	case3();				break;
			case 4:	exit();					break;
			default:	System.out.println("�߸� �Է��Ͽ����ϴ�.");					break;
			}		
		}
	}
	public void case1(){
		arr = new int[in][in];
		char su = 1;
		for (int i = 0; i < arr.length; i++) {
			arr[i][0]= su;
			for (int j = 0; j <= i; j++) {
				if(j == i ) {
					arr[i][j] = su;
				}else{}
			}
		}
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j <=i; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
	public void case2(){
	}
	public void case3(){
	}
	public void exit(){
		System.out.println("�����մϴ�.");
		System.exit(0);
	}
	
}
public class Num2071 {
	public static void main(String[] args) {
		N2071 n20 = new N2071();
	}
}
