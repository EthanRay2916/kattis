package KattisExtra;

import java.util.*;

public class recount {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // stores candidate name as String, and stores vote count as Integer in a HashMap
        HashMap<String, Integer> list = new HashMap<>();
        int maxVote = 0;
        String candidate = in.nextLine();
        String leadCandid = "Runoff!";

        // goes through candidate list until *** comes up
        while (!candidate.equals("***")) {
            // inserts candidate name into map and increases vote count for candidate
            if (list.containsKey(candidate)) {
                list.put(candidate, list.get(candidate) + 1);
            }
            // inserts candidate name into list & automatically assigns vote count to 1
            else {
                list.put(candidate, 1);
            }

            // finding lead candidate
            if (list.get(candidate) > maxVote) {
                // assigning highest voted candidate as leadCandid
                leadCandid = candidate;
                maxVote = list.get(candidate);
            } else if (list.get(candidate) == maxVote) {
                // tied vote count == Runoff!
                leadCandid = "Runoff!";
            }
            // next candidate name in list
            candidate = in.nextLine();
        }
        // prints out winner or announces "Runoff!"
        System.out.println(leadCandid);
        in.close();
    } // end of main
} // end of Recount