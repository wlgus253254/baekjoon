package num_68853;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.LinkedList;
import java.util.Queue;

public class question_7569 {
    static int m, n, h;
    static int[][][] box;

    //{0, 0, 1}, {0, 0, -1}, {-1, 0, 0}, {1, 0, 0}, {0, -1, 0}, {0, 1, 0}
    static int[] dx = {0, 0, -1, 1, 0, 0};
    static int[] dy = {0, 0, 0, 0, -1, 1};
    static int[] dh = {1, -1, 0, 0, 0, 0};
    static Queue<tomato> queue = new LinkedList<>();

    static class tomato{
        int x, y, h, day;
        public tomato(int x, int y, int h, int day) {
            this.x = x;
            this.y = y;
            this.h = h;
            this.day = day;
        }
    }

    static void bfs() {
        int day = 0;
        while(!queue.isEmpty()) {
            tomato t = queue.poll();
            day = t.day;

            for (int i=0; i<6; i++) {
                int nx = t.x + dx[i];
                int ny = t.y + dy[i];
                int nh = t.h + dh[i];

                if (nx >= 0 && ny >= 0 && nh >= 0
                    && nx < m && ny < n && nh < h) {
                    if (box[nh][ny][nx] == 0) {
                        box[nh][ny][nx] = 1;
                        queue.offer(new tomato(nx, ny, nh, day+1));
                    }
                }
            }
        }

        if (check()) System.out.println(day);
        else System.out.println(-1);
    }

    static boolean check() {
        for (int i=0; i<h; i++) {
            for (int j=0; j<n; j++) {
                for (int k=0; k<m; k++) {
                    if (box[i][j][k] == 0) return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        m = Integer.parseInt(st.nextToken());   //상자의 가로 칸의 수
        n = Integer.parseInt(st.nextToken());   //상자의 세로 칸의 수
        h = Integer.parseInt(st.nextToken());   //쌓아올려지는 상자의 수

        box = new int[h][n][m];

        for (int i=0; i<h; i++) {
            for (int j=0; j<n; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int k=0; k<m; k++) {
                    int d = Integer.parseInt(st.nextToken());
                    box[i][j][k] = d;   //높이 i에 있는 j행 k열 값 저장
                    if (d == 1) {
                        queue.offer(new tomato(k, j, i, 0));
                    }
                }
            }
        }

        bfs();
    }
}
