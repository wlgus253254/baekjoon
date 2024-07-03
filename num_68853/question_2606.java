package num_68853;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class question_2606 {
    static int[][] arr;         //컴퓨터 연결 여부 (1이면 연결)
    static boolean[] check;     //감염 여부 (true면 감염)
    static int count = 0;       //감염된 컴퓨터 수
    static int n, m;

    public static void dfs(int start) {
        check[start] = true;
        count++;

        for (int i=0; i<=n; i++) {
            if (arr[start][i] == 1 && !check[i]) {
                dfs(i);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //컴퓨터의 수
        n = Integer.parseInt(br.readLine());

        //네트워크 상에서 직접 연결되어 있는 컴퓨터의 쌍의 수
        m = Integer.parseInt(br.readLine());

        //연결되어 있는 컴퓨터들의 번호 쌍
        StringTokenizer st;
        arr = new int[n+1][n+1];
        check = new boolean[n+1];
        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            //x번과 y번이 서로 네트워크로 연결되어 있음
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            arr[x][y] = 1;
            arr[y][x] = 1;
        }

        dfs(1);

        System.out.println(count-1);

    }
}
