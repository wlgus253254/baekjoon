package num_68853;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

public class question_2667 {
    static int n;                                           // 지도의 크기
    static int[][] map;                                     // 지도
    static boolean[][] visited;                             // 방문 여부
    static ArrayList<Integer> list = new ArrayList<>();     // 각 단지에 속하는 집의 수
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int count;
    static void dfs(int x, int y) {
        visited[x][y] = true;
        for (int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                if (!visited[nx][ny] && map[nx][ny] == 1) {
                    count++;
                    dfs(nx, ny);
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());

        // 지도 입력 받기
        map = new int[n][n];
        visited = new boolean[n][n];
        for (int i=0; i<n; i++) {
            String line = br.readLine();
            for (int j=0; j<n; j++) {
                map[i][j] = line.charAt(j) - 48;
            }
        }

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (!visited[i][j] && map[i][j] == 1) {
                    count = 1;
                    dfs(i, j);
                    list.add(count);
                }
            }
        }

        bw.append(String.valueOf(list.size())).append("\n");

        Collections.sort(list);
        for (int n : list) {
            bw.append(String.valueOf(n)).append("\n");
        }

        bw.flush();
    }
}
