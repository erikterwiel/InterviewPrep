import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class LongestSubstring {

  class SubstringIndeces {
    int mStartIndex;
    int mEndIndex;

    public SubstringIndeces(int startIndex) {
      mStartIndex = startIndex;
      mEndIndex = -1;
    }

    public void setEndIndex(int endIndex) {
      mEndIndex = endIndex;
    }

    public int getStartIndex() {
      return mStartIndex;
    }
 
    public int getEndIndex() {
      return mEndIndex;
    } 
  }

  public static void main(String[] args) {
    System.out.println(new LongestSubstring().lengthOfLongestSubstring("abcabcbb"));
  }
  
  public int lengthOfLongestSubstring(String s) {
    HashMap<Character, ArrayList<SubstringIndeces>> map = new HashMap<>();
    char[] inputChars = s.toCharArray();

    for (int i = 0; i < s.length(); i++) {
      
      char character = inputChars[i];

      if (!map.containsKey(character)) {
        ArrayList<SubstringIndeces> list = new ArrayList<>();
        list.add(new SubstringIndeces(i));
        map.put(character, list);
        continue;
      } 

      ArrayList<SubstringIndeces> list = map.get(character);
      list.get(list.size() - 1).setEndIndex(i);
      list.add(new SubstringIndeces(i));

      map.put(character, list);

    }

    int bestLength = 0; 

    for (Map.Entry<Character, ArrayList<SubstringIndeces>> entry : map.entrySet()) {
      for (SubstringIndeces substringIndeces : entry.getValue()) {
        
        System.out.println(entry.getKey() + " " + substringIndeces.getStartIndex() + " " + substringIndeces.getEndIndex());
        int length;
        
        
        if (substringIndeces.getEndIndex() == -1) {
          length = s.length() - substringIndeces.getStartIndex();
        } else {
          length = substringIndeces.getEndIndex() - substringIndeces.getStartIndex();
        }



        if (length > bestLength) {
          bestLength = length;
        }
      }
    }

    System.out.println("length" + " " + s.length());


    return bestLength;
  }
}