import java.security.PublicKey;

public class Queue {
    private Node front;
    private Node rear;

    public  Queue() {
        front = null;
        rear = null;
    }

    public void enqueue(String data) {
        Node newNode = new Node(data);
        if (rear == null) {
            front = newNode;
            rear = newNode;
        } else {
            rear.setNext(newNode);
            rear = newNode;
        }
    }

    public String dequeue(){
        if (front == null) {
            return null;
        }
        String data = front.getData();
        front = front.getNext();
        if (front == null){
            rear = null;
        }
        return data;
    }

    public boolean isEmpty(){
        return front == null;
    }

    public void printQueue() {
        Node current = front;
        while (current != null){
            System.out.println(current.getData());
            current = current.getNext();
        }
    }
}
