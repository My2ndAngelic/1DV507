package eh223im_assign3.count_words;

import java.util.Iterator;

public class TreeWordSet implements WordSet {
    private Word[] words;
    private int length;

    public TreeWordSet() {
        words = new Word[10];
        length = 0;
    }

    @Override
    public void add(Word word) {

    }

    @Override
    public boolean contains(Word word) {
        for (Word w : words) {
            if (word.equals(w)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int size() {
        return length;
    }

    @Override
    public Iterator iterator() {
        return new TreeWordSetIterator();
    }

    class TreeWordSetIterator implements Iterator<Word> {

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public Word next() {
            return null;
        }

        @Override
        public void remove() {
            throw new RuntimeException("remove() is not implemented.");
        }
    }
}
