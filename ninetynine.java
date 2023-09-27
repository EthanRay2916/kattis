
import java.util.Scanner;

public class ninetynine {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = 1;
        System.out.println(count);
        count = (int) (Integer.parseInt(scanner.nextLine()));
        while ((count + 1)%3 != 0) {
            count +=  (Math.random() <= 0.5) ? 1 : 2;
            System.out.println(count);
            count = (int) (Integer.parseInt(scanner.nextLine()));
        }
        while (count <=96) {
            if ((count + 1) % 3 == 0) {
                count+=1;
                System.out.println(count);
                count = (int) (Integer.parseInt(scanner.nextLine()));
            } else {
                count += 2;
                System.out.println(count);
                count = (int) (Integer.parseInt(scanner.nextLine()));
            }
        }
        System.out.println("99");
    }

}
