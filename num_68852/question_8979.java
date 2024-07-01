package num_68852;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;

public class question_8979 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());   //국가의 수
        int k = Integer.parseInt(st.nextToken());   //등수를 알고 싶은 국가

        //각 나라의 금, 은, 동메달 수를 입력할 배열
        int[] arr_gold = new int[n+1];
        int[] arr_silver = new int[n+1];
        int[] arr_bronze = new int[n+1];

        //배열의 첫 부분은 0으로 초기화(0번인 국가는 없음)
        arr_gold[0] = 0;
        arr_silver[0] = 0;
        arr_bronze[0] = 0;

        //각 나라의 금, 은, 동메달 수를 입력받아서 배열에 저장하기
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int num = Integer.parseInt(st.nextToken());     //국가 번호

            arr_gold[num] = Integer.parseInt(st.nextToken());
            arr_silver[num] = Integer.parseInt(st.nextToken());
            arr_bronze[num] = Integer.parseInt(st.nextToken());
        }

        //등수를 알고 싶은 국가의 금, 은, 동메달 수
        int k_gold = arr_gold[k];
        int k_silver = arr_silver[k];
        int k_bronze = arr_bronze[k];

        //결과
        int result = 0;

        //자신보다 더 잘한 나라 수 구하기
        for (int i=1; i<=n; i++) {
            if (k_gold == arr_gold[i] && i != k) {
                if (k_silver == arr_silver[i]) {
                    //3. 금, 은메달 수가 모두 같으면, 동메달 수가 더 많은 나라
                    if (k_bronze < arr_bronze[i]) {
                        result++;
                    }
                }
                //2. 금메달 수가 같으면, 은메달 수가 더 많은 나라
                else if (k_silver < arr_silver[i]) {
                    result++;
                }
            }
            //1. 금메달 수가 더 많은 나라
            else if (k_gold < arr_gold[i]) {
                result++;
            }
        }

        //국가 등수 출력하기
        System.out.println(result+1);
    }
}
