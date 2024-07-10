package num_7313;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class question_6593 {
    static int l, r, c;
    static char[][][] map;
    static boolean[][][] visited;
    static int[] dx = {0, 0, 1, -1, 0, 0};
    static int[] dy = {1, -1, 0, 0, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};
    static Queue<Move> queue;

    static class Move {
        int x, y, z, cnt;
        public Move(int x, int y, int z, int cnt) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.cnt = cnt;
        }
    }

    static String bfs() {

        while(!queue.isEmpty()) {
            Move m = queue.poll();
            int cnt = m.cnt;

            for (int i=0; i<6; i++) {
                int nx = m.x + dx[i];
                int ny = m.y + dy[i];
                int nz = m.z + dz[i];

                if (nx >= 0 && ny >= 0 && nz >= 0 && nx < c && ny < r && nz < l) {
                    if (!visited[nz][ny][nx]) {
                        if (map[nz][ny][nx] == '.') {
                            queue.offer(new Move(nx, ny, nz, cnt+1));
                            visited[nz][ny][nx] = true;
                        } else if (map[nz][ny][nx] == 'E') {
                            return "Escaped in " + (cnt + 1) + " minute(s).\n";
                        }
                    }
                }
            }
        }

        return "Trapped!\n";
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            l = Integer.parseInt(st.nextToken());   //빌딩의 층 수
            r = Integer.parseInt(st.nextToken());   //한 층의 행 개수
            c = Integer.parseInt(st.nextToken());   //한 층의 열 개수
            if (l == 0 && r == 0 && c == 0) break;

            map = new char[l][r][c];
            visited = new boolean[l][r][c];
            queue = new LinkedList<>();
            for (int i=0; i<l; i++) {
                for (int j=0; j<r; j++) {
                    String s = br.readLine();
                    for (int k=0; k<c; k++) {
                        char ch = s.charAt(k);
                        map[i][j][k] = ch;

                        if (ch == 'S') {
                            visited[i][j][k] = true;
                            queue.offer(new Move(k, j, i, 0));
                        }
                    }
                }
                br.readLine();
            }
            bw.append(bfs());
        }
        bw.flush();
    }
}
