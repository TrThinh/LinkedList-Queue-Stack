public class Receiver {
    private Queue messageQueue;
    private Stack messageStack;

    public Receiver(Queue queue, Stack stack){
        messageQueue = queue;
        messageStack = stack;
    }

    public void receiveMessage() {
        long receiveMessage = System.nanoTime();

        if (messageQueue.isEmpty()) {
            System.out.println("Error: Message queue is empty");
            return;
        }
        String message = messageQueue.dequeue();
        System.out.println("Received message: " + message);
        messageStack.push(message);

        long endReceiveMessage = System.nanoTime();
        long elapsedTimeReceive = endReceiveMessage - receiveMessage;
        System.out.println("Elapsed time: " + elapsedTimeReceive + " nanoseconds");
    }

    public void printStack() {
        long printStackMessage = System.nanoTime();

        if (messageStack.isEmpty()){
            System.out.println("Error: Message stack is empty");
            return;
        }
        System.out.println("Message stack: ");
        messageStack.printStack();

        long endPrintStackMessage = System.nanoTime();
        long elapsedTimePrintS = endPrintStackMessage - printStackMessage;
        System.out.println("Elapsed time: " + elapsedTimePrintS + " nanoseconds");
    }

    public void printQueue() {
        long printQueueMessage = System.nanoTime();

        if (messageQueue.isEmpty()){
            System.out.println("Error: Message queue is empty");
            return;
        }
        System.out.println("Message queue: ");
        messageQueue.printQueue();

        long endPrintQueueMessage = System.nanoTime();
        long elapsedTimePrintQ = endPrintQueueMessage - printQueueMessage;
        System.out.println("Elapsed time: " + elapsedTimePrintQ + " nanoseconds");
    }
}
