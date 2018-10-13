import java.util.ArrayList;
import java.util.HashMap;

class Solution {
  public String frequencySort(String s) {

    HashMap<Character, Integer> occurences =  new HashMap<>();
    for (char letter : s.toCharArray()) {
      if (!occurences.containsKey(letter)) {
        occurences.put(letter, 1); 
      } else {
        occurences.put(letter, occurences.get(letter) + 1);
      }
    }

    ArrayList<ArrayList<Character>> occurencesToCharacters = new ArrayList<>();
    for (int i = 0; i < s.length() + 1; i++) {
      occurencesToCharacters.add(new ArrayList<Character>());
    }

    for (Map.Entry<Character, Integer> entry : occurences.entrySet()) {      
      occurencesToCharacters.get(entry.getValue()).add(entry.getKey());
    }

    StringBuilder sBuilder = new StringBuilder();
    for (int i = occurencesToCharacters.size() - 1; i > 0; i--) {
      for (char letter : occurencesToCharacters.get(i)) {
        for (int j = 0; j < i; j++) {
          sBuilder.append(letter);
        }
      }
    }
    
    return sBuilder.toString();
  }
}