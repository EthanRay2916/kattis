import java.util.Scanner;

public class different {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            long n1 = sc.nextLong();
            long n2 = sc.nextLong();

            long diff = Math.abs(n1 - n2);
            System.out.println(diff);
        }
    }
}