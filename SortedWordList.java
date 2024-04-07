public class SortedWordList extends WordList {

    @Override
    public void add(Word word) {
        WordNode newNode = new WordNode(word);
        if (head == null || head.data.compareTo(word) > 0) {
            newNode.next = head;
            head = newNode;
        } else {
            WordNode current = head;
            while (current.next != null && current.next.data.compareTo(word) < 0) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
        length++;
    }
}
