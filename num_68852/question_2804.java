package num_68852;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class question_2804 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String a = st.nextToken();  //가로
        String b = st.nextToken();  //세로

        //두 단어의 공통 글자 위치 뽑아내기
        int index_a = 0;
        int index_b = 0;
        boolean isEnd = false;
        for (int i=0; i<a.length(); i++) {
            char char_a = a.charAt(i);
            for (int j=0; j<b.length(); j++) {
                if (char_a ==  b.charAt(j)) {
                    index_a = i;
                    index_b = j;
                    isEnd=true;
                    break;
                }
            }
            if (isEnd) break;
        }

        //출력하기
        System.out.println("index_a : " + index_a + ", index_b : " + index_b);
        StringBuilder first = new StringBuilder();
        first.append(".".repeat(index_a));

        StringBuilder second = new StringBuilder();
        second.append(".".repeat(a.length()-index_a-1));

        for (int i=0; i<index_b; i++) {
            bw.append(first.toString());
            bw.append(b.charAt(i));
            bw.append(second.toString());
            bw.append("\n");
        }

        bw.append(a).append("\n");

        for (int i=index_b+1; i<b.length(); i++) {
            bw.append(first.toString());
            bw.append(b.charAt(i));
            bw.append(second.toString());
            bw.append("\n");
        }

        bw.flush();
    }
}
