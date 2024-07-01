package num_7288;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class question_9012 {

	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.valueOf(reader.readLine());
		
		for (int i=0; i<n; i++) {
			Stack<Character> stack = new Stack<>();
			String s = reader.readLine();
			boolean check = true;
			for (int j=0; j<s.length(); j++) {
				char c = s.charAt(j);
				if (c == '(') {
					stack.add(c);
				} else {
					if (stack.isEmpty()) {
						check = false;
						break;
					} else {
						stack.pop();
					}
				}
			}
			
			if (check && stack.isEmpty()) writer.append("YES\n");
			else writer.append("NO\n");
			
		}
		
		writer.flush();
	}
}
