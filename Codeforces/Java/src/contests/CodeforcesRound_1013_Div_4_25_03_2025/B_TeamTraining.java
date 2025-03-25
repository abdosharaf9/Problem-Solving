package contests.CodeforcesRound_1013_Div_4_25_03_2025;

import java.util.Arrays;
import java.util.Scanner;

public class B_TeamTraining {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t > 0) {
            int n = scanner.nextInt();
            int x = scanner.nextInt();

            int[] skill = new int[n];
            for (int i = 0; i < n; i++) {
                skill[i] = scanner.nextInt();
            }

            Arrays.sort(skill);

            int res = 0;
            int teamSize = 0;
            for (int i = n - 1; i >= 0; i--) {
                teamSize++;
                if (teamSize * skill[i] >= x) {
                    res++;
                    teamSize = 0;
                }
            }

            System.out.println(res);

            t--;
        }
    }
}
