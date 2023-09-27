import java.util.Scanner;

public class aaah {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String a = scanner.next();
        String b = scanner.next();

        System.out.println(a.length() < b.length() ? "no" : "go");
    }
}