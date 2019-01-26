import java.util.Scanner;

public class PRB4 {

    public static int eatSlime(int slimes[], int start, int end){
        if (end - start + 1 == 1) return slimes[start];
        if (end - start + 1 == 2){
           return Math.abs(slimes[start] - slimes[end]);
        }
        int maxValue = 0;
        for (int i = start + 1; i <= end; i++){
            int v = 0;
            int x = eatSlime(slimes, start, i-1);
            int y = eatSlime(slimes, i, end);
            if (i == start + 1) {
                v = Math.max(Math.abs(x-y), Math.abs(x+y));
            }
            else if (i == end) {
                v = Math.max(Math.abs(y-x), Math.abs(x+y));
            }
            else v = x + y;
            maxValue = Math.max(maxValue, v);
        }
        return maxValue;
    }

    public static void main(String[] argv){
        Scanner scan = new Scanner(System.in);
        int numYears = scan.nextInt();
        int values[] = new int[numYears];

        for (int i = 0; i < numYears; i++){
            int numSlimes = scan.nextInt();
            int[] slimes = new int[numSlimes];

            for (int j = 0; j < numSlimes; j++){
                slimes[j] = scan.nextInt();
            }
            values[i] = eatSlime(slimes, 0, numSlimes-1);
        }
        for (int i = 0; i < numYears; i++){
            System.out.println(values[i]);
        }
    }
}
