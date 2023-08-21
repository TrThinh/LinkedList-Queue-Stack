import java.util.*;
import java.util.InputMismatchException;
import java.io.IOException;

public class Main{
    public static void main(String[] args) {
        Queue messageQueue = new Queue();
        Stack messageStack = new Stack();
        Receiver receiver = new Receiver(messageQueue, messageStack);
        long startTime = System.currentTimeMillis();

        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("=====Send message system=====");
            System.out.println("||  1. Sent a message      ||");
            System.out.println("||  2. Receive message     ||");
            System.out.println("||  3. View Queue          ||");
            System.out.println("||  4. View Stack          ||");
            System.out.println("||  5. Exit program        ||");

            System.out.print("Choose an option: ");
            int choice;
            String message;

            try {
                choice = input.nextInt();
                input.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("");
                System.out.println("-----------------------------");
                System.out.println("Just choice from 1 to 5. Please choice again");
                System.out.println("-----------------------------");
                System.out.println("");
                input.nextLine();
                continue;
            }

            switch (choice){
                case 1:
                    long sentMessage = System.currentTimeMillis();
                    System.out.print("\nEnter your message: ");
                    message = input.nextLine();

                    if (message.length() > 250) {
                        System.out.println("");
                        System.out.println("-----------------------------");
                        System.out.println("\nError message is more 250\n");
                        System.out.println("-----------------------------");
                        System.out.println("");
                        break;
                    }
                    if (message.length() < 1) {
                        System.out.println("");
                        System.out.println("-----------------------------");
                        System.out.println("\nError message is less 1\n");
                        System.out.println("-----------------------------");
                        System.out.println("");
                        break;
                    }
                        messageQueue.enqueue(message);
                    long endSentMessage = System.currentTimeMillis();
                    long elapsedTimeSent =endSentMessage - sentMessage;
                    System.out.println("Elapsed time: " + elapsedTimeSent + " miliseconds");
                    break;
                case 2:
                    System.out.println("");
                    System.out.println("-----------Receive-----------");
                    receiver.receiveMessage();
                    break;
                case 3:
                    System.out.println("");
                    System.out.println("------------Queue------------");
                    receiver.printQueue();
                    break;
                case 4:
                    System.out.println("");
                    System.out.println("------------Stack------------");
                    receiver.printStack();
                    break;
                case 5:
                    System.out.println("");
                    System.out.println("Exiting program...");

                    long endTime = System.currentTimeMillis();
                    long elapsedTime = (endTime - startTime) / 1000;
                    System.out.println("Elapsed time: " + elapsedTime + " seconds");
                    System.exit(0);
                default:
                    System.out.println("");
                    System.out.println("-----------------------------");
                    System.out.println("Invalid choice. Please choose again");

                    break;
            }
            System.out.println("-----------------------------");
            System.out.println("");

        }
    }
}
