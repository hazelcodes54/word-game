public class WordNode {
    protected Word data;
    protected WordNode next;

    public WordNode(Word w) {
        this.data = w;
        this.next = null;  //the next node doesn't exist.
    }
}
