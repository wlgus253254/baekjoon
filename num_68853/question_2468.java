package num_68853;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class question_2468 {
    static int n;
    static int[][] arr;
    static boolean[][] visited;
    static Queue<area> queue;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int result = 0;

    static class area {
        int x, y;

        public area(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static void bfs(int x, int y, int h) {
        queue = new LinkedList<>();
        queue.add(new area(x, y));
        visited[x][y] = true;
        while(!queue.isEmpty()) {
            area a = queue.poll();
            for (int i=0; i<4; i++) {
                int nx = a.x + dx[i];
                int ny = a.y + dy[i];

                if (nx >= 0 && ny >= 0  && nx < n && ny < n) {
                    if (!visited[nx][ny] && arr[nx][ny] > h) {
                        visited[nx][ny] = true;
                        queue.add(new area(nx, ny));
                    }
                }

            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());    //2차원 배열의 행과 열의 개수
        arr = new int[n][n];

        int max = 0;
        for (int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j=0; j<n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (max < arr[i][j]) max = arr[i][j];
            }
        }

        for (int i=0; i<=max; i++) {
            visited = new boolean[n][n];
            int count = 0;
            for (int j=0; j<n; j++) {
                for (int k=0; k<n; k++) {
                    if (!visited[j][k] && arr[j][k] > i) {
                        bfs(j, k, i);
                        count++;
                    }
                }
            }
            result = Math.max(count, result);
        }

        System.out.println(result);
    }
}
