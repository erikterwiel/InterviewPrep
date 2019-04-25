import java.util.HashSet;

class Solution {
  public int numUniqueEmails(String[] emails) {
    HashSet<String> uniqueEmails = new HashSet<>();
    for (String email : emails) {
      StringBuilder resultEmail = new StringBuilder();
      boolean recordString = true;
      boolean foundAtChar = false;
      for (char letter : email.toCharArray()) {
        if (letter == '+' && !foundAtChar) {
          recordString = false;
        } else if (letter == '@') {
          recordString = true;
          foundAtChar = true;
          resultEmail.append(letter);
        } else if (letter == '.' && foundAtChar) {
          resultEmail.append(letter);
        } else if (letter != '.' && recordString) {
          resultEmail.append(letter);
        }
      }
      uniqueEmails.add(resultEmail.toString());
    }
    return uniqueEmails.size();
  }
}