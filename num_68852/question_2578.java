package num_68852;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class question_2578 {
    public static void main(String[] args) throws Exception{
        BufferedReader bw = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        //빙고판 만들기
        //key = 숫자, value = 행열(1행 2열이면 12)
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<5; i++) {
            st = new StringTokenizer(bw.readLine(), " ");
            for (int j=0; j<5; j++) {
                map.put(Integer.parseInt(st.nextToken()), (i+1)*10+(j+1));
            }
        }

        //사회자가 부르는 숫자 가져오기
        //빙고가 되는 경우 -> 최소 13번째 이후부터
        //1. 같은 행/열 다섯개가 지워졌을 때
        //2. 대각선이 지워졌을 때(11, 22, 33, 44, 55 또는 15, 24, 33, 42, 51)

        int[] arr = new int[13]; //1~5번은 행, 6~10번은 열, 11~12번은 대각선
        arr[0] = 0;

        int check = 0;  //3줄이면 빙고

        //1~12번
        for (int i=0; i<5; i++) {
            st = new StringTokenizer(bw.readLine(), " ");
            for (int j=0; j<5; j++) {
                int num = Integer.parseInt(st.nextToken());
                //System.out.println("num = " + num);
                int row = map.get(num)/10;
                int col = map.get(num)%10;

                //System.out.println("row = " + row);
                //System.out.println("col = " + col);

                arr[row]++;
                arr[col + 5]++;
                //System.out.println("행 = " + arr[row]);
                //System.out.println("열 = " + arr[col + 5]);
                if (row == col) {
                    //11, 22, 33, 44, 55 대각선
                    arr[11]++;
                    //System.out.println("대각선 1번 = " + arr[11]);
                    if (arr[11] == 5) check++;
                }
                if (row+col == 6) {
                    //15, 24, 33, 42, 51 대각선
                    arr[12]++;
                    //System.out.println("대각선 2번 = " + arr[12]);
                    if (arr[12] == 5) check++;
                }

                if (arr[row] == 5) check++;
                if (arr[col + 5] == 5) check++;
                //System.out.println(check);
                //System.out.println();
                if (check >= 3) {
                    System.out.println((j+1)+i*5);
                    return;
                }
            }
        }

    }
}
