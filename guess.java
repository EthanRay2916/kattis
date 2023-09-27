
import java.util.*;

public class guess {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String response = "";
        int guess = 500;
        int min = 1;
        int max = 1000;
        System.out.println(guess);
        //response = scanner.nextLine();

        for (int i = 1; i <= 10; i++) {
            response = scanner.nextLine();
            switch (response) {
                case "higher":
                    min = guess+1;
                    guess = (max+min)/2;
                    System.out.println(guess);

                    break;
                case "lower":
                    max = guess;
                    guess = (max+min)/2;
                    System.out.println(guess);
                    //response = scanner.nextLine();
                    break;
                default:
                    System.exit(0);
            }
        }
    }

}
