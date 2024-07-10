package num_7313;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class question_5014 {
    static int f, s, g, u, d;
    static boolean[] visited;
    static Queue<Move> queue;

    static class Move {
        int floor, cnt;

        public Move(int floor, int cnt) {
            this.floor = floor;
            this.cnt = cnt;
        }
    }

    static String bfs() {
        while(!queue.isEmpty()) {
            Move m = queue.poll();
            int count = m.cnt;

            for (int i=0; i<2; i++) {
                int nf;
                if (i == 0) nf = m.floor + u;
                else nf = m.floor - d;

                if (nf >= 1 && nf <=f) {
                    if (!visited[nf]) {
                        visited[nf] = true;
                        queue.offer(new Move(nf, count + 1));

                        if (nf == g) {
                            return String.valueOf(count + 1);
                        }
                    }
                }
            }
        }

        return "use the stairs";

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        f = Integer.parseInt(input[0]);     //총 f층 건물
        s = Integer.parseInt(input[1]);     //강호가 있는 층
        g = Integer.parseInt(input[2]);     //스타트링크가 있는 층
        u = Integer.parseInt(input[3]);     //위로 u층만큼 가는 버튼
        d = Integer.parseInt(input[4]);     //아래로 d층만큼 가는 버튼

        visited = new boolean[f+1];
        queue = new LinkedList<>();
        queue.offer(new Move(s, 0));

        if (g == s) System.out.println("0");
        else System.out.println(bfs());
    }
}
