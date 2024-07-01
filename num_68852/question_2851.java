package num_68852;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class question_2851 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int sum = 0;
        for (int i=0; i<10; i++) {
            int score = Integer.parseInt(br.readLine());
            //현재 점수를 더했을 때 100이면
            if (score+sum == 100) {
                System.out.println(100);
                return;
            }
            //현재 점수를 더했을 때 처음 100이 넘으면
            else if (score+sum > 100) {
                //{현재 점수와 합을 더한 것과 100의 차이} <= {합과 100의 차이}
                if (Math.abs(score+sum-100) <= Math.abs(sum-100)) {
                    System.out.println(score+sum);
                    return;
                }
                //{현재 점수와 합을 더한 것과 100의 차이} > {합과 100의 차이}
                else {
                    System.out.println(sum);
                    return;
                }

            }
            //현재 점수를 더했을 때 100이 넘지 않으면
            else {
                sum += score;   //현재 점수 더하기
            }
        }

        System.out.println(sum);
    }
}
