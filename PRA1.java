import java.util.Scanner;
import java.util.Arrays;

public class PRA1
{
    public static boolean distinct(int k)
    {
        int temp = k;
        int digits[];
        digits = new int[4];
        digits[0] = k%10;
        k = k/10;
        digits[1] = k%10;
        k = k/10;
        digits[2] = k%10;
        k = k/10;
        digits[3] = k%10;

        Arrays.sort(digits);
        int i;
        for (i = 1; i < 4; i++)
        {
            if (digits[i] == digits[i-1])
            {
                //System.out.println(temp + " is not distinct");

                return false;
            }
        }
        //System.out.println(temp + " is distinct");
        return true;
    }
    public static void main(String[] argv)
    {

        int distinctYears[];

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int i;

        distinctYears = new int[n];
        for (i = 0; i < n; i++)
        {
            int k = sc.nextInt();
            k++;
            while (!distinct(k))
            {
                k++;
            }
            distinctYears[i] = k;
        }
        for (i = 0; i < n; i++)
        {
            System.out.println(distinctYears[i]);
        }

    }
}
