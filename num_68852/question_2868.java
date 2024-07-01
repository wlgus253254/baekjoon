package num_68852;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class question_2868 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int width = Integer.parseInt(st.nextToken());
        int height  = Integer.parseInt(st.nextToken());

        int n = Integer.parseInt(br.readLine());

        List<Integer> list_w = new ArrayList<>();   //가로로 자르는 점선
        List<Integer> list_h = new ArrayList<>();   //세로로 자르는 점선

        //처음 점선 추가하기
        list_w.add(0);
        list_h.add(0);

        //중간에 자르는 점선 추가하기
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int ch = Integer.parseInt(st.nextToken());

            if (ch == 0) {
                //가로로 자르는 점선
                list_w.add(Integer.parseInt(st.nextToken()));
            } else {
                //세로로 자르는 점선
                list_h.add(Integer.parseInt(st.nextToken()));
            }
        }

        //마지막 점선 추가하기
        list_w.add(height);
        list_h.add(width);

        Collections.sort(list_w);
        Collections.sort(list_h);

        //각 점선 간의 간격 중 가장 큰 값 선택
        int max_w = 0;
        for (int i=0; i<list_w.size()-1; i++) {
            int width_check = list_w.get(i+1) - list_w.get(i);
            if (max_w < width_check) max_w = width_check;
        }

        int max_h = 0;
        for (int i=0; i<list_h.size()-1; i++) {
            int height_check = list_h.get(i+1) - list_h.get(i);
            if (max_h < height_check) max_h = height_check;
        }

        System.out.println(max_w * max_h);
    }
}
