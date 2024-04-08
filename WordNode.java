public class WordNode {
    protected Word data; // This should be the word object
    protected WordNode next; // This should be the reference to the next node

    public WordNode(Word data) {
        this.data = data;
        this.next = null;
    }
}
