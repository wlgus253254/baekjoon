package num_7313;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class question_2178 {
    static int n, m;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int bfs() {
        int result = 0;
        Queue<move> queue = new LinkedList<>();
        visited = new boolean[n][m];

        //(0, 0) 삽입 & 방문 처리
        queue.offer(new move(0, 0, 0));
        visited[0][0] = true;
        int cost = 0;

        while(!queue.isEmpty()) {
            move move = queue.poll();
            cost = move.cost;
            for (int i=0; i<4; i++) {
                int nx = move.x + dx[i];
                int ny = move.y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < m && ny < n) {
                    if (!visited[ny][nx] && map[ny][nx] == 1) {
                        queue.offer(new move(nx, ny, cost+1));
                        visited[ny][nx] = true;
                        if (nx == m-1 && ny == n-1) {
                            result = cost+1;
                            break;
                        }
                    }
                }
            }
        }

        return result+1;
    }

    static class move {
        int x, y;
        int cost;

        public move(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());   //세로
        m = Integer.parseInt(st.nextToken());   //가로

        map = new int[n][m];
        for (int i=0; i<n; i++) {
            String s = br.readLine();
            for (int j=0; j<m; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        System.out.println(bfs());
    }
}
