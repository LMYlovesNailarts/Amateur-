/* 180722 */

import java.util.Scanner;

public class prac0722 {
	
	static int N, S, J, K, T;
	   static int[] restPg, goingPg;
	   static int[] result;
	   static int count;
	   public static void main(String args[]) {
	      
	      /* �Է¹޴� �κ� */
	      Scanner sc = new Scanner(System.in);
	      T = sc.nextInt();
	      result = new int[T];
	      for(int iter=0; iter<T; iter++) { //�׽�Ʈ ���̽� T��ŭ �Է¹���
	    	  N = sc.nextInt();      S = sc.nextInt();
	          J = sc.nextInt();      K = sc.nextInt();
	          if (N<10 || N>10000 || J<0 || J>10000 
	        		  || S<1 || S>N || K<1 || K>1000) {
	             System.out.println("(1) N�� 10 �̻�, 10000 �̸��� ���� �����մϴ�.\n"
	                   + "(2) S�� 1 �̻� N ������ ���� �����մϴ�.\n"
	                   + "(3) J�� 0 �̻� 10000 ������ ���� �����մϴ�.\n"
	                   + "(4) K�� 1 �̻� 1000 ������ ���� �����մϴ�.\n"
	                   + "(5) �� ���� �� �ϳ� �̻��� ���ǿ� ��߳��� �Է��߽��ϴ�.\n �ý����� �����մϴ�.\n");
	             System.exit(0);
	          }
	          
	          restPg = new int[K];
	          for(int i=0; i<K; i++) { //����� ������ ��������� �Է¹���
	        	  restPg[i] = sc.nextInt();
	          }
	          
	          int len = (N-S)/(J+1) + 1; //���ϴ� �������� ����
	          goingPg = new int[len];
	          for(int i=0; i<len && S<=N; i++) { //���İ��� ��� ������ ��������� �Է¹���
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
