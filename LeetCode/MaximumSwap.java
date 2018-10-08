class Solution {
  public int maximumSwap(int num) {
    
    // stores highest index of number
    int[] map = new int[128];
    for (int i = 48; i < 58; i++) {
      map[i] = -1;
    }

    String numString = Integer.toString(num);
    for (int i = 0; i < numString.length(); i++) {
      map[numString.charAt(i)] = i;
    }

    for (int i = 0; i < numString.length(); i++) {
      for (int j = 57; j >= 48; j--) {
        if (j > numString.charAt(i) && map[j] > i) {
          char[] charArray = numString.toCharArray();
          char temp = charArray[i];
          charArray[i] = charArray[map[j]];
          charArray[map[j]] = temp;
          StringBuilder builder = new StringBuilder();
          for (char digit : charArray) {
            builder.append(digit);
          }
          return Integer.parseInt(builder.toString());
        }
      }
    }
    
    return num;
  }
}