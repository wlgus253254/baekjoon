package num_68852;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class question_2953 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> list = new ArrayList<>();
        for (int i=0; i<5; i++) {
            String[] str = br.readLine().split(" ");
            int sum = 0;
            for (int j=0; j<4; j++) {
                sum += Integer.parseInt(str[j]);
            }
            list.add(sum);
        }

        int max = list.get(0);
        int index = 0;
        for (int i=1; i<list.size(); i++) {
            if (max < list.get(i)) {
                index = i;
                max = list.get(i);
            }
        }

        System.out.println(index+1 + " " + max);
    }
}
