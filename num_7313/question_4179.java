package num_7313;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class question_4179 {
    static int r, c;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int min = 0;
    static Queue<Move> mqueue = new LinkedList<>();
    static Queue<Fire> fqueue = new LinkedList<>();
    static boolean bfs() {
        while(true) {
            min++;
            //fx, fy에서 불 번지기 시작
            int fsize = fqueue.size();
            while (fsize > 0) {
                fsize--;
                Fire f = fqueue.poll();
                for (int i = 0; i < 4; i++) {
                    int nx = f.x + dx[i];
                    int ny = f.y + dy[i];

                    if (nx >= 0 && ny >= 0 && nx < c && ny < r) {
                        if (map[ny][nx] == 1) {
                            //불이 지나갈 수 있는 공간이면
                            map[ny][nx] = 0;
                            fqueue.offer(new Fire(nx, ny));
                        }
                    }
                }
            }

            //jx, jy에서 탈출 시작
            int msize = mqueue.size();
            boolean isMove = false;
            while (msize > 0) {
                msize--;
                Move m = mqueue.poll();
                for (int i = 0; i < 4; i++) {
                    int nx = m.x + dx[i];
                    int ny = m.y + dy[i];

                    if (nx >= 0 && ny >= 0 && nx < c && ny < r) {
                        if (map[ny][nx] == 1 && !visited[ny][nx]) {
                            //지훈이가 지나갈 수 있는 공간이면
                            mqueue.offer(new Move(nx, ny));
                            visited[ny][nx] = true;
                            isMove = true;
                        }
                    } else {
                        //탈출 성공
                        return true;
                    }
                }
            }

            if (!isMove) return false;

        }

    }

    static class Fire {
        int x, y;

        public Fire(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Move {
        int x, y;

        public Move(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");
        r = Integer.parseInt(str[0]);
        c = Integer.parseInt(str[1]);

        //#은 벽 (-1)
        //J은 지훈이의 초기 위치 (1)
        //F는 불의 초기 위치 (0)
        //.은 지나갈 수 있는 공간 (1) -> 지나갈 수 없어지면 0

        //미로 입력받기
        map = new int[r][c];
        visited = new boolean[r][c];
        for (int i=0; i<r; i++) {
            String s = br.readLine();
            for (int j=0; j<c; j++) {
                char ch = s.charAt(j);
                if (ch == '#') {
                    map[i][j] = -1;
                } else if (ch == '.') {
                    map[i][j] = 1;
                } else if (ch == 'J') {
                    map[i][j] = 1;
                    visited[i][j] = true;
                    mqueue.offer(new Move(j, i));
                } else {
                    map[i][j] = 0;
                    fqueue.offer(new Fire(j, i));
                }
            }
        }

        System.out.println(bfs()? min : "IMPOSSIBLE");

    }
}
