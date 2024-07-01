package num_7307;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class question_10808 {

	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		
		//입력 받아오기
		String s = reader.readLine();
		
		//리스트 초기화 (모든 값을 0으로)
		ArrayList<Integer> list = new ArrayList<>();
		for (int i=0; i<26; i++) {
			list.add(0);
		}
		
		//알파벳 개수 세기 -> list에 설정
		for (int i=0; i<s.length(); i++) {
			int n = Integer.valueOf(s.charAt(i))-97;
			int add_value = list.get(n)+1;
			list.set(n, add_value);
		}
		
		//결과 출력
		for (int i=0; i<26; i++) {
			writer.append(list.get(i) + " ");
		}
		
		writer.flush();
	}
}
