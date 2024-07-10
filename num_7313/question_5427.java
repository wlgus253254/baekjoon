package num_7313;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class question_5427 {
    static int w, h;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static Queue<Fire> fqueue;
    static Queue<Move> mqueue;
    static int count;

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

    static boolean bfs() {
        while (true) {
            count++;
            //불 번짐
            int fsize = fqueue.size();
            while (fsize > 0) {
                //System.out.println("불 이동 시작");
                fsize--;
                Fire f = fqueue.poll();
                for (int i = 0; i < 4; i++) {
                    int nx = f.x + dx[i];
                    int ny = f.y + dy[i];

                    if (nx >= 0 && ny >= 0 && nx < w && ny < h) {
                        //불이 사방으로 번짐 -> 주변에 1이 있으면 0으로 바꿈
                        if (map[ny][nx] == 1) {
                            //System.out.println("불 이동 -> x = " + nx + ", y = " + ny);
                            fqueue.offer(new Fire(nx, ny));
                            map[ny][nx] = 0;
                        }
                    }
                }
            }

            //상근이 이동
            int msize = mqueue.size();
            boolean isPossible = false;
            while (msize > 0) {
                //System.out.println("상근이 이동 시작");
                msize--;
                Move m = mqueue.poll();
                for (int i = 0; i < 4; i++) {
                    int nx = m.x + dx[i];
                    int ny = m.y + dy[i];

                    if (nx >= 0 && ny >= 0 && nx < w && ny < h) {
                        if (map[ny][nx] == 1 && !visited[ny][nx]) {
                            //주변에 이동할 곳이 있으면 이동
                           // System.out.println("상근이 이동 -> x = " + nx + ", y = " + ny);
                            mqueue.offer(new Move(nx, ny));
                            visited[ny][nx] = true;
                            isPossible = true;  //하나라도 가능하면 true
                        }
                    } else {
                        //탈출 성공
                        return true;
                    }
                }
            }

            if (!isPossible) return false;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //테스트 케이스
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            //빌딩 지도의 너비와 높이
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            map = new int[h][w];
            visited = new boolean[h][w];
            fqueue = new LinkedList<>();
            mqueue = new LinkedList<>();

            for (int j = 0; j < h; j++) {
                String s = br.readLine();
                for (int k = 0; k < w; k++) {
                    char ch = s.charAt(k);

                    //map에서 빈공간(.) = 1, 벽(#) = -1, 상근이 시작 위치(@) = 1, 불(*) = 0
                    if (ch == '.') {
                        map[j][k] = 1;
                    } else if (ch == '#') {
                        map[j][k] = -1;
                    } else if (ch == '@') {
                        map[j][k] = 1;
                        visited[j][k] = true;
                        mqueue.offer(new Move(k, j));
                    } else {
                        map[j][k] = 0;
                        fqueue.offer(new Fire(k, j));
                    }
                }
            }

            count = 0;
            if (bfs()) System.out.println(count);
            else System.out.println("IMPOSSIBLE");
        }
    }
}