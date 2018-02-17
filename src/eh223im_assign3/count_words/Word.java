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
    @Override
    public int hashCode() {
        // In class
        int hV = 0;
        for (char aC : word.toCharArray()) {
            hV += Character.getNumericValue(aC);
        }
        return hV;

////    Apache Common Codec library - Maven
//        try {
//            String s = DigestUtils.sha1Hex(word.getBytes("UTF-8"));
//            char[] c = s.toCharArray();
//            int hash = 0;
//            for (char aC : c) {
//                hash += Character.getNumericValue(aC);
//            }
//            return hash;
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//        return -1;
    }

    public int hashCode(char c) {
        return Character.getNumericValue(c);
    }

    //... true if two words are equal
    @Override
    public boolean equals(Object other) {
        if (other instanceof Word) {
            Word otherWord = (Word) other;
            return word.equals(otherWord.word);
        } return false;
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

    public String getWord() {
        return word;
    }
}
