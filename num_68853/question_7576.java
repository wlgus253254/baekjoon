package num_68853;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class question_7576 {
    static int m, n;
    static int[][] box;
    static Queue<tomato> queue = new LinkedList<>();
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static class tomato {
        int x, y, day;
        public tomato(int x, int y, int day) {
            this.x = x;
            this.y = y;
            this.day = day;
        }
    }

    static void bfs() {
        int day = 0;

        while(!queue.isEmpty()) {
            tomato t = queue.poll();    //익은 토마토 가져오기
            day = t.day;

            for (int i=0; i<4; i++) {
                //상하좌우로 움직이기
                int nx = t.x + dx[i];
                int ny = t.y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    //익지 않은 토마토가 근처에 있으면
                    if (box[nx][ny] == 0) {
                        //토마토가 익도록
                        box[nx][ny] = 1;
                        queue.offer(new tomato(nx, ny, day+1));
                    }
                }
            }
        }

        if (check()) System.out.println(day);
        else System.out.println(-1);

    }

    static boolean check() {
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (box[i][j] == 0) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        m = Integer.parseInt(st.nextToken());   //상자의 가로칸 수
        n = Integer.parseInt(st.nextToken());   //상자의 세로칸 수
        box = new int[n][m];

        //토마토 입력 받기
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j=0; j<m; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
                if (box[i][j] == 1) {
                    //토마토가 익었으면(=1) queue에 삽입
                    queue.offer(new tomato(i, j, 0));
                }
            }
        }

        bfs();

    }
}
