package num_68853;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class question_2583 {
    static int m, n, k;
    static int[][] arr;
    static boolean[][] visited;
    static int count;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static void dfs(int x, int y) {
        visited[x][y] = true;

        for (int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                if (!visited[nx][ny] && arr[nx][ny] == 0) {
                    count++;
                    dfs(nx, ny);
                }
            }
        }

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //M, N, K 입력받기
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[n][m];            //m행 n열
        visited = new boolean[n][m];
        for (int i=0; i<k; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for (int x=x1; x<x2; x++) {
                for (int y=y1; y<y2; y++) {
                    arr[x][y] = 1;
                }
            }
        }

        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int x=0; x<n; x++) {
            for (int y=0; y<m; y++) {
                if (!visited[x][y] && arr[x][y] == 0) {
                    count = 1;
                    dfs(x, y);
                    list.add(count);
                }
            }
        }

        Collections.sort(list);

        bw.append(String.valueOf(list.size())).append("\n");

        for (int n : list) {
            bw.append(String.valueOf(n)).append(" ");
        }

        bw.flush();
    }
}
