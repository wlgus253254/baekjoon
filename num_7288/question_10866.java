package num_7288;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class question_10866 {

	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(reader.readLine());
		
		Deque<Integer> deque = new ArrayDeque<>();
		for (int i=0; i<n; i++) {
			String s = reader.readLine();
			
			if (s.contains("push_front")) {
				String[] str = s.split(" ");
				deque.addFirst(Integer.parseInt(str[1]));
			} else if (s.contains("push_back")) {
				String[] str = s.split(" ");
				deque.addLast(Integer.parseInt(str[1]));
			} else {
				if (s.equals("pop_front")) {
					if (deque.isEmpty()) {
						System.out.println(-1);
					} else {
						System.out.println(deque.removeFirst());
					}
				} else if (s.equals("pop_back")) {
					if (deque.isEmpty()) {
						System.out.println(-1);
					} else {
						System.out.println(deque.removeLast());
					}
				} else if (s.equals("size")) {
					System.out.println(deque.size());
				} else if (s.equals("empty")) {
					if (deque.isEmpty()) {
						System.out.println(1);
					} else {
						System.out.println(0);
					}
				} else if (s.equals("front")) {
					if (deque.isEmpty()) {
						System.out.println(-1);
					} else {
						System.out.println(deque.peekFirst());
					}
				} else if (s.equals("back")) {
					if (deque.isEmpty()) {
						System.out.println(-1);
					} else {
						System.out.println(deque.peekLast());
					}
				}
			}
		}
		
	}
}
