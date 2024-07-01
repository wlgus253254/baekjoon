package num_7287;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class question_1919 {

	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		//입력 받아오기
		String str1 = reader.readLine();
		String str2 = reader.readLine();
		
		//map 초기화 (key = 알파벳, value = 개수)
		Map<Character, Integer> map = new HashMap<>();
		char alphabet = 'a';
		for (int i=0; i<26; i++) {
			map.put(alphabet, 0);
			alphabet++;
		}
		
		//str1의 각 글자 개수를 map에 추가
		for (int i=0; i<str1.length(); i++) {
			char c = str1.charAt(i);
			int num = map.get(c);
			map.replace(c, num+1);
		}
		
		for (char c='a'; c<='z'; c++) {
			if (map.get(c) == 0) map.remove(c);
		}

		int answer = 0;
		for (int i=0; i<str2.length(); i++) {
			char c = str2.charAt(i);
			//str1에 있으면
			if (map.containsKey(c)) {
				if (map.get(c) == 1) {
					//map에 1개만 남아있으면 제거
					map.remove(c);
				} else {
					//map에 2개 이상 남아있으면 개수 1개 줄이기
					int num = map.get(c);
					map.replace(c, num-1);
				}
			} 
			
			//str1에 없으면 (str1에 없는 str2의 글자들)
			else {
				//제거할 문자이므로 answer++
				answer++;
			}
		}
		
		//남아있는 map의 value들을 모두 answer에 더함 (str2에 없는 str1의 글자들)
		for(char c : map.keySet()) {
			answer += map.get(c);
		}
		
		System.out.println(answer);
		
		
	}
}
