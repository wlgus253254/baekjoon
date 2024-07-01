package num_14409;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class question_1213 {

	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		//임한수의 영어 이름 받아오기
		String s = reader.readLine();
		
		//각 문자들을 저장할 map 생성
		Map<String, Integer> map = new HashMap<>();
		
		for (int i=0; i<s.length(); i++) {
			String ch = String.valueOf(s.charAt(i));
			if (map.containsKey(ch)) {
				int num = map.get(ch);
				map.replace(ch, num+1);
			} else {
				map.put(ch, 1);
			}
		}

		//가능한 종류
		//1. value가 모두 짝수인 경우
		//2. value중 1개만 홀수인 경우 -> 가운데에 집어넣으면 되니까
		String mid = "";		//가운데에 집어넣을 홀수 개의 알파벳 key
		int num = 0;			//2개 이상의 key가 홀수 개의 value를 가진 경우 확인
		
		List<String> keys = new ArrayList<>(map.keySet());
		for (String str : keys) {
			if (map.get(str) % 2 != 0) {
				num++;
				if (num>=2) break;
				mid += str;
			}
		}
		
		//{A=4, B=2, C=1}
		if (num>=2) {
			//2개 이상의 key가 홀수 개의 value를 가진 경우 -> 불가능
			System.out.println("I'm Sorry Hansoo");
		} else {
			Collections.sort(keys);
			Collections.reverse(keys);	//알파벳 역순으로 정렬

			String answer = "";
			
			//홀수 개의 value를 가진 key가 1개 있으면
			if (num == 1) {
				answer += mid;			//제일 가운데에 들어갈 알파벳 1개 넣음
				int m = map.get(mid);
				if (m == 1) {				
					keys.remove(mid);		//value=1인 경우 key에서 제외
				} else {
					map.replace(mid, m-1);	//value=3, 5, ...인 경우 map에서 value--
				}
			}
			
			//뒷자리 먼저 만들기 -> 절반만 answer에 추가
			for (String str : keys) {
				int n = map.get(str);
				for (int i=0; i<n/2; i++) {
					answer += str;
				}
			}
			
			//answer 뒤집어서 reverse 만들기
			String reverse = "";
			if (num == 1) {
				for (int i=answer.length()-1; i>=1; i--) {
					reverse += answer.charAt(i);
				}
			} else {
				for (int i=answer.length()-1; i>=0; i--) {
					reverse += answer.charAt(i);
				}
			}
			
			System.out.println(reverse+answer);
		}
		
		
	}
}
