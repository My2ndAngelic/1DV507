package eh223im_assign3.count_words;

public class WordMain {
    public static void main(String[] args) {
        Word f = new Word("Gay");
        Word s = new Word("gAy");

        System.out.println(f.hashCode());
        System.out.println(s.hashCode());

        System.out.println(Character.getNumericValue('c') + " " + Character.getNumericValue('C'));
    }
}
