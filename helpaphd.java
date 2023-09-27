
import java.util.*;
import java.util.regex.Pattern;

public class helpaphd {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int inputs = (int) Integer.parseInt(scanner.nextLine());
        int count=0;
        while(count<inputs) {
             String[] splitup = scanner.nextLine().split("\\+");
            try{
                System.out.println(Integer.parseInt(splitup[0])+Integer.parseInt(splitup[1]));
            } catch ( NumberFormatException e) {
                if (splitup[0].equals("P=NP")){
                    System.out.println("skipped");
                }
                else{
                System.out.println(splitup[0]);
                
                }
            }
            count++;
        }

    }

}
