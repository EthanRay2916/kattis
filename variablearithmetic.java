
import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class variablearithmetic {

        public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        Map<String, Integer> assigned = new HashMap<>();
        String varName;
        int varValue;
        boolean end = false;
        
        while (end == false) {
            String input = in.nextLine();
            if (input.equals("0")) {
                end = true;
                break;
            }
            if (input.contains("=") == true) { //assigning a value
                String[] splitup = input.split(" ");
                varName = splitup[0];

                varValue = parseInt(splitup[2]);
                assigned.put(varName, varValue);
            } else {
                int lineTot = 0;
                String[] splitup = input.split(" ");
                ArrayList<String> full = new ArrayList<String>();
                String line = "";
                boolean moreVar = false;
                for (int x = 0; x < splitup.length; x++) {
                    if (assigned.containsKey(splitup[x])) {
                        splitup[x] = Integer.toString(assigned.get(splitup[x]));
                    }
                    try {
                        lineTot = lineTot + Integer.parseInt(splitup[x]);
                    } catch (NumberFormatException e) {
                        full.add(splitup[x]);
                        if (!splitup[x].equals("+")) {
                            moreVar = true;
                        }
                    }
                }
                if (lineTot != 0) {
                    line = line + lineTot;

                    if (moreVar==true) {
                        line += " + ";
                    }

                }
                //line=line+full.get(0);
                for (int o = 0; o != full.size(); o++) {
                    boolean remain = false;
                    //System.out.println(full);
                    if (!full.get(o).contains("+")) {
                        line = line + full.get(o);
                        for (int y=o+1;y != full.size(); y++){
                            if ((!full.get(y).equals("+"))) {
                            remain=true;
                        }
                        }
                        if (remain==true){
                            line+=" + ";
                        }
                        
                    }

                }
                System.out.println(line);
            }

        }

    }
}
