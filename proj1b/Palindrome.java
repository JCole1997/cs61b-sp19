public class Palindrome {

    public Deque<Character> wordToDeque(String word) {
        LinkedListDeque<Character> L = new LinkedListDeque<>();
        for (int i = 0; i < word.length(); i++) {
            L.addLast(word.charAt(i));
        }
        return L;
    }

    public boolean isPalindrome(String word) {
//        iteration way
//        if (word.length() == 1 || word.length() == 0) {
//            return true;
//        } else {
//            for (int i = 0; i < word.length() / 2; i++) {
//                if(word.charAt(i) != word.charAt(word.length()-1-i))
//                    return false;
//            }
//            return true;
//        }
        Deque<Character> D = wordToDeque(word);
        return isPalindromeHelper(D);
    }

    public boolean isPalindromeHelper(Deque D) {
        if (D.size() <= 1) {
            return true;
        } else if (D.removeFirst() == D.removeLast()) {
            return isPalindromeHelper(D);
        } else {
            return false;
        }
    }

    public boolean isPalindrome(String word, CharacterComparator C) {
        Deque<Character> D = wordToDeque(word);
        return isPalindromeHelper(D, C);
    }

    public boolean isPalindromeHelper(Deque D, CharacterComparator C) {
        if (D.size() <= 1) {
            return true;
        } else if (C.equalChars((char)D.removeFirst(), (char)D.removeLast())) {
            return isPalindromeHelper(D, C);
        } else {
            return false;
        }
    }

}
