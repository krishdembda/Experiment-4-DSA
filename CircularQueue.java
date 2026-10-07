import java.util.Scanner;

public class CircularQueue {
    int[] queue;
    int front = -1, rear = -1, size, count = 0;

    CircularQueue(int size) {
        this.size = size;
        queue = new int[size];
    }

    boolean isFull() {
        return count == size;
    }

    boolean isEmpty() {
        return count == 0;
    }

    void enqueue(int job) {
        if (isFull()) {
            System.out.println("Queue is full! Cannot add print job " + job);
            return;
        }
        if (isEmpty()) {
            front = 0;
        }
        rear = (rear + 1) % size;
        queue[rear] = job;
        count++;
        System.out.println("Print job " + job + " added to queue.");
    }

    void dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty! No print job to complete.");
            return;
        }
        System.out.println("Print job " + queue[front] + " completed.");
        front = (front + 1) % size;
        count--;
        if (isEmpty()) {
            front = -1;
            rear = -1;
        }
    }

    void peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
        } else {
            System.out.println("Next print job: " + queue[front]);
        }
    }

    void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return;
        }
        System.out.print("Print queue (front -> rear): ");
        int i = front;
        for (int n = 0; n < count; n++) {
            System.out.print(queue[i] + " ");
            i = (i + 1) % size;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter queue size: ");
        CircularQueue q = new CircularQueue(sc.nextInt());
        int choice;

        do {
            System.out.println("\n--- Circular Queue (Printer) ---");
            System.out.println("1. Enqueue\n2. Dequeue\n3. Peek\n4. Display\n5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter print job number: ");
                    q.enqueue(sc.nextInt());
                    break;
                case 2:
                    q.dequeue();
                    break;
                case 3:
                    q.peek();
                    break;
                case 4:
                    q.display();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 5);
        sc.close();
    }
}