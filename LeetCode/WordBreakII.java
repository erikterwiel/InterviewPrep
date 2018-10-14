import java.util.HashMap;
import java.util.HashSet;

class Solution {
  public List<String> wordBreak(String s, List<String> wordDict) {
    return solve(s, "", new HashSet<String>(wordDict), new HashMap<String, List<String>>());
  }

  public List<String> solve(String s, HashSet<String> words, HashMap<String, List<String>> stringToSolution) {
    
    System.out.println(s);

    if (stringToSolution.containsKey(s)) {
      System.out.println("got solution from memory for string: " + s);
      return stringToSolution.get(s);
    }

    List<String> solutions = new ArrayList<String>();

    StringBuilder currentSubstring = new StringBuilder();
    for (int i = 0; i < s.length(); i++) {
      
      char letter = s.charAt(i);
      currentSubstring.append(letter);



    
      if (words.contains(currentSubstring.toString())) {
        List<String> subSolutions = solve(s.substring(i + 1, s.length()), words, stringToSolution);
        List<String> newSolutions = new ArrayList<>();
        for (String solution : solutions) {
          for (String subSolutString : )
        }
        solutions = newSolutions;

        if (currentSubstring.toString().equals(s)) {
          solutions.add(currentSubstring);
        }
      }
    }

    stringToSolution.put(s, solutions);

    return solutions;
  }
}