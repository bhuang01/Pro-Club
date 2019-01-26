import java.util.Scanner;
import java.math.BigInteger;

public class PRA4 {

    public static boolean checkSeg(int A[], int seg) {
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            if (sum > seg) return false;
            else if (sum == seg) sum = 0;
        }
        return true;
    }

    public static boolean checkTicket(BigInteger ticketNum) {
        int seg = 0;
        int sum = 0;
        int length = ticketNum.toString().length();
        char ticketChars[] = ticketNum.toString().toCharArray();
        int ticketDigits[] = new int[length];
        for (int i = 0; i < length; i++){
            ticketDigits[i] = ticketChars[i] - '0';
        }
        for (int i = 0; i < length; i++) {
            sum += ticketDigits[i];
        }
        for (int i = 2; i < length; i++) {
            if (sum % i != 0) continue;
            seg = sum/i;
            if (checkSeg(ticketDigits, seg)) return true;
        }
        return false;
    }

    public static void main(String[] argv){
        Scanner scan = new Scanner(System.in);
        int numTickets = scan.nextInt();
        BigInteger tickets[] = new BigInteger[numTickets];
        int digits[] = new int[numTickets];
        boolean answers[] = new boolean[numTickets];
        int sum = 0;
        for (int i = 0; i < numTickets; i++) {
            digits[i] = scan.nextInt();
            tickets[i] = scan.nextBigInteger();
            answers[i] = checkTicket(tickets[i]);
        }
        for (int i = 0; i < numTickets; i++){
            if (answers[i]){
                System.out.println("YES");
            }
            else System.out.println("NO");
        }
    }
}
