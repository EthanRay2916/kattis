
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class sortofsorting {

    public static void main(String[] args) {
        ArrayList<String> words = new ArrayList<String>();
        String[] last = new String[200];
        Scanner scanner = new Scanner(System.in);
        boolean inpZero = false;
        String input = "";
        boolean swapped=false;
        String placeholder="";
        while (inpZero == false) {
            int lines = (int) Integer.parseInt(scanner.nextLine());
            if (lines == 0) {
                break;
            }
            System.out.println();
            for (int i = 0; i < lines; i++) {
                input = scanner.nextLine();
                words.add(input);
            }
            for (int x=0;x<words.size()-1;x++){
                swapped=false;
                for (int z=0;z<words.size()-x-1;z++){
                    if (words.get(z).substring(0,2).compareTo(words.get(z+1).substring(0,2))>0){
                        placeholder=words.get(z);
                        words.set(z, words.get(z+1));
                        words.set(z+1,placeholder);
                        swapped=true;
                    }
                }
                if (swapped==false){
                    break;
                }
            }
            for (int m=0;m<words.size();m++){
            System.out.println(words.get(m));
            }
            words.clear();
        }
    }
}
