public class Node<T> {

    T data;
    Node<T> next,prev;

    public Node(T data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public void setPrev(Node<T> prev) {
        this.prev = prev;
    }

    public Node<T> getNext() {
        return next;
    }

    public Node<T> getPrev() {
        return prev;
    }

    public T getData() {
        return data;
    }
}
