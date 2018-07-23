/* 180722 3번 */

import java.util.Scanner;

class prac0722_3 {
	static int T, N, count;
	static int[][] sqArr;
	static int[] detectArr, cmprArr, result;
	
	public static void main(String[] args) {
		
		/* T 입력받는 부분 */
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		result = new int[T]; //나중에 케이스별 솔루션 저장용 배열
		
		
		/* N과 테스트 케이스를 T번 입력받는 부분 */
		for(int iter=0; iter<T; iter++) {
			N = sc.nextInt();
			if (N<1 || N>10) //N은 10 이하의 자연수이다.
				System.exit(0);
			sqArr = new int[N][N]; //sqArr은 지형지도 저장용 배열
			
			for (int i=0; i<sqArr.length; i++) { //iter번째 지도 입력받음
				for (int j=0; j<sqArr[i].length; j++) {
					sqArr[i][j] = sc.nextInt();
				}
			}
						
			/* 도시를 세우기 적합한 장소의 개수를 판별하는 부분 */
			count=0; //count는 iter번째 케이스에서 적합한 장소의 갯수
			for (int k=0; k<sqArr.length;k++) {
				for (int l=0; l<sqArr[k].length; l++) {
					if(detect(k,l)) //조건에서 다 살아남아야만 count++
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
			   return true;//존재한다
		   }
		return false;//존재하지 않는다
	} 
	
	
	
	public static boolean detect(int a, int b) {
		if (sqArr[a][b] == 0) {//조건 1. 본인이 0이면 안된다
			return false;
		}
		
		int n=0; //면적 넘어가지 않는 원소만 센다.
		for (int i=a-1; i<a+2; i++ ) {
			if (i<0 || i>=N) //지도를 벗어난 행이면 다음 행으로
				continue;
			for (int j=b-1; j<b+2; j++) {
				if (j<0 || j>=N) //지도를 벗어난 열이면 다음 열로
					continue;
				else
					n++;
			}
		}
		
		detectArr = new int[n];
		int k = 0;
		for (int i=a-1; i<a+2; i++ ) {
			if (i<0 || i>=N) //지도를 벗어난 행이면 다음 행으로
				continue;
			for (int j=b-1; j<b+2; j++) {
				if (j<0 || j>=N) //지도를 벗어난 열이면 다음 열로
					continue;
				else {
						detectArr[k] = sqArr[i][j];
						k++;
				}
			}
		}
			
		if (!hasIndex(detectArr, 0)) { //조건 2. 주변에 0이 있으면 안된다.
			if(hasIndex(detectArr, 1)) { //조건 3. 1이 하나라도 있어야 한다.
				if(hasIndex(detectArr, 2)) { //조건 4. 2가 하나라도 있어야 한다.
					if(hasIndex(detectArr, 3)) //조건 5. 3이 하나라도 있어야 한다.
						return true;
				}
			}
		}
		return false;		
	}
}

