import java.util.Scanner;
import java.util.ArrayList;

public class aboveaverage {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int cases = input.nextInt();
        for (int z = 0; z < cases; z++) {
            int s = input.nextInt();
            ArrayList<Integer> students = new ArrayList<>();
            for (int i = 0; i < s; i++) {
                students.add(input.nextInt());
            }
            int total = 0;
            for (int i : students) {
                total += i;
            }
            int better = 0;
            double average = total / (double) s;
            for (int i : students) {
                if (i > average) {
                    better++;
                }
            }
            System.out.printf("%.3f%%\n", 100 * better / (double) s);
        }
    }
}
