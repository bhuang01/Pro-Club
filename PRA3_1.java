import java.util.Scanner;
import java.util.Arrays;

public class PRA3_1 {

    public static int minCost(int k, int[] a, int start, int end) {
        if (end - start + 1 == 1) return 0;
        else if (end - start + 1 == 2) return k;

        int len = 0;
        int cost = -1;
        for (int i = start; i < end; i++) {
            len += a[i];
            if (len < k/2) continue;
            int myCost = k + minCost(len, a, start, i) + minCost(k - len, a,i + 1, end);
            if (cost < 0) cost = myCost;
            else if (cost > myCost) cost = myCost;
        }
        return cost;
    }

    public static void main(String[] argv) {

        Scanner x = new Scanner(System.in);
        int n = x.nextInt();
        // if (n < 1 || n > 1000){
        //     return;
        // }
        int[] energy = new int[n];
        for (int y = 0; y < n; y++) {
            int k = x.nextInt();
            int i = x.nextInt();
            // if (k < i || i < 1 || k < 1 || i > 1000000 || k > 1000000) {
            //     return;
            // }
            int[] a = new int[i];
            for (int j = 0; j < i; j++) {
                a[j] = x.nextInt();
                // if (a[j] < 1 || a[j] > k) {
                //     return;
                // }
            }

            Arrays.sort(a);

            energy[y] = minCost(k, a, 0, i - 1);
        }
        for (int y = 0; y < n; y++){
            System.out.println(energy[y]);
        }
    }
}