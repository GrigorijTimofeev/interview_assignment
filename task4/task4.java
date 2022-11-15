import java.io.*;
import java.util.*;

public class task4 {
    
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("There's should be argument");
            return ;
        }

        File file = new File(args[0]);
        List<Integer> nums = new ArrayList<>();
        double avrg = 0;
        try (Scanner scnr = new Scanner(file)) {
            while (scnr.hasNext()) {
                nums.add(scnr.nextInt());
                avrg += nums.get(nums.size() - 1);
            }
        } catch (FileNotFoundException e){
            System.out.println(e.getMessage());
            return ;
        } catch (Exception e) {
            System.out.println("Invalid file content: " + file.getPath());
            return ;
        }
        
        if (nums.isEmpty()) {
            System.out.println("There's should be at lest one element in the file");
            return ;
        } else if (nums.size() == 1) {
            System.out.println("0");
            return ;
        }
        avrg /= nums.size();
        int index = 0;
        double min = Math.abs(avrg - nums.get(0));
        for (int i = 1; i < nums.size(); i++) {
            double diff = Math.abs(avrg - nums.get(i));
            if (diff < min) {
                min = diff;
                index = i;
            }
        }
        int res = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (i == index) continue;
            res += Math.abs(nums.get(index) - nums.get(i));
        }
        System.out.println(res);
    }
}