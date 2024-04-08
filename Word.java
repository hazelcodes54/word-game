public class Word implements Comparable<Word> {
    private String word;

    public Word(String word) {
        this.word = word.toUpperCase(); // Assuming words are case-insensitive
    }

    public String getWord() {
        return this.word;
    }

    @Override
    public int compareTo(Word other) {
        return this.word.compareTo(other.word);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Word wordObj = (Word) o;
        return word.equals(wordObj.word);
    }

    @Override
    public int hashCode() {
        return word.hashCode();
    }
}
