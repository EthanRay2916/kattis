import java.util.Scanner;

public class twostones {



    public static void main(String[] args) {
    
         Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        if (N%2==0){
            System.out.println("Bob");
        }
        else {
            System.out.println("Alice");
        }
        
    }
    
}