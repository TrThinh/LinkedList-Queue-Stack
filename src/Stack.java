public class Stack {
    private Node top;

    public Stack() {
        top = null;
    }

    public void push(String data) {
        Node newNode = new Node(data);
        newNode.setNext(top);
        top = newNode;
    }

    public String pop() {
        if (top == null) {
            return null;
        }
        String data = top.getData();
        top = top.getNext();
        return data;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void printStack() {
        Node curr = top;
        while (curr != null) {
            System.out.println(curr.getData());
            curr = curr.getNext();
        }
    }
}
