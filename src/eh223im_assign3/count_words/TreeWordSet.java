package eh223im_assign3.count_words;

import java.util.ArrayList;
import java.util.Iterator;

public class TreeWordSet implements WordSet {

    private int length; // Current size
    private WordNode root;

    private ArrayList<Word> wordArrayList = new ArrayList<>();
    public TreeWordSet() {
        length = 0;
        root = null;
    }

    public void add(Word word) {
        if (root == null) {
            root = new WordNode(word);
            length++;
        } else {
            root.add(word);
        }
    }

    //    @Override
    public String print() {
        return root.print();
    }

    @Override
    public boolean contains(Word word) {
        return root != null && root.contains(word);
    }

    @Override
    public Iterator iterator() {
        return new TreeWordSetIterator(wordArrayList, size());
    }

    @Override
    public int size() {
        return length;
    }

    private class WordNode { // Private inner Node class

        Word value;
        WordNode next = null;
        WordNode left;
        WordNode right;
        WordNode parent;
        String outstring = "";
        StringBuilder sb = new StringBuilder();
        String[] outstrarr = new String[length];

        WordNode(Word word) {
            value = word;
            left = right = null;
        }

        // Add words
        void add(Word w) {
            if (w.compareTo(value) < 0) {
                if (left == null) {
                    left = new WordNode(w);
                    length++;
                } else {
                    left.add(w);
                }
            } else if (w.compareTo(value) > 0) {
                if (right == null) {
                    right = new WordNode(w);
                    length++;
                } else {
                    right.add(w);
                }
            }
        }

        boolean contains(Word w) {
            if (w.compareTo(value) < 0) {
                return left != null && left.contains(w);
            } else if (w.compareTo(value) > 0) {
                return right != null && right.contains(w);
            }
            return true;
        }

        private void printS() {
            if (left != null) {
                left.printS();
            }
            wordArrayList.add(value);
            if (right != null) {
                right.printS();
            }
        }

        String print() {
            printS();
            return wordArrayList.toString();
        }
    }

    // Adopted from: https://stackoverflow.com/questions/33788654/inorder-iterator-for-binary-tree-java
    public class TreeWordSetIterator implements Iterator<Word> {

        private final int size;
        private Word[] nodeArr = new Word[wordArrayList.size()];
        private Word wordNode;
        private int current;

        TreeWordSetIterator(ArrayList<Word> wordArrayList, int size) {
            for (int i = 0; i < wordArrayList.size(); i++) {
                nodeArr[i] = wordArrayList.get(i);
            }
            current = 0;
            this.size = size;
        }

        public Word next() {
            Word w;
            if (hasNext()) {
                w = nodeArr[current];
                current++;
                return w;
            } else {
                throw new ArrayIndexOutOfBoundsException("No more element");
            }
        }

        public boolean hasNext() {
            return current < size;
        }

        public void remove() {
            throw new RuntimeException("remove() is not implemented");
        }
    }
}
