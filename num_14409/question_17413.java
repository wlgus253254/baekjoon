package num_14409;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class question_17413 {

	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String s = reader.readLine();
		
		//조건
		//1. 소문자, 숫자, 공백, 특수문자(< >)로만 이루어짐
		//2. 시작과 끝은 공백이 아님
		//3. 태그 -> <이 >보다 먼저 등장하고 두 문자의 개수는 같음 (길이는 3 이상, 소문자랑 공백만 있음)
		
		//태그가 있을 때
		ArrayList<String> list = new ArrayList<>();
		if (s.contains("<")) {
			//1. list에 태그, 문자열 분리해서 넣기
			boolean start = false;	//tag가 시작되었는지 확인
			String tag = "";		//tag 저장하는 string
			String no_tag = "";		//문자열 저장하는 string
			for (int i=0; i<s.length(); i++) {
				//tag가 시작되었으면(start=true) -> tag에 추가
				if (start) tag += s.charAt(i);
				
				//tag가 아니면 -> no_tag에 추가
				else {
					if (s.charAt(i) != '<' && s.charAt(i) != '>') {
						no_tag += s.charAt(i);
					}
				}	
				
				//tag 시작 '<'
				if (s.charAt(i) == '<') {
					if (!no_tag.isEmpty()) {
						//지금까지 저장되었던 no_tag를 list에 추가하고 초기화
						list.add(no_tag);
						no_tag = "";
					}
					tag += '<';
					start = true;
				}
				
				//tag 끝 '>'
				else if (s.charAt(i) == '>') {
					//지금까지 저장되었던 tag를 list에 추가하고 초기화
					start = false;
					list.add(tag);
					tag = "";
				}
			}
			
			//남아있는 문자열(no_tag) list에 추가하기
			if (!no_tag.isEmpty()) list.add(no_tag);
			
			//2. 출력하기
			for (String str : list) {
				//list 내의 str에 대해서
				
				//태그면 -> 그냥 출력
				if (str.contains("<")) writer.append(str);
				
				//태그가 아닌 문자열이면 -> 뒤집어서 출력
				else {
					//공백 기준으로 단어 분리
					String[] strs = str.split(" ");
					//단어 뒤집기
					int index = 0;
					for (String str_s : strs) {
						for (int i=str_s.length()-1; i>=0; i--) {
							writer.append(str_s.charAt(i));
						}
						
						if (index != strs.length-1) {
							writer.append(' ');
						}
						
						index++;
					}
				}
			}
			
		}
		
		
		//태그가 없을 때
		else {
			//공백 기준으로 단어 분리
			String[] str = s.split(" ");
			//단어 뒤집기
			for (String str_s : str) {
				for (int i=str_s.length()-1; i>=0; i--) {
					writer.append(str_s.charAt(i));
				}
				writer.append(' ');
			}
		}
		
		//결과 출력
		writer.flush();
		
		reader.close();
		writer.close();
		
	}
}
