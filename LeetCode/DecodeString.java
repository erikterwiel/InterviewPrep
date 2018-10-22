class Solution {
  public String decodeString(String s) {     
    return helper(s, 0, 1);
  }

  public String helper(String s, int index, int multiplier) {
    StringBuilder builder = new StringBuilder();
    StringBuilder digit = new StringBuilder();
    for (int i = index; i < s.length; i++) {
      if (Character.isDigit(s.charAt(i))) {
        builder.append(s.charAt(i));
      } else if (s.charAt(i) == '[') {

      } else if (s.charAt(i) == ']') {

      } else {

      }
    }

    return applyMultiplier(builder.toString, multiplier);
    StringBuilder toReturn = new StringBuilder();
    for (int i = 0; i < multiplier; i++) {
      toReturn.append(builder.toString());
    }
    return toReturn;
  }

  applyMultiplier
}