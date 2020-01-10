/** This class outputs all palindromes in the words file in the current directory. */
public class PalindromeFinder {
    public static void main(String[] args) {
        int minLength = 4;
        In in = new In("D:/cs61b/cs61b-sp19/library-sp19/data/words.txt");
        Palindrome palindrome = new Palindrome();
        OffByOne O = new OffByOne();

        while (!in.isEmpty()) {
            String word = in.readString();
            if (word.length() >= minLength && palindrome.isPalindrome(word, O)) {
                System.out.println(word);
            }
        }
    }
}