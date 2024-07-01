package num_7287;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class question_13300 {

	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		//조건 : 같은 성별, 같은 학년끼리 배정
		
		//n = 참가한 학생 수
		//k = 한 방에 배정할 수 있는 최대 인원 수
		String[] input = reader.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int k = Integer.parseInt(input[1]);
		
		//학생 정보
		//행 : 학년 -> 1~6 
		//열 : 성별 -> 여학생=0, 남학생=1
		int[][] arr = new int[6][2];
		
		for (int i=0; i<n; i++) {
			String[] student = reader.readLine().split(" ");
			int gender = Integer.parseInt(student[0]);
			int grade = Integer.parseInt(student[1]);
			
			arr[grade-1][gender]++;
		}
		
		int answer = 0;
		for (int i=0; i<6; i++) {
			for (int j=0; j<2; j++) {
				//0일때 continue
				//1~k일 때 answer++
				//k보다 클 때 answer+=(int)(arr[i][j]/k)+1
				if (arr[i][j] >= k) {
					answer += arr[i][j]/k;
					if (arr[i][j] % k >= 1) {
						answer++;
					}
					continue;
				}
				
				if (arr[i][j] == 0) {
					continue;
				} else {
					answer++;
				}
				
			}
		}
		
		System.out.println(answer);
	}
}
