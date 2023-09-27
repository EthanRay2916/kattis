import java.util.*;

public class conversationlog {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Set<String>> usersWords = new HashMap<>(); //persons name + set of words they said

        Map<String, Integer> wordCount = new HashMap<>();

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");
            String name = input[0]; //who's talking
            String[] words = Arrays.copyOfRange(input, 1, input.length); //this is a list of words starting at the index 1 of input[]
            for (String word : words) { //word becomes the element at words[word]
                usersWords.computeIfAbsent(name, k -> new HashSet<>()).add(word); //if absent, add a new item with the person's name and the set of words they said
                wordCount.put(word, wordCount.getOrDefault(word, 0) + 1); //getOrDefault is an interesting piece where if it doesn't get it, it defaults to (word, 0), otherwise the counter adds 1
            }
        }

        Set<String> shared = new HashSet<>(usersWords.values().iterator().next()); //set 'shared' contains the hashset of user words
        for (Set<String> words : usersWords.values()) {
            shared.retainAll(words); //retainAll removes all things that aren't in words
        }

        if (!shared.isEmpty()) { //not empty
            List<String> sortedShared = new ArrayList<>(shared); //sorting by size
            for (int i = 0; i < sortedShared.size(); i++) {
                for (int j = i + 1; j < sortedShared.size(); j++) {
                    String word1 = sortedShared.get(i);
                    String word2 = sortedShared.get(j);

                    int count1 = wordCount.getOrDefault(word1, 0); //default is 0
                    int count2 = wordCount.getOrDefault(word2, 0);

                    if (count2 > count1 || (count1 == count2 && word1.compareTo(word2) > 0)) { //notice compareTo sorts by alphabetical order
                        // Swap the positions of word1 and word2
                        String temp = sortedShared.get(i);
                        sortedShared.set(i, sortedShared.get(j));
                        sortedShared.set(j, temp);
                    }
                }
            }

            for (String word : sortedShared) {
                System.out.println(word);
            }
        } else { //empty
            System.out.println("ALL CLEAR");
        }
    }

    

}
