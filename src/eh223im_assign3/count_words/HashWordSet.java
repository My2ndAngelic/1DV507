package eh223im_assign3.count_words;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class HashWordSet implements WordSet {

    // This will not work

    private int size;
    private WordNode[] bucket;
    private WordNode hs;

    HashWordSet() {
        size = 0;
        bucket = new WordNode[10];
        hs = null;
    }

    // Add words
    @Override
    public void add(Word w) {
        int pos = getArrPos(w);
        WordNode node = bucket[pos];

        // Checking
        while (node != null) {
            if (node.value.equals(w)) {
                return;
            } else {
                node = node.next;
            }
        }

        // Working here
        node = new WordNode(w);
        node.next = bucket[pos];
        bucket[pos] = node;
        size++;

        if (size == bucket.length) {
            rehash();
        }

        // Adding new node
//        if (hs == null) {
//            hs = new WordNode(w);
//        } else {
//            while (hs.next != null) {
//                if (w.compareTo(hs.value) < 0) {
//                    hs = new WordNode(w);
//                } else if (w.compareTo(hs.value) > 0) {
//                    hs = hs.next;
//                    hs = new WordNode(w);
//                }
//            }
//        }
    }

    // Get position of the word to hash
    private int getArrPos(Word w) {
        int hash = w.hashCode();

        if (hash < 0) {
            hash = -hash;
        }
        while (hash > bucket.length) {
            rehash();
        }
        return hash;
//        if (bucket.length < hash) {
//            return hash % bucket.length;
//        } else return bucket.length % hash;
    }

    @Override
    public boolean contains(Word w) {
        int pos = getArrPos(w);
        WordNode node = bucket[pos];
        while (node != null) {
            if (node.value.equals(w)) {
                return true;
            } else {
                node = node.next;
            }
        }
        return false;
    }

    // Print
    public String print() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        while (iterator().hasNext()) {
            sb.append(iterator().next().toString()).append(", ");
        }

        sb.replace(sb.length() - 2, sb.length() - 1, "]");
        return sb.toString();
    }

    // Rehash
    private void rehash() {
        WordNode[] temp = bucket;
        bucket = new WordNode[bucket.length * 2];
        size = 0;

        for (WordNode wn : temp) {
            if (wn == null)
                continue;

            while (wn != null) {
                add(wn.value);
                wn = wn.next;
            }
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator iterator() {
        return new HashWordSetIterator(bucket, size);
    }

    private class WordNode { // Private inner Node class
        Word value;
        WordNode next;

        public WordNode(Word word) {
            value = word;
        }

        public Word getValue() {
            return value;
        }
    }

    class HashWordSetIterator implements Iterator<Word> {

        private final int size;
        // First node is root
        private Word[] currArr;
        private int currPos = -1;

        // The traversal starts with the root node.
        HashWordSetIterator(WordNode[] WArr, int size) {
            currArr = new Word[size];
            int k = 0;
            // Array cloning
            try {
                for (WordNode n : WArr) {
                    if (n != null) {
                        currArr[k] = n.value;
                        k++;
                    }
                }
            } catch (NullPointerException ignored) {

            }
            this.size = size;
        }

        public Word next() {
            if (hasNext()) {
                currPos++;
                System.out.println(Arrays.toString(currArr));
//                System.out.println(currArr[currPos].toString());
                System.out.println(currArr.length);
                return currArr[currPos];
            } else {
                throw new NoSuchElementException("No more element found");
            }
        }

        public boolean hasNext() {
            return currPos < size;
        }

        public void remove() {
            throw new RuntimeException("remove() is not implemented");
        }
    }
}
