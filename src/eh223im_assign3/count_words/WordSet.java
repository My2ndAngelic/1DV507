package eh223im_assign3.count_words;

import java.util.Iterator;

public interface WordSet extends Iterable {
    void add(Word word); // Add word if not already added
    boolean contains(Word word); // Return true if word contained
    int size(); // Return current set size
    String toString(); // Print contained words

    @Override
    Iterator iterator();
}
