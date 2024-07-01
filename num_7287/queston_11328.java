package num_7287;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class queston_11328 {

	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		
		//테스트 케이스의 수 입력받기
		int n = Integer.parseInt(reader.readLine());
		
		//각 테스트 케이스 입력받기
		for (int i=0; i<n; i++) {
			String[] str = reader.readLine().split(" ");
			
			ArrayList<String> list1 = new ArrayList<>();
			ArrayList<String> list2 = new ArrayList<>();
			
			int len1 = str[0].length();
			int len2 = str[1].length();
			
			if (len1 == len2) {
				for (int j=0; j<len1; j++) {
					list1.add(String.valueOf(str[0].charAt(j)));
					list2.add(String.valueOf(str[1].charAt(j)));
				}
				
				Collections.sort(list1);
				Collections.sort(list2);
				
				if (list1.equals(list2)) writer.append("Possible\n");
				else writer.append("Impossible\n");
				
			} else {
				writer.append("Impossible\n");
			}
		}
		
		writer.flush();
	}
}
