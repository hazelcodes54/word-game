public class Word implements Comparable<Word> {
    private String word;

    public Word(String word) {
        this.word = word.toUpperCase();
    }

    public String getWord() {
        return word;
    }

    @Override
    public int compareTo(Word anotherWord) {
        return this.word.compareTo(anotherWord.getWord());
    }

    @Override
    public String toString() {
        return word;
    }
}
