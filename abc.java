import java.util.*;

public class abc {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int[] nums = new int[3];
        for (int i = 0; i < 3; i++) {
            nums[i] = scan.nextInt();
        }
        Arrays.sort(nums);
        char[] c = scan.next().toCharArray();
        for (int i = 0; i < 3; i++) {
            System.out.print(nums[c[i] - 'A'] + " ");
        }
    }
}