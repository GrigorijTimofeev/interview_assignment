
public class Task1 {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("There's should be 2 arguments");
            return ;
        }
        int n = 0, m = 0; 
        try {
            n = Integer.parseInt(args[0]);
            m = Integer.parseInt(args[1]);
        } catch (Exception e) {
            System.out.println("Argument should be integer. " + e.getMessage());
            return ;
        }
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