/**
 * TaskQueue
 */
public class TaskQueue {
    Node front, rear;

    public TaskQueue() {
        this.front = this.rear = null;
    }

    // Add a new task to queue
    void enqueue(Task task) {
        Node newNode = new Node(task);

        if (this.rear == null) {
            this.front = this.rear = newNode;
            return;
        }

        this.rear.next = newNode;
        this.rear = newNode;
    }
}
