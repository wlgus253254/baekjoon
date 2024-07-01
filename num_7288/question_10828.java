package num_7288;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class question_10828 {

	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.valueOf(reader.readLine());
		
		Stack<Integer> stack = new Stack<>();
		for (int i=0; i<n; i++) {
			String s = reader.readLine();
			if (s.contains("push")) {
				String[] str = s.split(" ");
				stack.push(Integer.parseInt(str[1]));
			} else {
				if (s.equals("pop")) {
					if (stack.isEmpty()) {
						//비어있으면 -1 출력
						System.out.println(-1);
					} else {
						//비어있지 않으면 해당 숫자 출력
						System.out.println(stack.pop());
					}
				} else if (s.equals("size")) {
					System.out.println(stack.size());
				} else if (s.equals("empty")) {
					if (stack.isEmpty()) {
						System.out.println(1);
					} else {
						System.out.println(0);
					}
				} else if (s.equals("top")) {
					if (stack.isEmpty()) {
						System.out.println(-1);
					} else {
						System.out.println(stack.peek());
					}
				}
			}
		}
	}
}
