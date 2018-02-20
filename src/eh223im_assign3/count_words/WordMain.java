package eh223im_assign3.count_words;

public class WordMain {
    public static void main(String[] args) {
        Word f = new Word("hEllo");
        Word s = new Word("heLLo");

        System.out.println(f.hashCode());
        System.out.println(s.hashCode());

        System.out.println(Character.getNumericValue('c') + " " + Character.getNumericValue('C'));
    }
}
