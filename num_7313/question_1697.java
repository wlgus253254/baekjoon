package num_7313;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class question_1697 {
    static int n, k;
    static int count = 0;
    static boolean[] visited;
    static void bfs() {
        visited = new boolean[100001];
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(n, 0));

        while(!queue.isEmpty()) {
            Point p = queue.poll();
            int cost = p.cost;

            for (int i=1; i<=3; i++) {
                int nx = move(p.x, i);

                if (nx >= 0 && nx < 100001 && !visited[nx]) {
                    if (nx == k) {
                        //수빈이를 찾음
                        count = cost+1;
                        return;
                    } else {
                        queue.offer(new Point(nx, cost+1));
                        visited[nx] = true;
                    }
                }
            }
        }
    }

    static int move(int x, int num) {
        if (num == 1) {
            x++;
        } else if (num == 2) {
            x--;
        } else if (num == 3) {
            x *= 2;
        }
        return x;
    }

    static class Point {
        int x, cost;

        public Point(int x, int cost) {
            this.x = x;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);     //수빈이가 있는 위치
        k = Integer.parseInt(input[1]);     //동생이 있는 위치

        if (n==k) {
            System.out.println(0);
        }  else {
            bfs();
            System.out.println(count);
        }

        br.close();
    }
}
