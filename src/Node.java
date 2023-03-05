public class Node<T> {
    T abbreviation;
    T expansion;
    Node<T> next;
    Node<T> tail;

    Node(T abbreviation, T expansion) {
        this.abbreviation = abbreviation;
        this.expansion = expansion;
        this.next = this.tail = null;
    }

    public T getAbbreviation() {
        return abbreviation;
    }

    public T getExpansion() {
        return expansion;
    }

    public void setAbbreviation(T abbreviation) {
        this.abbreviation = abbreviation;
    }

    public void setExpansion(T expansion) {
        this.expansion = expansion;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public Node<T> getNext() {
        return next;
    }

    public Node<T> getTail() {
        return tail;
    }

    public void setTail(Node<T> tail) {
        this.tail = tail;
    }
}
