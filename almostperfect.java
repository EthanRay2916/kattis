import java.util.*;

public class almostperfect {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            int num = scanner.nextInt();
            String result = checkPerfect(num);
            System.out.println(num + " " + result);
        }
    }

    public static String checkPerfect(int num) {
        int sum = 1; // Start with 1 because it is always a proper divisor

        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                sum += i;
                if (i * i != num) {
                    sum += num / i;
                }
            }
        }

        if (sum == num) {
            return "perfect";
        } else if (Math.abs(sum - num) <= 2) {
            return "almost perfect";
        } else {
            return "not perfect";
        }
    }
}