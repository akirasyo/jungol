package jungol;
//포기 -0-
import java.util.Scanner;

public class Num1331 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("한변의 길이 : ");
		int byun = sc.nextInt();
		int arr[][] = new int[byun+(byun-1)][byun+(byun-1)];
		if(byun%2 ==1)		byun = byun+1;
		int j=(byun + byun -1 )/2, step = 1;
		char co = 65;
/*		while(true){
			arr[i][j] = co;			co++;
			if(co>10)co = 1;			int oldI = i, oldJ=j;
			if(step == 1){			j--;i++;			}
			else if (step ==2){		i++;j++;			}
			else if (step ==3){		j++;i--;			}
			else if (step ==4){		i--;j--;			}
			if(j<0){		step = 2;		j = 1;		i++;	}
			else if(j>byun-1){	step = 4;		j = oldJ-1;	i--;		}
			if(i>byun-1){		step = 3;		i = byun -1;		j++;	}
			else if (i<0){		step = 1;		i = oldI+2;	j--;			}
			if(i ==byun/2 && j ==byun/2) break;		}*/
		for(int i = 0 ; i <4 ;i++){
			System.out.println(arr[i][j]);
			arr[i][j] = co;
			j--;
			co++;
		}
		j=1;
		for(int i = 4 ; i <7 ; i++){
			arr[i][j]=co;
			j++;
			co++;
		}
		for(int i = 5 ; i > 2 ; i--){
			arr[i][j]=co;
			j++;
			co++;
		}
		j = 5;
		for(int i = 2 ; i>0 ; i--){
			arr[i][j]=co;
			j--;
			co++;
		}//step1
		for(int i = 1 ; i <4 ;i++){
			arr[i][j] = co;
			j--;
			co++;
		}
		j = 2;
		//step2
		for(int i = 4 ; i <6 ; i++){
			arr[i][j]=co;
			j++;
			co++;
		}
		//step3
		for(int i = 4 ; i > 2 ; i--){
			arr[i][j]=co;
			j++;
			co++;
		}
		j = 4;
		//step4
		for(int i = 2 ; i>1 ; i--){
			arr[i][j]=co;
			j--;
			co++;
		}//step1
		for(int i = 2 ; i <4 ;i++){
			arr[i][j] = co;
			j--;
			co++;
		}//step3
		j=3;
		for(int i = 4 ; i > 2 ; i--){
			arr[i][j]=co;
			j++;
			co++;
		}
		j=3;
		for(int i = 3 ; i <4 ;i++){
			arr[i][j] = co;
			j--;
			co++;
		}
		for (int k = 0; k < arr.length; k++) {
			for (int l = 0; l < arr.length; l++) {
				System.out.print((char)arr[k][l] + " ");
			}
			System.out.println();
		}
	}
}
