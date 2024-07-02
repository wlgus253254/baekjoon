package num_68852;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.StringTokenizer;

public class question_1244 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        //스위치 개수
        int n = Integer.parseInt(br.readLine());

        //스위치 상태
        st = new StringTokenizer(br.readLine(), " ");
        List<Integer> list = new ArrayList<>();
        list.add(-1);   //0번째 스위치 초기화
        for (int i=0; i<n; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        //학생 수
        int student = Integer.parseInt(br.readLine());

        //학생이 받은 수
        for (int i=0; i<student; i++) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            if (gender == 1) {
                //남학생 -> 자기가 받은 수의 배수인 스위치 상태 바꾸기
                for (int j=num; j<=n; j+=num) {
                    list.set(j, 1-list.get(j));
                }
            } else {
                //여학생 -> 자기가 받은 수 중심으로 좌우 대칭인 스위치 상태 바꾸기 (최대로)
                int range = 1;
                list.set(num, 1-list.get(num));
                while(true) {
                    if (num-range >= 1 && num+range <= n) {
                        if (Objects.equals(list.get(num - range), list.get(num + range))) {
                            list.set(num-range, 1-list.get(num-range));
                            list.set(num+range, 1-list.get(num+range));
                            range++;
                        } else {
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
        }

        //결과 출력
        for (int i=1; i<=n; i++) {
            System.out.print(list.get(i) + " ");
            if (i % 20 == 0) {
                System.out.println();
            }
        }
    }
}
