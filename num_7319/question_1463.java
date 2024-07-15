package num_7319;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class question_1463 {
    static Queue<Result> queue = new LinkedList<>();
    static class Result {
        int num;
        int count;

        public Result(int num, int count) {
            this.num = num;
            this.count = count;
        }
    }
    static void calculate(Result r) {
        if (r.num == 1) return;
        int num = r.num;
        int count = r.count;

        if (num % 3 == 0) queue.add(new Result(num/3, count+1));
        if (num % 2 == 0) queue.add(new Result(num/2, count+1));
        queue.add(new Result(num-1, count+1));
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        queue.add(new Result(n, 0));

        Result r;
        while(true) {
            r = queue.poll();
            if (r.num == 1) break;
            calculate(r);
        }

        System.out.println(r.count);
    }
}
