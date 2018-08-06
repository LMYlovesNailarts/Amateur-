/* 180722 */

import java.util.Scanner;

public class prac0722 {
	
	static int N, S, J, K, T;
	   static int[] restPg, goingPg;
	   static int[] result;
	   static int count;
	   public static void main(String args[]) {
	      
	      /* 입력받는 부분 */
	      Scanner sc = new Scanner(System.in);
	      T = sc.nextInt();
	      result = new int[T];
	      for(int iter=0; iter<T; iter++) { //테스트 케이스 T만큼 입력받음
	    	  N = sc.nextInt();      S = sc.nextInt();
	          J = sc.nextInt();      K = sc.nextInt();
	                
	          restPg = new int[K];
	          for(int i=0; i<K; i++) { //쉬어가는 페이지 어디어디인지 입력받음
	        	  restPg[i] = sc.nextInt();
	          }
	          
	          int len = (N-S)/(J+1) + 1; //접하는 페이지의 갯수
	          goingPg = new int[len];
	          for(int i=0; i<len && S<=N; i++) { //거쳐가는 모든 페이지 어디어디인지 입력받음
	        	  goingPg[i] = S;
	        	  S = S + (J+1);
	          }
	          
	          count = 0;
	          for (int i=0; i<K; i++) {
	        	  for (int j=0; j<len; j++) {
	        		  if (goingPg[j] == restPg[i])
	        			  count++;
	        	  }  
	          }
	          result[iter] = count;
	      }
	      sc.close();
	      result();
	   }

	   public static void result() {
	      for(int i=0; i<T; i++)
	         System.out.println("#"+(i+1)+" "+result[i]);
	   }

}
