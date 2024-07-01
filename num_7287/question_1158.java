package num_7287;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class question_1158 {

	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] input = reader.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int k = Integer.parseInt(input[1]);
		
		ArrayList<Integer> list = new ArrayList<>();
		
		for (int i=1; i<=n; i++) {
			list.add(i);
		}
		
		// 1 2 3 4 5 6 7
		// index=2, 1 2 4 5 6 7 -> 3 출력, n=6
		// index=4, 
		int index = 0;
		int len = n;
		ArrayList<Integer> answer = new ArrayList<>();
		writer.append("<");
		for (int i=0; i<len-1; i++) {
			index += (k-1);
			//index = 6, n = 7(0~6번), k = 3인 경우
			//6 + 3 = 9
			//9 - 7 = 2
			if (index >= n) {
				while(true) {
					if (index-n >= 0) {
						index -= n;
					} else {
						break;
					}
				}
			}
			writer.append(String.valueOf(list.get(index)) + ", ");
			answer.add(list.get(index));
			list.remove(index);
			n--;
		}
		
		writer.append(String.valueOf(list.get(0)) + ">");
		writer.flush();
	}
}
