package num_7287;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class question_1406 {

	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		//문자열 받아오기
		String str = reader.readLine();

		//가운데 커서를 기준으로 2개의 stack으로 나누기
		Stack<Character> left = new Stack<>();
		Stack<Character> right = new Stack<>();
		
		//입력할 명령어 개수 m 받아오기
		int m = Integer.parseInt(reader.readLine());
		
		for (int i=0; i<str.length(); i++) {
			left.push(str.charAt(i));
		}
		
		
		for (int i=0; i<m; i++) {
			String s = reader.readLine();
			
			switch (s) {
				case "L" :
					if (!left.isEmpty()) {
						right.push(left.pop());
					}
					break;
				case "D" :
					if (!right.isEmpty()) {
						left.push(right.pop());
					}
					break;
				case "B" :
					if (!left.isEmpty()) {
						left.pop();
					}
					break;
				default :
					char ch = s.charAt(2);
					left.push(ch);
					break;
			}
		}
		
		while(!left.isEmpty()) {
			right.push(left.pop());
		}
		
		StringBuffer sb = new StringBuffer();
		while(!right.isEmpty()) {
			sb.append(right.pop());
		}
		
		System.out.println(sb.toString());
	}
}
