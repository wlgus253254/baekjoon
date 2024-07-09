package num_7313;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class question_7562 {
    static int l;                   //체스판의 한 변의 길이
    static int[][] map;             //체스판
    static boolean[][] visited;   //방문 여부

    //{(-1, 2), (1, 2), (2, 1), (2, -1), (1, -2), (-1, -2), (-2, -1), (-2, 1)}
    static int[] dx = {-1, 1, 2, 2, 1, -1, -2, -2};
    static int[] dy = {2, 2, 1, -1, -2, -2, -1, 1};

    static class Point {
        int x, y, cnt;
        public Point(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }

    static int bfs(int x1, int y1, int x2, int y2) {
        Queue<Point> queue = new LinkedList<>();
        visited[y1][x1] = true;
        queue.offer(new Point(x1, y1, 0));

        int result = 0;
        while(!queue.isEmpty()) {
            Point p = queue.poll();
            int cnt = p.cnt;

            if (p.x == x2 && p.y == y2) {
                result = cnt;
                break;
            }

            for (int i=0; i<8; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < l && ny < l) {
                    if (!visited[ny][nx]) {
                        visited[ny][nx] = true;
                        queue.offer(new Point(nx, ny, cnt+1));
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //테스트 케이스 개수
        int n = Integer.parseInt(br.readLine());

        //체스판 입력받기
        for (int i=0; i<n; i++) {
            l = Integer.parseInt(br.readLine());
            map = new int[l][l];
            visited = new boolean[l][l];

            //나이트가 현재 있는 칸
            StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
            int x1 = Integer.parseInt(st1.nextToken());
            int y1 = Integer.parseInt(st1.nextToken());

            //나이트가 이동하려고 하는 칸
            StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
            int x2 = Integer.parseInt(st2.nextToken());
            int y2 = Integer.parseInt(st2.nextToken());

            if (x1 == x2 && y1 == y2) {
                bw.append("0").append("\n");
            } else {
                bw.append(String.valueOf(bfs(x1, y1, x2, y2))).append("\n");
            }
        }

        bw.flush();

    }
}
