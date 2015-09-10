package jungol;
import java.util.*;
class N1339{
	char arr[][];
	char co;
	public N1339() {
		start();
	}
	public void start(){
		Scanner sc = new Scanner(System.in);
		int he =0;
		while(true){
		System.out.print("높이 입력 : ");
		he = sc.nextInt();
		if(he >100 && he <0) System.out.println("1~100까지의 정수 입력");
		else if(he%2 ==0) System.out.println("홀수만 입력하시오");
		else break;
		}
		pu(he);
	}
	public void pu(int he){
		int i =he/2 , j =he/2, l = 0;
		co = 65;
		arr = new char[he][he];
		for (int k = he/2; k >= 0; k--) {
			for (int k2 = he/2-l; k2 <= he/2+l; k2++) {
				arr[k2][k]= co;
				co++;
				if(co>90) co = 65;
			}
			l++;
		}
		for (int k = 0; k < arr.length; k++) {
			for (int k2 = 0; k2 < arr.length; k2++) {
				System.out.print(arr[k][k2]+" ");
			}
			System.out.println();
		}
	}
}
public class Num1339 {
	public static void main(String[] args) {
		N1339 n13 = new N1339();
	}
}
