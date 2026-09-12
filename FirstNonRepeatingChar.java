import java.util.LinkedHashMap;
import java.util.Map;

public class FirstNonRepeatingChar {

    public static char findFirstNonRepeatingChar(String text) {
        int[] freq = new int[256];

        for (int i = 0; i < text.length(); i++) {
            freq[text.charAt(i)]++;
        }

        for (int i = 0; i < text.length(); i++) {
            if (freq[text.charAt(i)] == 1) {
                return text.charAt(i);
            }
        }

        return '\0'; // Return null character if none found
    }

    public static void testCharacterSearch(String text) {
        System.out.println("Input: \"" + text + "\"");
        char result = findFirstNonRepeatingChar(text);
        if (result != '\0') {
            System.out.println("First Non-Repeating Character: '" + result + "'");
        } else {
            System.out.println("No Non-Repeating Character Found");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        testCharacterSearch("swiss");
        testCharacterSearch("aabbcc");
    }
}