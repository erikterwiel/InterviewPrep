import java.util.HashMap;
import java.util.TreeSet;

class Solution {
  public List<String> topKFrequent(String[] words, int k) {
    
    HashMap<String, Integer> wordToCount = new HashMap<>();
    for (String word : words) {
      wordToCount.put(word, wordToCount.getOrDefault(word, 0) + 1);
    }
    
    ArrayList<TreeSet<String>> countToWords = new ArrayList<>();
    for (int i = 0; i < words.length + 1; i++) {
      countToWords.add(new TreeSet<>((String a, String b) -> a.compareTo(b)));
    }
    for (Map.Entry<String, Integer> entry : wordToCount.entrySet()) {
      countToWords.get(entry.getValue()).add(entry.getKey());
    }
    
    List<String> mostFrequent = new ArrayList<String>();
    for (int i = countToWords.size() - 1; i > 0; i--) {
      Iterator<String> sortedWords = countToWords.get(i).iterator();
      while (sortedWords.hasNext() && k > 0) {
        mostFrequent.add(sortedWords.next());
        k--;    
      }
      if (k == 0) {
        break;
      }
    }
    return mostFrequent;
  }
}