package num_7313;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class question_2206 {
    static int n, m;
    static int[][] map;
    static boolean[][][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static void bfs() {
        Queue<Move> queue = new LinkedList<>();
        queue.offer(new Move(0, 0, 1, false));
        visited[0][0][0] = true;

        while (!queue.isEmpty()) {
            Move move = queue.poll();
            int cnt = move.cnt;

            if (move.x == m - 1 && move.y == n - 1) {
                System.out.println(cnt);
                return;
            }

            for (int i=0; i<4; i++) {
                int nx = move.x + dx[i];
                int ny = move.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= m || ny >= n) {
                    continue;
                }

                if (move.isBreak) {
                    //벽을 부순 적이 있을 때
                    if (map[ny][nx] == 0 && !visited[ny][nx][1]) {
                        visited[ny][nx][1] = true;
                        queue.offer(new Move(nx, ny, cnt+1, true));
                    }
                } else {
                    //벽을 부순 적이 없을 때
                    if (map[ny][nx] == 1) {
                        //벽일 때
                        visited[ny][nx][1] = true;
                        queue.offer(new Move(nx, ny, cnt+1, true));
                    } else if (!visited[ny][nx][0]){
                        //벽이 아니고 방문하지 않았을 때
                        visited[ny][nx][0] = true;
                        queue.offer(new Move(nx, ny, cnt+1, false));
                    }
                }
            }
        }

        System.out.println(-1);  //불가능한 경우

    }

    static class Move {
        int x, y, cnt;
        boolean isBreak;
        public Move(int x, int y, int cnt, boolean isBreak) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.isBreak = isBreak;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        n = Integer.parseInt(input[0]); //행(y)
        m = Integer.parseInt(input[1]); //열(x)

        if (n == 1 && m == 1) System.out.println(1);
        else {
            map = new int[n][m];
            visited = new boolean[n][m][2];
            for (int i=0; i<n; i++) {
                String s = br.readLine();
                for (int j=0; j<m; j++) {
                    //0 = 이동할 수 있는 곳
                    //1 = 벽이 있는 곳
                    map[i][j] = s.charAt(j) - '0';
                }
            }
            bfs();
        }

    }
}
