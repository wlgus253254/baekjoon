package num_7288;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;

public class question_5430 {

	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		
		//테스트 케이스 개수 T
		int t = Integer.valueOf(reader.readLine());
		
		//R=뒤집기 -> 배열에 있는 수의 순서를 뒤집음
		//D=버리기 -> 첫번째 수를 버림 (비어있는 배열에서 D 실행 시 에러)
		
		for (int i=0; i<t; i++) {
			//수행할 함수 P
			String p = reader.readLine();
			
			//배열에 들어있는 수의 개수 n
			int n = Integer.valueOf(reader.readLine());
			
			//배열에 들어있는 정수 [x1, x2, ..., xn] 형태 입력받기
			String str = reader.readLine();
			Deque<String> deque = new LinkedList<>();
			
			//배열에 들어있는 수의 개수 n에 따라 분류 -> 입력받은 후 deque에 넣기
			if (n == 0) { 
				
			} else if (n == 1) {
				int len = str.length();
				//[42]인 경우 -> 1번쨰부터 len-2번째까지
				str = str.substring(1, len-1);
				deque.add(str);
			} else {
				str = str.substring(1, str.length()-1);	//str = "1, 2, 3, 4"
				String[] arr = str.split(",");			//arr = [1, 2, 3, 4]
				
				for (int j=0; j<arr.length; j++) {
					deque.add(arr[j]);
				}
			}
			
			boolean error = false;			//error 체크하기
			int r_num = 0;					//r이 나온 개수
			boolean front = true;			//true면 front, falsed면 back
			
			//함수 P 수행하기
			for (int j=0; j<p.length(); j++) {
				char c = p.charAt(j);

				//D -> 첫번째 수를 버리는 함수
				if (c == 'D') {
					if (deque.isEmpty()) {
						//deque가 비어있고, D를 입력받은 경우 -> error를 true로 변경
						error = true;
						break;
					} else {
						if (front) {
							//front=true면 앞에서 제거
							deque.pollFirst();
						} else {
							//front=false면 뒤에서 제거
							deque.pollLast();
						}
					}
				} 
				
				//R -> 배열에 있는 수의 순서를 뒤집는 함수
				else {
					r_num++;
					front = !front;	//true면 false로, false면 true로 변경
				}
			}
			
			if (error) {
				//error 출력
				writer.append("error\n");
			} else {
				int len = deque.size();
				if (r_num % 2 == 0) {
					//r 개수가 짝수개면 -> 뒤집지 않고 출력
					writer.append("[");
					for (int j=0; j<len; j++) {
						String s = deque.pollFirst();
						writer.append(s);
						if (!deque.isEmpty()) {
							writer.append(",");
						}
					}
					writer.append("]\n");	
				} else {
					//r 개수가 홀수개면 -> 뒤집고 출력
					writer.append("[");
					for (int j=0; j<len; j++) {
						String s = deque.pollLast();
						writer.append(s);
						if (!deque.isEmpty()) {
							writer.append(",");
						}
					}
					writer.append("]\n");	
				}
			}

		}
		
		writer.flush();
	}
}
