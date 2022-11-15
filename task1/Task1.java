import java.util.*;

public class Task1 {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        int n = scnr.nextInt();
        int m = scnr.nextInt();
        scnr.close();
        if (n == 1 && m > 0) {
            System.out.println("1");
            return ;
        }
        if (!(m > 1 && n > 1)) {
            System.out.println("Invalid values!");
            return ;
        }
        StringBuilder res = new StringBuilder();
        if (m > n) m %= n;
        int start = 0; //index
        do {
            res.append(start + 1);
            start = (start + m) % n - 1;
            if (start < 0) start = n - 1;
        } while (start != 0);
        System.out.println(res.toString());
    }
}