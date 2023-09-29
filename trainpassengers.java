
import java.util.*;

public class trainpassengers {
//n^2 possible choices per thing

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int capacity = scanner.nextInt();
        int trains = scanner.nextInt();
        int inTrain = 0;
        boolean valid = true;
        for (int i = 0; i < trains; i++) {
            int left = scanner.nextInt();
            int enter = scanner.nextInt();
            int station = scanner.nextInt();
            inTrain += enter - left;
            if (i == 0 && left == 1) {
                System.out.println("impossible");
                valid = false;
                break;
            }
            if (i == (trains - 1) && (enter == 1 || station == 1 || inTrain > 0)) {
                System.out.println("impossible");
                valid = false;
                break;
            }

            if (capacity > inTrain && station > 0) {
                System.out.println("impossible");
                valid = false;
                break;
            }
            if (inTrain > capacity) {
                System.out.println("impossible");
                valid = false;
                break;
            }

        }
        if (valid == true) {
            System.out.println("possible");
        }

    }
}
