import java.util.Scanner;

class prac0722_3 {
	static int T, N, count;
	static int[][] sqArr;
	static int[] detectArr, cmprArr, result;
	
	public static void main(String[] args) {
		
		/* T �Է¹޴� �κ� */
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		result = new int[T]; //���߿� ���̽��� �ַ�� ����� �迭
		
		
		/* N�� �׽�Ʈ ���̽��� T�� �Է¹޴� �κ� */
		for(int iter=0; iter<T; iter++) {
			N = sc.nextInt();
			if (N<1 || N>10) //N�� 10 ������ �ڿ����̴�.
				System.exit(0);
			sqArr = new int[N][N]; //sqArr�� �������� ����� �迭
			
			for (int i=0; i<sqArr.length; i++) { //iter��° ���� �Է¹���
				for (int j=0; j<sqArr[i].length; j++) {
					sqArr[i][j] = sc.nextInt();
				}
			}
						
			/* ���ø� ����� ������ ����� ������ �Ǻ��ϴ� �κ� */
			count=0; //count�� iter��° ���̽����� ������ ����� ����
			for (int k=0; k<sqArr.length;k++) {
				for (int l=0; l<sqArr[k].length; l++) {
					if(detect(k,l)) //���ǿ��� �� ��Ƴ��ƾ߸� count++
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
			   return true;//�����Ѵ�
		   }
		return false;//�������� �ʴ´�
	} 
	
	
	
	public static boolean detect(int a, int b) {
		if (sqArr[a][b] == 0) {//���� 1. ������ 0�̸� �ȵȴ�
			return false;
		}
		
		int n=0; //���� �Ѿ�� �ʴ� ���Ҹ� ����.
		for (int i=a-1; i<a+2; i++ ) {
			if (i<0 || i>=N) //������ ��� ���̸� ���� ������
				continue;
			for (int j=b-1; j<b+2; j++) {
				if (j<0 || j>=N) //������ ��� ���̸� ���� ����
					continue;
				else
					n++;
			}
		}
		
		detectArr = new int[n];
		int k = 0;
		for (int i=a-1; i<a+2; i++ ) {
			if (i<0 || i>=N) //������ ��� ���̸� ���� ������
				continue;
			for (int j=b-1; j<b+2; j++) {
				if (j<0 || j>=N) //������ ��� ���̸� ���� ����
					continue;
				else {
						detectArr[k] = sqArr[i][j];
						k++;
				}
			}
		}
			
		if (!hasIndex(detectArr, 0)) { //���� 2. �ֺ��� 0�� ������ �ȵȴ�.
			if(hasIndex(detectArr, 1)) { //���� 3. 1�� �ϳ��� �־�� �Ѵ�.
				if(hasIndex(detectArr, 2)) { //���� 4. 2�� �ϳ��� �־�� �Ѵ�.
					if(hasIndex(detectArr, 3)) //���� 5. 3�� �ϳ��� �־�� �Ѵ�.
						return true;
				}
			}
		}
		return false;		
	}
}

