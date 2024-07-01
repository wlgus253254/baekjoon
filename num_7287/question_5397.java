package num_7287;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class question_5397 {

	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		//테스트 케이스 개수 입력받기
		int n = Integer.parseInt(reader.readLine());
		
		for (int i=0; i<n; i++) {
			String s = reader.readLine();
			//왼쪽 스택
			Stack<Character> left = new Stack<>();
			//오른쪽 스택
			Stack<Character> right = new Stack<>();
			
			for (int j=0; j<s.length(); j++) {
				char ch = s.charAt(j);
				
				switch(ch) {
					case '<' :
						if (!left.isEmpty()) {
							right.push(left.pop());
						}
						break;
					case '>' :
						if (!right.isEmpty()) {
							left.push(right.pop());
						}
						break;
					case '-' :
						if (!left.isEmpty()) {
							left.pop();
						}
						break;
					default :
						left.push(ch);
						break;
				}
			}
			
			StringBuilder sb = new StringBuilder();
			
			while (!left.isEmpty()) {
				right.push(left.pop());
			}
			
			while (!right.isEmpty()) {
				sb.append(right.pop());
			}
			
			System.out.println(sb.toString());

		}

	}
}
