import java.util.*;
import java.io.*;

public class Task2 {
    
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("There's should be 2 arguments");
            return ;
        }

        File file1 = new File(args[0]);
        File file2 = new File(args[1]);
        List<int[]> points = new ArrayList<>();
        int[] center = new int[2];
        int r = 0;

        try (Scanner scnr = new Scanner(file1)){
            center[0] = scnr.nextInt();
            center[1] = scnr.nextInt();
            r = scnr.nextInt();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            return ;
        } catch (Exception e) {
            System.out.println("Invalid file content: " + file1.getPath());
            return ;
        }

        try (Scanner scnr = new Scanner(file2)) {
            while (scnr.hasNext()) {
                points.add(new int[2]);
                int last = points.size() - 1;
                points.get(last)[0] = scnr.nextInt();
                points.get(last)[1] = scnr.nextInt();
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            return ;
        } catch (Exception e) {
            System.out.println("Invalid file content: " + file2.getPath());
            return ;
        }
        
        for (int[] point : points) {
            double len = Math.sqrt(Math.pow(center[0] - point[0], 2) + Math.pow(center[1] - point[1], 2));
            if ((double)r == len) System.out.println(0);
            else if ((double)r > len) System.out.println(1);
            else System.out.println(2);
        }
    }
}
