package num_68852;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class question_2846 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");

        List<Integer> list = new ArrayList<>();
        for (int i=0; i<n; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        int result = 0;
        int start = 0;
        int end = 0;
        boolean isIncrease = false;
        for (int i=0; i<list.size()-1; i++) {
            if (isIncrease) {
                if (list.get(i) < list.get(i+1)) {
                    if (i+1 == n-1) {
                        //마지막에서 오르막길 끝난 경우
                        isIncrease = false;
                        end = i + 1;
                        result = Math.max(result, list.get(end) - list.get(start));
                    }
                } else {
                    //오르막길 끝난 경우
                    isIncrease = false;
                    end = i;
                    result = Math.max(result, list.get(end) - list.get(start));
                }
            } else {
                if (list.get(i) < list.get(i+1)) {
                    //오르막길 시작한 경우
                    isIncrease = true;
                    start = i;
                }
            }
        }

        System.out.println(result);
    }
}
