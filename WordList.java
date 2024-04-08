import java.util.Iterator;
import java.util.NoSuchElementException;

public abstract class WordList implements Iterable<Word> {
    protected WordNode head;
    protected WordNode last;
    protected int length;

    public WordList() {
        this.head = new WordNode(null); // The dummy node is usually created with null data
        this.last = this.head;
        this.length = 0;
    }

    public abstract void add(Word word);

    public void append(Word word) {
        WordNode newNode = new WordNode(word);
        this.last.next = newNode;
        this.last = newNode;
        this.length++;
    }

    @Override
    public Iterator<Word> iterator() {
        return new Iterator<Word>() {
            private WordNode current = head.next; // Start after the dummy head

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public Word next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                Word data = current.data;
                current = current.next;
                return data;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }
}
