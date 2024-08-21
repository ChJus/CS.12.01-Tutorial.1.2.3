import java.util.ArrayList;
import java.util.List;

public class Scramble {
  static String scrambleWord(String word) {
    String result = "";

    for (int i = 0; i < word.length(); i++) {
      // Check if character is last in word, if so, skip check.
      // Otherwise, check if there are two consecutive As. If so, swap their order.
      // Note the index increment prevents the pair of swapped characters from being
      // checked again in future iterations.
      if (i + 1 < word.length() && word.charAt(i) == 'A' && word.charAt(i + 1) != 'A') {
        result += word.charAt(i + 1) + "" + word.charAt(i); // Swap order
        i++;
      } else { // Otherwise keep letter in same position.
        result += word.charAt(i);
      }
    }

    return result;
  }

  static void scrambleOrRemove(List<String> words) {
    // Performs scramble on a list of words, and removes words that are the same after scrambling.
    // The result is temporarily stored in a new ArrayList to prevent ConcurrentModificationException
    // caused by modifying the size of the array in a loop iterating through the array.
    ArrayList<String> result = new ArrayList<>();
    for (String word : words) {
      if (!word.equals(Scramble.scrambleWord(word))) result.add(Scramble.scrambleWord(word));
    }

    // Modify the original array to contain the remaining words
    words.clear();
    words.addAll(result);
  }
}
