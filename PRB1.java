import java.util.Scanner;

public class PRB1
{
    public static void main(String[] argv)
    {
        int sums[];

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int i;

        sums = new int[n];

        for (i = 0; i < n; i++)
        {
            int a = sc.nextInt();
            int b = sc.nextInt();
            sums[i] = a + b;
        }
        for (i = 0; i < n; i++)
        {
            System.out.println(sums[i]);
        }
    }
}