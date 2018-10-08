import java.util.HashMap;
import java.util.Map;

class Solution {

  class Node {
    HashMap<Character, Node> children = new HashMap<>();
  }

  public int minimumLengthEncoding(String[] words) {
    
    Node root = new Node();
    for (String word : words) {
      
      Node currentNode = root;
      for (int i = word.length() - 1; i >= 0; i--) {
        
        if (currentNode.children.containsKey(word.charAt(i))) {
          currentNode = currentNode.children.get(word.charAt(i));
        } else {
          Node toAdd = new Node();
          currentNode.children.put(word.charAt(i), toAdd);
          currentNode = toAdd;
        }
      }
    }

    ArrayList<String> minWords = searchTrie(root, ""); 
    int length = 0;
    for (String word : minWords) {
      length += word.length();
    }
    length += minWords.size();
    return length;
  }

  public ArrayList<String> searchTrie(Node node, String currentString) {
    
    if (node.children.size() == 0) {
      ArrayList<String> toReturn = new ArrayList<>();
      toReturn.add(currentString);
      return toReturn;
    }

    ArrayList<String> results = new ArrayList<>();
    for (Map.Entry<Character, Node> child : node.children.entrySet()) {
      
      String childChar = child.getKey().toString();
      String newString = childChar += currentString;
      
      ArrayList<String> childResult = searchTrie(child.getValue(), newString);
      for (String result : childResult) {
        results.add(result);
      } 
    }
    return results;
  }
}