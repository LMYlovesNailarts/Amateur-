/* 180722 3번 */

import java.util.Scanner;

class prac0722_3 {
	static int T, N, count;
	static int[][] sqArr;
	static int[] detectArr, cmprArr, result;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		result = new int[T];
		
		for(int iter=0; iter<T; iter++) {
			N = sc.nextInt();
			if (N<1 || N>10)
				System.exit(0);
			sqArr = new int[N][N];
			
			for (int i=0; i<sqArr.length; i++) {
				for (int j=0; j<sqArr[i].length; j++) {
					sqArr[i][j] = sc.nextInt();
				}
			}
						

			count=0; 
			for (int k=0; k<sqArr.length;k++) {
				for (int l=0; l<sqArr[k].length; l++) {
					if(detect(k,l)) 
						count++;
				}
			}
			result[iter] = count;
		}
		
		for(int k=0; k<result.length; k++) {
			System.out.println("#" + (k+1) + " " + result[k]);
		}
		sc.close();
	}

	
	
	public static boolean hasIndex(int[] detectArr, int i) {
		for (int e : detectArr)
		   if (e == i) {
			   return true;
		   }
		return false;
	} 
	
	
	
	public static boolean detect(int a, int b) {
		if (sqArr[a][b] == 0) {
			return false;
		}
		
		int n=0; 
		for (int i=a-1; i<a+2; i++ ) {
			if (i<0 || i>=N) 
				continue;
			for (int j=b-1; j<b+2; j++) {
				if (j<0 || j>=N) 
					continue;
				else
					n++;
			}
		}
		
		detectArr = new int[n];
		int k = 0;
		for (int i=a-1; i<a+2; i++ ) {
			if (i<0 || i>=N) 
				continue;
			for (int j=b-1; j<b+2; j++) {
				if (j<0 || j>=N)
					continue;
				else {
						detectArr[k] = sqArr[i][j];
						k++;
				}
			}
		}
			
		if (!hasIndex(detectArr, 0)) { 
			if(hasIndex(detectArr, 1)) { 
				if(hasIndex(detectArr, 2)) {
					if(hasIndex(detectArr, 3))
						return true;
				}
			}
		}
		return false;		
	}
}

