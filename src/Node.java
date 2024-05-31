public class Node<T> {

    T data;
    Node next,prev;

    public Node(T data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    public Node getNext() {
        return next;
    }

    public Node getPrev() {
        return prev;
    }

    public T getData() {
        return data;
    }
}
