package contests.CodeforcesRound_1013_Div_4_25_03_2025;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class A_OlympiadDate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t > 0) {
            int n = scanner.nextInt();
            HashMap<Integer, Integer> freq = new HashMap<>(Map.of(0, 3, 1, 1, 2, 2, 3, 1, 5, 1));
            boolean flag = true;
            int ans = 0;

            for (int i = 1; i <= n; i++) {
                int x = scanner.nextInt();
                if (freq.containsKey(x)) {
                    freq.put(x, freq.get(x) - 1);
                    if (freq.get(x) == 0) {
                        freq.remove(x);
                    }
                }

                if (freq.isEmpty() && flag) {
                    ans = i;
                    flag = false;
                }
            }

            System.out.println(ans);

            t--;
        }
    }
}
