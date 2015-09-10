package jungol;

public class Test {
	public static void main(String[] args) {
		int arr[][] = new int[7][7];
		int co = 1;
		for (int i = 0; i <= 7; i++) {
			for (int j = 6; j >-1; j--) {
			arr[i][j] = co++;
			i++;
			System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}
