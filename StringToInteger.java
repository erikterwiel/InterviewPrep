class Solution {
  public int myAtoi(String str) {
    boolean started = false;
    boolean negative = false;
    int startIndex = 0;
    int endIndex = str.length();

    for (int i = 0; i < str.length(); i++) {
      char single = str.charAt(i);
      if (started) {
        if (single < 48 || single > 57) {
          endIndex = i;
          break;
        }
      } else {
        if (single == 45) {
          negative = true;
          if (i == str.length() - 1 || str.charAt(i + 1) < 48 || str.charAt(i + 1) > 57) {
            return 0;
          } 
        } else if (single == 43) {
          if (i == str.length() - 1 || str.charAt(i + 1) < 48 || str.charAt(i + 1) > 57) {
            return 0;
          } 
        } else if (single >= 48 && single <= 57) {
          startIndex = i;
          started = true;
        } else if (single != 32) {
          return 0;
        }
      }
    }

    if (!started) {
      return 0;
    }

    String numberString = str.substring(startIndex, endIndex);
    int power = numberString.length() - 1;
    long result = 0;

    for (int i = 0; i < numberString.length(); i++) {
      int base = ((int) numberString.charAt(i)) - 48;
      result += base * Math.pow(10, power);
      power--;
    }

    if (negative) {
      result *= -1;
    }

    if (result < Integer.MIN_VALUE) {
      return Integer.MIN_VALUE;
    }
    if (result > Integer.MAX_VALUE) {
      return Integer.MAX_VALUE;
    }
    return (int) result;
  }
}
