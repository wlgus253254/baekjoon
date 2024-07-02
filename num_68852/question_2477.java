package num_68852;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class question_2477 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));

        //1제곱미터 넓이에서 자라는 참외의 개수
        int k = Integer.parseInt(br.readLine());

        //변의 방향과 길이 (동-1, 서-2, 남-3, 북-4) -> 동, 북은 + / 서, 남은 -
        //큰 직사각형 크기 - 작은 직사각형 크기
        List<Integer> list = new ArrayList<>();    //길이 저장
        StringTokenizer st;
        for (int i=0; i<6; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int direction = Integer.parseInt(st.nextToken());
            int length = Integer.parseInt(st.nextToken());
            list.add(length);
        }

        //제일 큰 직사각형 가로, 세로 구하기
        int max1 = list.get(0);
        int max2 = list.get(1);
        for (int i=2; i<6; i++) {
            if (i%2 == 0) {
                //30, 20
                if (list.get(i) > max1) max1 = list.get(i);
            } else {
                //60, 100
                if (list.get(i) > max2) max2 = list.get(i);
            }
        }

        //max1 or max2를 list의 첫번째 값으로 만들기
        do {
            list.add(list.remove(0));
        } while ((list.get(0) != max1 || list.get(1) != max2)
                && (list.get(0) != max2 || list.get(1) != max1));


        //최종 넓이 구하기
        int max = max1 * max2;
        int min = list.get(3) * list.get(4);

        System.out.println(k * (max - min));
    }
}
