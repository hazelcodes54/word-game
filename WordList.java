public abstract class WordList {
    protected WordNode head; // Points to the first real node 
    protected int length;

    public WordList() {
        // Initially, the list is empty, so head is null and length is 0.
        this.head = null;
        this.length = 0;
    }

    public abstract void add(Word word); 

