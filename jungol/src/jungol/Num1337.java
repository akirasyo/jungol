package jungol;
import java.util.*;
public class Num1337 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int height = 0, step =1, i = 0, j = 0, l = 1, h = 0;
		char co = 48;
		char arr[][] = new char[1][1];
		while(true){
			System.out.print("크기 : ");
			height = sc.nextInt();
			if(height < 0 || height >101) {
				System.out.println("1부터 100이하의 정수만 입력하세요");
			}else{
				break;
			}
		}
		arr = new char[height][height];
		while(true){
			arr[i][j] = co;
			if(step == 1)	{
				i++; j++;			
			}else if(step == 2)	j--;
			else if(step ==3)	i--;
			if(i>height-l && j>height-l){
				step=2;
				i=height-l;
				j=height-1-l;
			}else if(j < l-1&& step ==2){
				step = 3;
				j=l-1;
				i=i-1;
				l++;
			}else if(arr[i][j] != 0 && i<=l+h && step ==3){
				step =1;
				j = l-1;
				if (l < 3) {
					i = l;
				}else {
					i = i+2;
					h+=1;
				}
			}else if(arr[i][j] != 0 && i>height-l && step ==1){
				step = 2;
				i=height-l;
				j=j-2;
			}
			co++;
			if(co>57) co = 48;
		if(arr[i][j] != 0)	break;
		}
		for (int k = 0; k < arr.length; k++) {
			for (int k2 = 0; k2 < arr.length; k2++) {
				System.out.print(arr[k][k2] + " ");
			}
			System.out.println();
		}
	}
}
