package num_7287;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class question_10807 {

	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		//정수 개수 받아오기
		int n = Integer.parseInt(reader.readLine());
		
		//n개의 정수 받아오기
		String[] str = reader.readLine().split(" ");
		
		//찾으려고 하는 정수 v 받아오기
		int v = Integer.parseInt(reader.readLine());
		
		//v와 같은 정수의 개수 세기
		int answer = 0;
		for (int i=0; i<n; i++) {
			if (Integer.parseInt(str[i]) == v) answer++;
		}
		
		System.out.println(answer);
	}
}
