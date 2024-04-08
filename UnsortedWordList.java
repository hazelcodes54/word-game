// UnsortedWordList.java
public class UnsortedWordList extends WordList {

    @Override
    public void add(Word word) {
        append(word);
    }

    public boolean contains(Word word) {
        WordNode current = head;
        while (current != null) {
            if (current.data.equals(word)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public void remove(Word word) {
        WordNode current = head;
        WordNode prev = null;
        while (current != null) {
            if (current.data.equals(word)) {
                if (prev == null) {
                    head = current.next;
                } else {
                    prev.next = current.next;
                }
                length--;
                return;
            }
            prev = current;
            current = current.next;
        }
    }
}
