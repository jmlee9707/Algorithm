
import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String score = sc.nextLine();
        char[] arr = score.toCharArray();
        double total = 0;
        if (arr[0] == 'A') {
            total = 4.0;
        } else if (arr[0] == 'B') {
            total = 3.0;
        } else if (arr[0] == 'C') {
            total = 2.0;
        } else if (arr[0] == 'D') {
            total = 1.0;
        } else if (arr[0] == 'F') {
            total = 0.0;
        }

        if (total != 0.0) {
            if (arr[1] == '+') {
                total += 0.3;
            } else if (arr[1] == '-') {
                total -= 0.3;
            }
        }

        System.out.println(total);
    }
}
