package num_68853;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class question_1012 {
    static int m, n, k;
    static int count = 0;   // 필요한 배추흰지렁이 수
    static int[][] map;     // 배추밭 (배추가 심어져 있으면 1, 없으면 0)
    static boolean[][] visited;  //방문했으면 true
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static void dfs(int x, int y) {
        visited[x][y] = true;

        for (int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < m && ny < n) {
                if (!visited[nx][ny] && map[nx][ny] == 1) {
                    dfs(nx, ny);
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //테스트 케이스 개수 T
        int t = Integer.parseInt(br.readLine());

        for (int i=0; i<t; i++) {
            //가로길이 M, 세로길이 N, 배추가 심어져 있는 위치 개수 K
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            map = new int[m][n];
            visited = new boolean[m][n];
            for (int j=0; j<k; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[x][y] = 1;
            }

            for (int x=0; x<m; x++) {
                for (int y=0; y<n; y++) {
                    if (!visited[x][y] && map[x][y] == 1) {
                        dfs(x, y);
                        count++;
                    }
                }
            }

            bw.append(String.valueOf(count)).append("\n");
            count = 0;
        }

        bw.flush();
    }
}
