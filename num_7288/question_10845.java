package num_7288;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class question_10845 {

	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.valueOf(reader.readLine());
		
		Queue<Integer> queue = new LinkedList<>();
		for (int i=0; i<n; i++) {
			String s = reader.readLine();
			
			if (s.contains("push")) {
				String[] str = s.split(" ");
				queue.add(Integer.valueOf(str[1]));
			} else {
				if (s.contains("pop")) {
					if (queue.isEmpty()) {
						System.out.println(-1);
					} else {
						System.out.println(queue.remove());
					}
				} else if (s.contains("size")) {
					System.out.println(queue.size());
				} else if (s.contains("empty")) {
					if (queue.isEmpty()) {
						System.out.println(1);
					} else {
						System.out.println(0);
					}
				} else if (s.contains("front")) {
					if (queue.isEmpty()) {
						System.out.println(-1);
					} else {
						System.out.println(queue.peek());
					}
				} else if (s.contains("back")) {
					if (queue.isEmpty()) {
						System.out.println(-1);
					} else {
						System.out.println(((LinkedList<Integer>) queue).getLast());
					}
				}
			}
		}
	}
}
