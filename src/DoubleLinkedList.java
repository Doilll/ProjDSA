public class DoubleLinkedList<T> {
    private Node head,tail;

    public boolean isEmpty(){
        return head == null;
    }

    public void insertAtHead(T data) {
        Node<T> newNode = new Node<>(data);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        }
        else {
            newNode.setNext(head);
            head.setPrev(newNode);
            head = newNode;
        }
    }

    public void insertAtTail(T data) {
        Node<T> newNode = new Node<>(data);
        if(isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            tail.setNext(newNode);
            newNode.setPrev(tail);
            tail = newNode;
        }
    }

    public void printList() {
        Node current = head;
        System.out.print("data: ");
        while(current != null) {
            System.out.print(current.getData()+" ");
            current = current.next;
        }
        System.out.println();
    }
}
