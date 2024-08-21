import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ScrambleTest {
  @Test
  void scrambleWord() {
    assertEquals("TNA", Scramble.scrambleWord("TAN"));
    assertEquals("BARCADABARA", Scramble.scrambleWord("ABRACADABRA"));
    assertEquals("WHOA", Scramble.scrambleWord("WHOA"));
    assertEquals("ARADVRAK", Scramble.scrambleWord("AARDVARK"));
    assertEquals("EGGS", Scramble.scrambleWord("EGGS"));
    assertEquals("A", Scramble.scrambleWord("A"));
    assertEquals("", Scramble.scrambleWord(""));
  }

  @Test
  void scrambleOrRemove() {
    String[] wordArray = {"TAN", "ABRACADABRA", "WHOA", "APPLE", "EGGS"};
    List<String> wordList = new LinkedList<>(Arrays.asList(wordArray));
    Scramble.scrambleOrRemove(wordList);
    assertEquals(3, wordList.size());
    assertEquals("TNA", wordList.get(0));
    assertEquals("BARCADABARA", wordList.get(1));
    assertEquals("PAPLE", wordList.get(2));
  }
}