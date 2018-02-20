package eh223im_assign3.count_words;

public class Word implements Comparable<Word> {
    private String word;
    private int length;

    // Constructor
    public Word() {
        word = "";
        length = word.length();
    }

    // Shorthand constructor
    public Word(String str) {
        word = str;
        length = str.length();
    }

    public void setWord(String str) {
        word = str;
        length = str.length();
    }

    /*
     * Override Object methods
     */
    @Override
    public String toString() {
        return word;
    }

    //... compute a hash value for word
    // Return representation of the character, expect 'C' and 'c' be the same.
    // Not guarantee to work properly
    // Maybe merge sort can solves ???
    @Override
    public int hashCode() {
//         In class
        int hV = 0;
        char[] c = word.toCharArray();
        for (int i = 0; i < c.length; i++) {
            hV += 37 * (Character.getNumericValue(c[i])) * (i + 1) + (i + 1);
        }
        return hV;
//        return word.toUpperCase().hashCode();
    }

    //... true if two words are equal
    @Override
    public boolean equals(Object other) {
        if (other instanceof Word) {
            if (((Word) other).length != word.length()) {
                return false;
            } else {
                char[] c = other.toString().toUpperCase().toCharArray();
                char[] c2 = word.toUpperCase().toCharArray();

                for (int i = 0; i < c.length; i++) {
                    if (c[i] != c2[i]) {
                        return false;
                    }
                }
                return true;
            }
        } else {
            return false;
        }
    }

    /*
     * Compare each and individual position
     * Return -1 if smaller, 0 if equal and 1 if larger
     * Compare word: compare each position in alphabetical order
     * If one word is longer, it is larger lexicographically
     */
    @Override
    public int compareTo(Word w) {
        for (int i = 0; i < w.getLength() && i < word.length(); i++) {
            if (Character.getNumericValue(word.charAt(i)) < Character.getNumericValue(w.getWord().charAt(i))) {
                return -1;
            } else if (Character.getNumericValue(word.charAt(i)) > Character.getNumericValue(w.getWord().charAt(i))) {
                return 1;
            }
        }
        return Integer.compare(word.length(), w.getLength());
    }

    /*
     * return length
     */
    public int getLength() {
        return length;
    }

    // eturn word
    public String getWord() {
        return word;
    }
}
