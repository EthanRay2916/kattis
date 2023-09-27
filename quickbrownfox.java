import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class quickbrownfox {

    public static void main(String[] args) {
        ArrayList<String> words = new ArrayList<String>();
        Scanner scanner = new Scanner(System.in);
        String input = "";

        int tries=Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < tries; i++) {
            char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
            ArrayList<Character> alph = new ArrayList<Character>();
            for (int z=0;z<alphabet.length;z++){
                alph.add(alphabet[z]);
            }
            input = scanner.nextLine();
            char[] inps = input.toCharArray();
            ArrayList<Character> compar = new ArrayList<Character>();
            for (int x=0;x<inps.length;x++){
                compar.add(Character.toLowerCase(inps[x])); // Convert to lower case for case insensitivity
            }
            alph.removeAll(compar); // Remove all characters that occur in the input
            if (alph.isEmpty()) {
                System.out.println("pangram");
            } else {
                Collections.sort(alph); // Sort the missing characters alphabetically
                System.out.print("missing ");
                for (char missing : alph) {
                    System.out.print(missing);
                }
                System.out.println();
            }
        }
    }
}