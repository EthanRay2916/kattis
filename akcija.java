
import java.util.*;

public class akcija {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Integer, Set<Integer>> smallestTotal = new HashMap<>();
        ArrayList<Integer> nums = new ArrayList<Integer>();
        int n = Integer.parseInt(scanner.nextLine());
        int total = 0;
        for (int i = 0; i < n; i++) {
            nums.add(Integer.parseInt(scanner.nextLine()));
        }
        
        Collections.sort(nums);
        Collections.reverse(nums);
        int div3=nums.size()%3;
        for (int x = 0; x < nums.size()-div3; x += 3) {
            total += nums.get(x) + nums.get(x+1);
        }
        int count=nums.size()-div3;
        for (int z=count;z<nums.size();z++){
            total+=nums.get(z);
        }
        System.out.println(total);
    }

}
