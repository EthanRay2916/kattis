import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class cats {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCases = Integer.parseInt(br.readLine().trim()); //total test cases
        for (int t = 0; t < testCases; t++) {
            // Read the amount of milk and the number of cats for each test case
            String[] caseInfo = br.readLine().split(" ");
            int milkAmount = Integer.parseInt(caseInfo[0]);
            int numOfCats = Integer.parseInt(caseInfo[1]);

            // matrix for storing cat distances
            int[][] catDistances = new int[numOfCats][numOfCats];

            // Read the distances between pairs of cats
            readCatDistances(numOfCats, catDistances, br);

            // Check if it's possible to serve milk to all cats
            if (canServeMilk(milkAmount, numOfCats, catDistances)) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }

    // Helper method to read distances between pairs of cats
    private static void readCatDistances(int numOfCats, int[][] catDistances, BufferedReader br) throws IOException {
        for (int i = 0; i < (numOfCats * (numOfCats - 1)) / 2; i++) {
            String[] distanceInfo = br.readLine().split(" ");
            int cat1 = Integer.parseInt(distanceInfo[0]);
            int cat2 = Integer.parseInt(distanceInfo[1]);
            int distance = Integer.parseInt(distanceInfo[2]);
            catDistances[cat1][cat2] = distance;
            catDistances[cat2][cat1] = distance;
        }
    }

    // Helper method to check if it's possible to serve milk to all cats
    private static boolean canServeMilk(int milkAmount, int numOfCats, int[][] catDistances) {
        int[] bestDistances = new int[numOfCats];
        Set<Integer> remainingCats = new HashSet<>();
        for (int i = 1; i < numOfCats; i++) {
            remainingCats.add(i);
        }

        boolean[] visitedCats = new boolean[numOfCats];
        PriorityQueue<int[]> distanceHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        int servedCats = 0;
        int totalDistance = 0;

        // Initialize the priority queue with distances from the first cat to other cats
        for (int i = 1; i < numOfCats; i++) {
            distanceHeap.add(new int[]{catDistances[0][i], i});
            bestDistances[i] = catDistances[0][i];
        }

        // Continue until all cats are served
        while (servedCats < numOfCats - 1) {
            int[] currentDistance;
            while (true) {
                // Get the minimum distance from the priority queue
                currentDistance = distanceHeap.poll();
                int distance = currentDistance[0];
                int catIndex = currentDistance[1];
                if (visitedCats[catIndex]) {
                    // Skip if the cat has already been visited
                    continue;
                }
                break;
            }

            servedCats++;
            totalDistance += currentDistance[0];

            // Check if the total distance plus the number of cats exceeds the available milk
            if (totalDistance + numOfCats > milkAmount) {
                return false;
            }

            visitedCats[currentDistance[1]] = true;
            remainingCats.remove(currentDistance[1]);

            // Update the priority queue with new best distances
            for (int otherCat : remainingCats) {
                if (catDistances[currentDistance[1]][otherCat] < bestDistances[otherCat]) {
                    bestDistances[otherCat] = catDistances[currentDistance[1]][otherCat];
                    distanceHeap.add(new int[]{catDistances[currentDistance[1]][otherCat], otherCat});
                }
            }
        }

        // Check if the total distance plus the number of cats is within the available milk
        return numOfCats + totalDistance <= milkAmount;
    }
}
