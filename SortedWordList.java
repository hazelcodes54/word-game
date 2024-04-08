
public class SortedWordList extends WordList {

    @Override
    public void add(Word word) {
        WordNode newNode = new WordNode(word);
        WordNode current = this.head;
        while (current.next != null && current.next.data.compareTo(word) < 0) {
            current = current.next;
        }
        newNode.next = current.next;
        current.next = newNode;

        // Update last if needed
        if (newNode.next == null) {
            this.last = newNode;
        }

        this.length++;
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
