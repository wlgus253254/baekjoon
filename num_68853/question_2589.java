package num_68853;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class question_2589 {
    static int h, w;
    static char[][] map;
    static boolean[][] visited;
    static Queue<node> queue;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static class node {
        int x, y, cost;

        public node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }

    static int bfs(int x, int y) {
        queue = new LinkedList<>();
        queue.offer(new node(x, y, 0));
        visited[y][x] = true;
        int result = 0;

        while(!queue.isEmpty()) {
            node n = queue.poll();
            int c = n.cost;
            for (int i=0; i<4; i++) {
                int nx = n.x + dx[i];
                int ny = n.y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < w && ny < h) {
                    if (!visited[ny][nx] && map[ny][nx] == 'L') {
                        visited[ny][nx] = true;
                        queue.offer(new node(nx, ny, c+1));
                        result = Math.max(result, c+1);
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        h = Integer.parseInt(st.nextToken());   //보물 지도 세로 크기
        w = Integer.parseInt(st.nextToken());   //보물 지도 가로 크기

        map = new char[h][w];

        for (int i=0; i<h; i++) {
            String s = br.readLine();
            for (int j=0; j<w; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        int max = 0;
        for (int i=0; i<h; i++) {
            for (int j=0; j<w; j++) {
                if (map[i][j] == 'L') {
                    //육지인 경우
                    visited = new boolean[h][w];
                    int result = bfs(j, i);
                    max = Math.max(max, result);
                }
            }
        }

        System.out.println(max);
    }
}
