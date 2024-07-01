package num_68852;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class question_2798 {
    static int search(int[] arr, int n, int m) {
        int sum = 0;

        //n=5, m=21인 경우
        //[5, 6, 7, 8, 9]
        //i=0, j=1, k=2 -> tmp = 5+6+7 = 18 -> sum = 18
        //i=0, j=1, k=3 -> tmp = 5+6+8 = 19 -> sum = 19
        //i=0, j=1, k=4 -> tmp = 5+6+9 = 24 (안됨)
        //i=0, j=2, k=3 -> tmp = 5+7+8 = 20 -> sum = 20
        //i=0, j=2, k=4 -> tmp = 5+7+9 = 24 (안됨)
        //i=0, j=3, k=4 -> tmp = 5+8+9 = 22 (안됨)
        //i=1, j=2, k=3 -> tmp = 6+7+8 = 21 -> sum = 21 (end)

        for (int i=0; i<n-2; i++) {
            for (int j=i+1; j<n-1; j++) {
                for (int k=j+1; k<n; k++) {
                    int tmp = arr[i] + arr[j] + arr[k];

                    if (tmp == m) {
                        return tmp;
                    }

                    if (sum < tmp && tmp < m) {
                        sum = tmp;
                    }
                }
            }
        }

        return sum;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        //카드의 개수 N, 플레이어의 최대 카드 합은 M
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        //카드에 쓰여 있는 수
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        //출력할 합
        int sum = search(arr, n, m);

        System.out.println(sum);

    }
}
