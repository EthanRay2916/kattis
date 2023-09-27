import java.util.Scanner;
import static java.lang.Integer.parseInt;
public class r2 {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] splitup=input.split(" ");
        int r1 = parseInt(splitup[0]);
        
        int s = parseInt(splitup[1]);
        int r2 = (2*s)-r1;
        System.out.println(r2);
        
    }
    
}