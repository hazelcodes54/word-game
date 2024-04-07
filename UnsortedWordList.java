public class UnsortedWordList extends WordList {

    @Override
    public void add(Word word) {
        WordNode newNode = new WordNode(word);
        if (head == null) {
            head = newNode;
        } else {
            WordNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        length++;
    }
}
