import java.util.*;

public class digits {
    
    public static void main(String[] args) {
       Scanner in = new Scanner(System.in);
       boolean running=false;
       while (running = true){
           String input = in.nextLine();
           if (input.equals("END")){
               break;
           }
           else if (input.equals("1")){
               System.out.println("1");
           }
           else if (input.length()==1){
           System.out.println("2");
           }
           else if (input.length()>=10){
               System.out.println("4");
           }
           else{
               System.out.println("3");
           }
       }
    }
}
