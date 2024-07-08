package num_68853;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class question_10026 {
    static int n;
    static char[][] map;
    static boolean[][] visited1;
    static boolean[][] visited2;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int count1 = 0;
    static int count2 = 0;
    static void dfs1(int x, int y, boolean check) {
        //check = true면 R 또는 B
        //check = false면 G
        visited1[x][y] = true;  //방문 표시

        for (int i=0; i<4; i++) {
            int nx = x+dx[i];
            int ny = y+dy[i];

            if (nx >= 0 && ny >= 0 && nx < n && ny < n && !visited1[nx][ny]) {
                if (check && (map[nx][ny] == 'R' || map[nx][ny] == 'G')) {
                    dfs1(nx, ny, true);
                }
                else if (!check && map[nx][ny] == 'B') {
                    dfs1(nx, ny, false);
                }
            }
        }
    }

    static void dfs2(int x, int y, char color) {
        visited2[x][y] = true;  //방문 표시

        for (int i=0; i<4; i++) {
            int nx = x+dx[i];
            int ny = y+dy[i];

            if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                if (!visited2[nx][ny] && map[nx][ny] == color) {
                    dfs2(nx, ny, color);
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        map = new char[n][n];
        visited1 = new boolean[n][n];
        visited2 = new boolean[n][n];
        for (int i=0; i<n; i++) {
            String s = br.readLine();
            for (int j=0; j<n; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        //적록색약인 사람
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (!visited1[i][j]) {
                    dfs1(i, j, map[i][j] == 'R' || map[i][j] == 'G');
                    count1++;
                }
            }
        }

        //적록색약이 아닌 사람
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (!visited2[i][j]) {
                    dfs2(i, j, map[i][j]);
                    count2++;
                }
            }
        }

        System.out.println(count2);
        System.out.println(count1);
    }
}
